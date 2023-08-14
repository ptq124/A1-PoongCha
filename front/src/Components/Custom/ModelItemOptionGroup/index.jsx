import React from "react";
import { styled } from "styled-components";
import ModelItemOption from "./ModelItemOption";
import Tooltip from "../Tooltip";
import useTooltip from "@hooks/useTooltip";

const ModelItemOptionGroup = ({ data, selectedOption, handleOptionSelect }) => {
  const { title, options } = data;
  const { isTooltipOpen, openTooltip, closeTooltip } = useTooltip();

  return (
    <Wrapper>
      {isTooltipOpen && <Tooltip offset={78} />}
      <OptionGroup>
        <span>{title}</span>
        <Options onMouseEnter={openTooltip} onMouseLeave={closeTooltip}>
          {options.map((option, index) => (
            <ModelItemOption
              key={index}
              label={option}
              selected={selectedOption === option}
              handleOptionSelect={() => handleOptionSelect(option)}
            />
          ))}
        </Options>
      </OptionGroup>
    </Wrapper>
  );
};

const Options = styled.div`
  display: flex;
  width: 100%;
  margin-top: 4px;
`;

const OptionGroup = styled.div`
  display: flex;
  flex-direction: column;

  position: relative;

  span {
    ${({ theme }) => theme.font.Body4_Medium};
  }

  margin: 0px 12px;
`;
const Wrapper = styled.div`
  position: relative;
`;

export default ModelItemOptionGroup;
