import React from "react";

function ConfigurationForm() {
  return (
    <div className="flex items-center justify-center min-h-screen bg-gray-100">
      <form className="bg-white shadow-md rounded px-8 pt-6 pb-8 mb-4">
        <div className="mb-6">
          <label
            className="block text-gray-700 text-sm font-bold mb-2"
            for="totalTickets"
          >
            Total Tickets:
          </label>
          <input
            type="number"
            name="totalTickets"
            placeholder="Total Tickets"
            className="shadow appearance-none border rounded-w-full py-2 px-3 text-gray-700  leading-tight focus:outline-none focus:shadow-outline"
          />
        </div>
        <div className="mb-6">
          <label
            className="block text-gray-700 text-sm font-bold mb-2"
            for="totalTickets"
          >
            Ticket Release Rate:
          </label>
          <input
            type="number"
            name="totalTickets"
            placeholder="Ticket Release Rate"
            className="shadow appearance-none border rounded-w-full py-2 px-3 text-gray-700  leading-tight focus:outline-none focus:shadow-outline"
          />
        </div>
        <div className="mb-6">
          <label
            className="block text-gray-700 text-sm font-bold mb-2"
            for="totalTickets"
          >
            Customer Retrieval Rate:
          </label>
          <input
            type="number"
            name="totalTickets"
            placeholder="Customer Retrieval Rate"
            className="shadow appearance-none border rounded-w-full py-2 px-3 text-gray-700  leading-tight focus:outline-none focus:shadow-outline"
          />
        </div>
        <div className="mb-4 ">
          <label
            className="block text-gray-700 text-sm font-bold mb-2"
            for="totalTickets"
          >
            Max Ticket Capacity:
          </label>
          <input
            type="number"
            name="totalTickets"
            placeholder="Max Ticket Capacity"
            className="shadow appearance-none border rounded-w-full py-2 px-3 text-gray-700  leading-tight focus:outline-none focus:shadow-outline"
          />
        </div>
        <div className="px-12">
          <button className="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline">
            Submit
          </button>
        </div>
      </form>
    </div>
  );
}

export default ConfigurationForm;
