import React from "react";
import { styled } from "styled-components";
import SurveyOption from "../SurveyOption";

const SurveyOptionGroup = ({
  options,
  title = "",
  selectedOption,
  handleOptionChange,
  groupname,
}) => {
  return (
    <Wrapper>
      {title !== "" && <Title>{title}</Title>}
      <SurveyOptions>
        {options.map((option, index) => (
          <SurveyOption
            label={option.label}
            key={index}
            index={index}
            name={groupname}
            selected={selectedOption === index}
            onChange={() => handleOptionChange(index)}
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
