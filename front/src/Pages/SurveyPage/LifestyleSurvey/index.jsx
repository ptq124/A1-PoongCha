import * as S from "../styles";
import React, { useState } from "react";
import Button from "../../../Components/Common/Button/Button";
import { css } from "styled-components";
import SurveyHeader from "../../../Components/Survey/SurveyHeader";

const LifestyleSurvey = () => {
  const [selectedOption, setSelectedOption] = useState(0);
  const handleOptionChange = (option) => {
    setSelectedOption(option);
  };
  return (
    <S.SurveyContent>
      <SurveyHeader index={2} />

      <S.SurveyOptions></S.SurveyOptions>

      <Button text="선택 완료" style={surveyBtnStyle} />
    </S.SurveyContent>
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

export default LifestyleSurvey;
