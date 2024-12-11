import React, { useState, useEffect } from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import ConfigurationForm from "./components/ConfigurationForm";
import TicketDisplay from "./components/TicketDisplay";
import ControlPanel from "./components/ControlPanel";
import LogDisplay from "./components/LogDisplay";
import Loader from "./components/Loader";
import NavBar from "./components/NavBar";
import axios from "axios";

function App() {
  const [formData, setFormData] = useState({
    totalTickets: "",
    ticketReleaseRate: "",
    customerRetrievalRate: "",
    maxTicketCapacity: "",
  });

  const [tickets, setTickets] = useState([]);
  const [logs, setLogs] = useState([]);
  const [running, setRunning] = useState(false);
  const [loading, setLoading] = useState(false);
  const [submissionSuccess, setSubmissionSuccess] = useState(false);
  const [errors, setErrors] = useState({
    totalTickets: "",
    ticketReleaseRate: "",
    customerRetrievalRate: "",
    maxTicketCapacity: "",
  });

  const [submissions, setSubmissions] = useState([]);
  const [statusMessage, setStatusMessage] = useState("");

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData({ ...formData, [name]: value });
    setErrors({ ...errors, [name]: "" });
  };

  const validateForm = () => {
    const newErrors = {};
    if (!formData.totalTickets) {
      newErrors.totalTickets = "* Total Tickets is required";
    }
    if (!formData.ticketReleaseRate) {
      newErrors.ticketReleaseRate = "* Ticket Release Rate is required";
    }
    if (!formData.customerRetrievalRate) {
      newErrors.customerRetrievalRate = "* Customer Retrieval Rate is required";
    }
    if (!formData.maxTicketCapacity) {
      newErrors.maxTicketCapacity = "* Max Ticket Capacity is required";
    }
    return newErrors;
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    const newErrors = validateForm();
    setErrors(newErrors);

    if (Object.keys(newErrors).length > 0) {
      return;
    }

    try {
      setLoading(true);
      setSubmissionSuccess(false);

      const response = await axios.post(
        "http://localhost:8081/api/configuration",
        formData
      );

      if (response.status === 201) {
        setSubmissions([response.data]);

        const log = {
          saleId: Math.floor(Math.random() * 1000).toString(),
          dateTime: new Date().toLocaleString(),
          message: "Configuration submitted successfully!",
        };

        await saveLog(log);

        const initializedTickets = Array.from(
          { length: parseInt(formData.totalTickets) },
          (_, i) => ({ id: i + 1, status: "Available" })
        );
        setTickets(initializedTickets);
        setSubmissionSuccess(true);

        setTimeout(() => {
          setSubmissionSuccess(false);
        }, 3000);
      }
    } catch (error) {
      console.error("Error submitting form:", error);
      const errorLog = {
        saleId: Math.floor(Math.random() * 1000).toString(),
        dateTime: new Date().toLocaleString(),
        message: "Error submitting configuration",
      };

      await saveLog(errorLog);
    } finally {
      setLoading(false);
    }
  };

  const saveLog = async (log) => {
    try {
      await axios.post("http://localhost:8081/api/logs", log);
      setLogs((prevLogs) => [...prevLogs, log]);
    } catch (error) {
      console.error("Error saving log:", error);
    }
  };

  const handleStart = async () => {
    setRunning(true);
    setStatusMessage("System started.");
    const log = {
      saleId: Math.floor(Math.random() * 1000).toString(),
      dateTime: new Date().toLocaleString(),
      message: "System started.",
    };
    await saveLog(log);
    setTimeout(() => setStatusMessage(""), 3000);
  };

  const handleStop = async () => {
    setRunning(false);
    setStatusMessage("System stopped.");
    const log = {
      saleId: Math.floor(Math.random() * 1000).toString(),
      dateTime: new Date().toLocaleString(),
      message: "System stopped.",
    };
    await saveLog(log);
    setTimeout(() => setStatusMessage(""), 3000);
  };

  const handleReset = async () => {
    setRunning(false);
    setStatusMessage("System reset.");
    setFormData({
      totalTickets: "",
      ticketReleaseRate: "",
      customerRetrievalRate: "",
      maxTicketCapacity: "",
    });
    setTickets([]);
    setLogs([]);
    setErrors({
      totalTickets: "",
      ticketReleaseRate: "",
      customerRetrievalRate: "",
      maxTicketCapacity: "",
    });
    setSubmissionSuccess(false);
    const log = {
      saleId: Math.floor(Math.random() * 1000).toString(),
      dateTime: new Date().toLocaleString(),
      message: "System reset.",
    };
    await saveLog(log);
    setTimeout(() => setStatusMessage(""), 3000);
  };

  useEffect(() => {
    if (running) {
      const interval = setInterval(() => {
        setTickets((prevTickets) => {
          const updatedTickets = [...prevTickets];
          const availableTicket = updatedTickets.find(
            (t) => t.status === "Available"
          );
          if (availableTicket) {
            availableTicket.status = "Sold";
            const log = {
              saleId: availableTicket.id,
              dateTime: new Date().toLocaleString(),
              message: `Ticket #${availableTicket.id} sold.`,
            };
            saveLog(log);
          }
          return updatedTickets;
        });
      }, 1000 / formData.customerRetrievalRate);
      return () => clearInterval(interval);
    }
  }, [running, formData.customerRetrievalRate]);

  if (loading) {
    return <Loader />;
  }

  return (
    <div className="bg-gray-200">
      <Router>
        <NavBar />
        <Routes>
          <Route
            path="/config"
            element={
              <div>
                <div className="flex flex-col items-start space-y-2 bg-white">
                  {submissions.map((submission, index) => (
                    <div
                      key={index}
                      className="p-2 rounded shadow-md w-full text-sm"
                    >
                      <span>
                        <strong className="px-16 text-xl">
                          Total Tickets: {submission.totalTickets}{" "}
                        </strong>
                      </span>
                      <span>
                        <strong className="px-16 text-xl">
                          Ticket Release Rate: {submission.ticketReleaseRate}{" "}
                        </strong>
                      </span>
                      <span>
                        <strong className="px-16 text-xl">
                          Customer Retrieval Rate:{" "}
                          {submission.customerRetrievalRate}
                        </strong>{" "}
                      </span>
                      <span>
                        <strong className="px-16 text-xl">
                          Max Ticket Capacity: {submission.maxTicketCapacity}
                        </strong>
                      </span>
                    </div>
                  ))}
                </div>
                <br />
                {submissionSuccess && (
                  <div className="flex justify-center items-center min-h-5">
                    <div className="text-center text-green-500 font-semibold rounded py-5 px-6 text-base mb-3 w-1/3 bg-green-100">
                      Form Submitted Successfully!
                    </div>
                  </div>
                )}
                <ConfigurationForm
                  formData={formData}
                  handleChange={handleChange}
                  handleSubmit={handleSubmit}
                  errors={errors}
                />
                {statusMessage && (
                  <div className="flex justify-center items-center min-h-5">
                    <div className="text-center text-lg text-green-500 mt-4 py-5 px-6 bg-green-100 w-1/3 rounded font-semibold ">
                      {statusMessage}
                    </div>
                  </div>
                )}
                <br />
                <ControlPanel
                  onStart={handleStart}
                  onStop={handleStop}
                  onReset={handleReset}
                />
                <br />
                <TicketDisplay tickets={tickets} />
              </div>
            }
          />
          <Route path="/logs" element={<LogDisplay logs={logs} />} />
        </Routes>
      </Router>
    </div>
  );
}

export default App;
