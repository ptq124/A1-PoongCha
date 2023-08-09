import React, { useState } from "react";
import { styled } from "styled-components";
import ModelItemOption from "../ModelItemOption";
import Tooltip from "../Tooltip";

const ModelItemOptionGroup = ({
  data,
  selectedOption,
  handleOptionSelect,
  radioGroup,
}) => {
  const { title, options } = data;
  const [isTooltipOpen, setIsTooltipOpen] = useState(false);
  const handleMouseEnterOption = () => {
    setIsTooltipOpen(true);
  };
  const handleMouseLeaveOption = () => {
    setIsTooltipOpen(false);
  };
  return (
    <Wrapper>
      {isTooltipOpen && <Tooltip />}
      <OptionGroup>
        <span>{title}</span>
        <Options
          onMouseEnter={handleMouseEnterOption}
          onMouseLeave={handleMouseLeaveOption}
        >
          {options.map((option, index) => (
            <ModelItemOption
              key={index}
              label={option}
              radioGroup={radioGroup}
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
