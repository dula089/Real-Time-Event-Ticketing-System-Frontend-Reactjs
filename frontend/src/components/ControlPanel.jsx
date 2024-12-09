import React from "react";

const ControlPanel = ({ onStart, onStop }) => {
  return (
    <div className="flex justify-between space-x-96 ">
      <button
        onClick={onStart}
        className="bg-green-500 hover:bg-green-700 text-white font-bold py-10 px-12 rounded-full focus:outline-none focus:shadow-outline "
      >
        Start
      </button>
      <button
        onClick={onStop}
        className="bg-red-500 hover:bg-red-700 text-white font-bold py-10 px-12 rounded-full focus:outline-none focus:shadow-outline"
      >
        Stop
      </button>
    </div>
  );
};

export default ControlPanel;
