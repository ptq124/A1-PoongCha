import React from "react";
import { styled } from "styled-components";
import up from "@assets/icons/arrow_up.svg";

const Accordion = ({ title, content, isOpen, toggleAccordion }) => {
  return (
    <AccordionContainer>
      <AccordionTitle onClick={toggleAccordion} isOpen={isOpen}>
        {title}
        <img src={up} />
      </AccordionTitle>
      <AccordionContent isOpen={isOpen}>{content}</AccordionContent>
    </AccordionContainer>
  );
};

const AccordionContainer = styled.div`
  position: relative;
  width: 608px;
  margin-top: 19px;

  img {
    position: absolute;
    top: 3px;
    right: 0;
  }
`;

const AccordionTitle = styled.div`
  ${({ theme }) => theme.font.Body4_Regular}
  color: ${({ theme }) => theme.color.grey300};
  padding-bottom: 14px;
  cursor: pointer;
  border-bottom: 1px solid;
  border-bottom-color: ${({ theme }) => theme.color.grey700};

  img {
    transition: transform 0.3s;
    transform: ${({ isOpen }) => (isOpen ? "rotate(0deg)" : "rotate(-180deg)")};
  }
`;

const AccordionContent = styled.div`
  margin-top: 20px;
  display: ${({ isOpen }) => (isOpen ? "block" : "none")};
`;

export default Accordion;
