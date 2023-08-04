import React, { useEffect } from "react";
import { useLocation } from "react-router-dom";
import ProgressBar from "./ProgressBar";
import Navigation from "./Navigation";

const OptionalHeader = () => {
  const { pathname } = useLocation();
  console.log(pathname);
  if (pathname === "/") {
    return null;
  } else if (pathname === "/survey") {
    return <ProgressBar />;
  } else if (pathname === "/custom") {
    return <Navigation />;
  }
};

export default OptionalHeader;
