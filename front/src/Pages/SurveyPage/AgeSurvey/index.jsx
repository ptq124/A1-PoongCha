import React from "react";
import * as S from "../styles";
import { css } from "styled-components";
import Button from "@Components/Common/Button/Button";
import useButtonNavigation from "@hooks/useButtonNavigation";
import { useOutletContext } from "react-router-dom";
import RadioGroup from "@Components/Common/RadioGroup";
import AgeQuestion from "@Components/Survey/AgeQuestion";
import PageIndicator from "@Components/Survey/PageIndicator";

const surveyData = {
  options: ["20대", "30대", "40대", "50대 이상"],
};

const ageRadioGroupTitle = () => {
  return (
    <>
      <span>
        <strong>나이</strong>를 알려주세요.
      </span>
      <PageIndicator />
    </>
  );
};

const AgeSurvey = () => {
  const move = useButtonNavigation();
  const [handleOptionSelect, state] = useOutletContext();

  return (
    <S.SurveyContent>
      <RadioGroup
        title={ageRadioGroupTitle()}
        label={AgeQuestion}
        options={surveyData.options}
        newStateHandler={(newState) => handleOptionSelect("age", newState)}
        initialState={state.age}
        style={ageRadioGroupStyle}
      />
      <Button
        text="다음"
        style={SurveyBtnStyle}
        onClick={() => move("/survey/lifestyle")}
      />
    </S.SurveyContent>
  );
};

const ageRadioGroupStyle = {
  wrapper: css`
    width: 100%;
    display: flex;
    flex-direction: column;
    align-items: center;
    margin-bottom: 52px;
  `,
  title: css`
    display: flex;
    justify-content: space-between;
    width: 100%;
    ${({ theme }) => theme.font.Extra1};
    strong {
      font-family: "HyundaiSansHeadMediumKR";
    }
  `,
  options: css`
    display: flex;
    flex-wrap: wrap;
    gap: 12px;
    margin-top: 24px;
  `,
};
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
