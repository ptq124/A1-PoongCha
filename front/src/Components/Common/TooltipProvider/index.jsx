import React, { useState } from "react";
import { styled } from "styled-components";

const TooltipProvider = ({ label, children }) => {
  const [isOpen, setIsOpen] = useState(false);
  return (
    <Wrapper
      onMouseEnter={() => setIsOpen(true)}
      onMouseLeave={() => setIsOpen(false)}
    >
      {isOpen && <>hi i'm a tooltip</>}
      {children}
    </Wrapper>
  );
};

const Wrapper = styled.div``;
export default TooltipProvider;
