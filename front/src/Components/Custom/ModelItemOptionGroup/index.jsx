import React from "react";
import { styled } from "styled-components";
import ModelItemOption from "../ModelItemOption";

const ModelItemOptionGroup = ({
  data,
  selectedOption,
  handleOptionSelect,
  radioGroup,
}) => {
  const { title, options } = data;
  return (
    <Wrapper>
      <span>{title}</span>
      <Options>
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
    </Wrapper>
  );
};

const Options = styled.div`
  display: flex;

  width: 100%;

  margin-top: 4px;
`;

const Wrapper = styled.div`
  display: flex;
  flex-direction: column;

  span {
    ${({ theme }) => theme.font.Body4_Medium};
  }
`;

export default ModelItemOptionGroup;
