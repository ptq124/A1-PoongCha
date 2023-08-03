import React, { useState } from "react";
import { css, styled } from "styled-components";
import SurveyOption from "../../Components/SurveyOption/index";
import Button from "../../Components/Common/Button/Button";

const ageOptions = [
  {
    index: 0,
    label: "20대",
  },
  {
    index: 1,
    label: "30대",
  },
  {
    index: 2,
    label: "40대",
  },
  {
    index: 3,
    label: "50대 이상",
  },
];

const PageIndicator = ({ crntIdx, total }) => {
  return (
    <PageIndicatorWrapper>
      {crntIdx}/{total}
    </PageIndicatorWrapper>
  );
};
const SurveyPage = () => {
  const [selectedOption, setSelectedOption] = useState(0);
  const handleOptionChange = (option) => {
    setSelectedOption(option);
  };

  return (
    <Wrapper>
      <SurveyContent>
        <SurveyHeader>
          <SurveyTitle>
            <strong>나이</strong>를 알려주세요
          </SurveyTitle>
          <PageIndicator crntIdx={1} total={2} />
        </SurveyHeader>

        <SurveyOptions>
          {ageOptions.map((option, index) => (
            <SurveyOption
              label={option.label}
              index={index}
              name="age"
              selected={selectedOption === index}
              onChange={() => handleOptionChange(index)}
            />
          ))}
        </SurveyOptions>

        <Button text="다음" style={surveyBtnStyle} />
      </SurveyContent>
    </Wrapper>
  );
};

const surveyBtnStyle = css`
  width: 608px;
  height: 52px;

  position: absolute;
  bottom: 36px;

  color: ${({ theme }) => theme.color.grey1000};
  background-color: ${({ theme }) => theme.color.primary_default};

  border-radius: 6px;
  border: 1px solid ${({ theme }) => theme.color.primary_default};
  ${({ theme }) => theme.font.Body3_Medium};
`;
const SurveyOptions = styled.div`
  display: flex;
  flex-wrap: wrap;
  gap: 12px;
  margin-top: 20px;
`;
const PageIndicatorWrapper = styled.div`
  width: 64px;
  height: 36px;

  display: flex;
  align-items: center;
  justify-content: center;

  color: ${({ theme }) => theme.color.grey400};
  background-color: ${({ theme }) => theme.color.grey900};

  border-radius: 22px;

  ${({ theme }) => theme.font.Extra2}
`;
const SurveyTitle = styled.span`
  ${({ theme }) => theme.font.Extra1}

  strong {
    font-weight: bold;
  }
`;
const SurveyHeader = styled.div`
  display: flex;
  align-items: center;
  justify-content: space-between;
`;
const SurveyContent = styled.div`
  width: 608px;
  height: 100%;

  margin-top: 140px;
`;
const Wrapper = styled.div`
  width: 100%;

  display: flex;
  justify-content: center;
`;
export default SurveyPage;
