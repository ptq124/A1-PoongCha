import React, { useState } from "react";
import { styled } from "styled-components";
import ModelItemOption from "../ModelItemOptionLabel";
import Tooltip from "../Tooltip";
import useTooltip from "@hooks/useTooltip";

const ModelItemOptionGroup = ({ data, selectedOption, handleOptionSelect }) => {
  const { title, options } = data;
  const { isTooltipOpen, openTooltip, closeTooltip } = useTooltip();
  const [animationIdx, setAnimationIdx] = useState(
    options.findIndex((opt) => opt === selectedOption)
  );
  const handleOptionChange = (option, index) => {
    handleOptionSelect(null);
    setAnimationIdx(index);
    setTimeout(() => {
      handleOptionSelect(option);
    }, 200);
  };
  return (
    <Wrapper>
      {isTooltipOpen && <Tooltip offset={78} />}
      <OptionGroup>
        <span>{title}</span>
        <Options onMouseEnter={openTooltip} onMouseLeave={closeTooltip}>
          <AnimatedOptionBox $offset={animationIdx}></AnimatedOptionBox>
          {options.map((option, index) => (
            <ModelItemOption
              key={index}
              label={option}
              selected={selectedOption === option}
              handleOptionSelect={() => handleOptionChange(option, index)}
            />
          ))}
        </Options>
      </OptionGroup>
    </Wrapper>
  );
};

const AnimatedOptionBox = styled.div`
  position: absolute;
  width: 141.5px;
  height: 40px;
  border: 1.5px solid ${({ theme }) => theme.color.primary_default};
  border-radius: 6px;

  box-sizing: border-box;

  left: ${({ $offset }) => $offset * 141}px;
  transition: left 0.2s ease;
`;
const Options = styled.div`
  position: relative;
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
