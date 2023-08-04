import * as S from "../styles";
import React, { useState } from "react";
import Button from "../../../Components/Common/Button/Button";
import PageIndicator from "../../../Components/PageIndicator";
import { css } from "styled-components";

const lifestyleOptions = [];

const LifestyleSurvey = () => {
  const [selectedOption, setSelectedOption] = useState(0);
  const handleOptionChange = (option) => {
    setSelectedOption(option);
  };
  return (
    <S.SurveyContent>
      <S.SurveyHeader>
        <S.SurveyTitle>
          유사한 <strong>라이프스타일</strong>을 선택하면 <br />
          차량 조합을 추천해 드려요.
        </S.SurveyTitle>
        <PageIndicator crntPage={2} totalPage={2} />
      </S.SurveyHeader>

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
