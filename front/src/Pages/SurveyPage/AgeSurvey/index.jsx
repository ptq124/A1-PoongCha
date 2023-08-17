import React from "react";
import * as S from "../styles";
import { css } from "styled-components";
import Button from "@Components/Common/Button/Button";
import useButtonNavigation from "@hooks/useButtonNavigation";

const surveyData = {
  options: ["20대", "30대", "40대", "50대 이상"],
};

const questionnaire = () => {
  return (
    <>
      <strong>나이</strong>를 알려주세요.
    </>
  );
};

const AgeSurvey = () => {
  const move = useButtonNavigation();
  const [handleOptionSelect, state] = useOutletContext();

  return (
    <S.SurveyContent>
      <Survey
        questionnaire={questionnaire()}
        label={AgeQuestion}
        options={surveyData.options}
        reducerHandler={handleOptionSelect}
        reducerKey={"age"}
        initialState={state.age}
        style={ageStyle}
      />
      <Button
        text="다음"
        style={SurveyBtnStyle}
        onClick={() => move("/survey/lifestyle")}
      />
    </S.SurveyContent>
  );
};

const ageStyle = css`
  gap: 12px;
  margin-top: 24px;
`;

const SurveyBtnStyle = css`
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

export default AgeSurvey;
