import React from "react";
import { styled } from "styled-components";
import SurveyOption from "../SurveyOption";

const SurveyOptionGroup = ({
  data,
  selectedOption,
  handleOptionSelect,
  radioGroup,
}) => {
  const { title, options } = data;
  return (
    <Wrapper>
      {title !== "" && <Title>{title}</Title>}
      <SurveyOptions>
        {options.map((option, index) => (
          <SurveyOption
            key={index}
            label={option}
            radioGroup={radioGroup}
            selected={selectedOption === option}
            handleOptionSelect={() => handleOptionSelect(option)}
            isLong={options.length % 2 === 1 && index === options.length - 1}
          />
        ))}
      </SurveyOptions>
    </Wrapper>
  );
};

const SurveyOptions = styled.div`
  display: flex;
  flex-wrap: wrap;
  gap: 12px;

  margin-top: 20px;
`;
const Title = styled.div`
  color: ${({ theme }) => theme.color.grey100};
  ${({ theme }) => theme.font.Body2_Medium};
`;
const Wrapper = styled.div`
  margin-top: 52px;
`;
export default SurveyOptionGroup;
