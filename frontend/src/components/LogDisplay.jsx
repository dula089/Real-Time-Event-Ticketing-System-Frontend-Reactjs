import React from "react";

const LogDisplay = ({ logs }) => {
  return (
    <div className="p-4 bg-white shadow rounded">
      <h2 className="text-xl font-bold mb-4 text-center mt-6">System Logs</h2>
      <div className="overflow-y-scroll max-h-64">
        <table className="table-auto w-full border-collapse border border-gray-200">
        <thead>
          <tr>
            <th className="border border-gray-300 py-2  text-center">Sale ID</th>
            <th className="border border-gray-300 py-2 text-center">
              Date and Time
            </th>
            <th className="border border-gray-300 py-2 text-center">Log</th>
          </tr>
        </thead>
        <tbody>
          {logs.map((log, index) => (
            <tr>
              <td className="border border-gray-300 py-2 text-center">
                {log.saleId || "N/A"}
              </td>
              <td className="border border-gray-300 py-2 text-center">
                {log.dateTime || "N/A"}
              </td>
              <td className="border border-gray-300 py-2 text-center">
                {log.message}
              </td>
            </tr>
          ))}
        </tbody>
        </table>
      </div>
    </div>
  );
};

export default LogDisplay;
