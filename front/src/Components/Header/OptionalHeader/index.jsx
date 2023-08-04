import React, { useEffect } from "react";
import { useLocation } from "react-router-dom";
import Navigation from "./Navigation";

const OptionalHeader = () => {
  const { pathname } = useLocation();

  if (pathname === "/") {
    return null;
  } else if (pathname === "/custom") {
    return <Navigation />;
  }
};

export default OptionalHeader;
