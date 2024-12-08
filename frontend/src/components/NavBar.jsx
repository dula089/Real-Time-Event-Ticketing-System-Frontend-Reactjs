import React from "react";
import { Link } from "react-router-dom";
const NavBar = () => {
  return (
    <nav className="bg-blue-500 p-4 w-full">
      <div className="container mx-auto flex justify-between items-center">
        <Link
          to="/"
          className="text-white text-3xl italic font-bold px-6 font-serif"
        >
          Ticketing System
        </Link>

        <div className="hidden md:flex space-x-6">
          <Link
            to="/config"
            className="text-white hover:bg-blue-700 px-12 py-2 rounded transition"
          >
            Configuration System
          </Link>
          <Link
            to="/logs"
            className="text-white hover:bg-blue-700 px-12 py-2 rounded transition"
          >
            Logs
          </Link>
        </div>
        <button
          className="md:hidden text-white focus:outline-none"
          onClick={() => {
            const menu = document.getElementById("mobile-menu");
            menu.classList.toggle("hidden");
          }}
        >
          ☰
        </button>
      </div>
      <div
        id="mobile-menu"
        className="hidden md:hidden flex flex-col space-y-10 mt-2"
      >
        <Link
          to="/config"
          className="text-white hover:bg-blue-700 px-12 py-2 rounded transition"
        >
          Configuration System
        </Link>
        <Link
          to="/logs"
          className="text-white hover:bg-blue-700 px-12 py-2 rounded transition"
        >
          Logs
        </Link>
      </div>
    </nav>
  );
};
export default NavBar;
