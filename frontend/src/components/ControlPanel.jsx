import React from "react";

const ControlPanel = ({ onStart, onStop,onReset }) => {
  return (
    <div className="flex justify-center items-center space-x-10 ">
      <button
        onClick={onStart}
        className="bg-green-500 hover:bg-green-700 text-white font-bold py-5 px-10 rounded-full focus:outline-none focus:shadow-outline "
      >
        Start
      </button>
      <button
        onClick={onStop}
        className="bg-red-500 hover:bg-red-700 text-white font-bold py-5 px-10 rounded-full focus:outline-none focus:shadow-outline"
      >
        Stop
      </button>
      <button
        onClick={onReset}
        className="bg-blue-500 hover:bg-blue-700 text-white font-bold py-5 px-10 rounded-full focus:outline-none focus:shadow-outline"
      >
       Reset
      </button>
    </div>
  );
};

export default ControlPanel;
