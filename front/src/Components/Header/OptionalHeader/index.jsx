import React from "react";
import { useLocation } from "react-router-dom";
import Navigation from "./Navigation";

const OptionalHeader = () => {
  const { pathname } = useLocation();

  const customPaths = ["/custom/trim", "/custom/color"];

  if (pathname === "/") return null;
  if (customPaths.includes(pathname)) return <Navigation />;
};

export default OptionalHeader;
