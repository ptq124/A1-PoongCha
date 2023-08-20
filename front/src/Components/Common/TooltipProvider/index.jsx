import React, { useState } from "react";
import { styled } from "styled-components";

const TooltipProvider = ({ label, offset, children }) => {
  const [isOpen, setIsOpen] = useState(false);

  const handleMouseEnter = () => {
    setIsOpen(true);
  };
  const handleMouseLeave = () => {
    setIsOpen(false);
  };
  return (
    <Wrapper onMouseEnter={handleMouseEnter} onMouseLeave={handleMouseLeave}>
      {isOpen && (
        <TooltipContainer $offset={offset}>
          {React.cloneElement(label)}
        </TooltipContainer>
      )}
      {children}
    </Wrapper>
  );
};

const TooltipContainer = styled.div`
  position: absolute;
  ${({ $offset }) => $offset}
`;
const Wrapper = styled.div`
  position: relative;
`;
export default TooltipProvider;
