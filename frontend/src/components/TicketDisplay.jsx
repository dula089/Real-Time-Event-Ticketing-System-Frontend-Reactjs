import React from "react";

const TicketDisplay = ({ tickets }) => {
  return (
    <div className="p-4 bg-white shadow rounded max-w-4xl mx-auto">
      <h2 className="text-xl font-bold mb-4 text-center">
        Current Ticket Availability
      </h2>
      <div className="grid grid-cols-3 gap-4">
        {tickets.map((ticket, index) => (
          <div
            key={index}
            className="p-2 bg-gray-100 rounded shadow text-gray-700 text-center"
          >
            Ticket #{ticket.id} - Status: {ticket.status}
          </div>
        ))}
      </div>
    </div>
  );
};

export default TicketDisplay;
