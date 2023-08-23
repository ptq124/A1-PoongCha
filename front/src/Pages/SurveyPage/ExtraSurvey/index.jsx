import React, { useEffect, useState } from "react";
import * as S from "../styles";
import { css, styled } from "styled-components";
import Button from "@Components/Common/Button/Button";
import BudgetSliderGroup from "./BudgetSliderGroup";
import useButtonNavigation from "@hooks/useButtonNavigation";
import { useOutletContext } from "react-router-dom";
import ExtraQuestionLabel from "@Components/Survey/ExtraQuestionLabel";
import RadioGroup from "@Components/Common/RadioGroup";
import { getSurvey } from "apis/survey";
import {
  DRIVING_RECORD_SURVEY_ID,
  FAMILY_SIZE_SURVEY_ID,
  MAX_BUDGET_SURVEY_ID,
  PURPOSE_SURVEY_ID,
  VIEWPOINT_SURVEY_ID,
} from "@utils/constants";

const ExtraSurvey = () => {
  const move = useButtonNavigation();
  const [handleOptionSelect, state] = useOutletContext();
  const isBtnActive = () =>
    state[PURPOSE_SURVEY_ID] && state[VIEWPOINT_SURVEY_ID];

  const [surveyData, setSurveyData] = useState([]);
  useEffect(() => {
    const fetchAll = async () => {
      const requestIds = [
        DRIVING_RECORD_SURVEY_ID,
        FAMILY_SIZE_SURVEY_ID,
        PURPOSE_SURVEY_ID,
        VIEWPOINT_SURVEY_ID,
        // MAX_BUDGET_SURVEY_ID,
      ];
      const surveyDataArr = await Promise.all(
        requestIds.map((id) => getSurvey(id).then((data) => data))
      );
      setSurveyData(surveyDataArr);
    };

    fetchAll();
  }, []);

  return (
    <S.SurveyContent>
      <Title>
        당신의 <strong>라이프스타일</strong>을 알려주세요.
      </Title>
      <Subtitle>당신의 라이프스타일을 반영한 차를 추천해 드릴게요.</Subtitle>
      {surveyData?.map((survey, index) => (
        <RadioGroup
          key={survey.id}
          title={survey.description}
          label={<ExtraQuestionLabel />}
          options={survey.options}
          newStateHandler={(newState) =>
            handleOptionSelect(survey.id, newState)
          }
          initialState={
            (survey.id === DRIVING_RECORD_SURVEY_ID ||
              survey.id === FAMILY_SIZE_SURVEY_ID) &&
            survey.options[0]
          }
          style={extraRadioGroupStyle}
        />
      ))}
      <BudgetSliderGroup
        maxBudget={state.maxBudget}
        setMaxBudget={(newValue) => handleOptionSelect("maxBudget", newValue)}
      />
      <Button
        text="완료"
        $isActive={isBtnActive()}
        style={SurveyBtnStyle}
        onClick={() => move("/survey/etc_end")}
      />
    </S.SurveyContent>
  );
};

const extraRadioGroupStyle = {
  wrapper: css`
    width: 100%;
    display: flex;
    flex-direction: column;
    align-items: center;
    margin-bottom: 52px;
  `,
  title: css`
    width: 100%;
    ${({ theme }) => theme.font.Body2_Medium};
  `,
  options: css`
    display: flex;
    flex-wrap: wrap;
    gap: 12px;
    margin-top: 24px;
  `,
};

const Subtitle = styled.div`
  color: ${({ theme }) => theme.color.grey300};
  ${({ theme }) => theme.font.Body4_Regular};

  margin-top: 8px;
  margin-bottom: 40px;
`;
const Title = styled.div`
  ${({ theme }) => theme.font.Extra1};
  strong {
    font-family: "HyundaiSansHeadMediumKR";
  }
`;

const SurveyBtnStyle = css`
  width: 608px;
  height: 52px;

  position: relative;

  color: ${({ theme }) => theme.color.grey1000};
  background-color: ${({ theme }) => theme.color.primary_default};

  border-radius: 6px;
  border: 1px solid ${({ theme }) => theme.color.primary_default};
  ${({ theme }) => theme.font.Body3_Medium};

  margin: 52px 0px 36px;

  ${({ $isActive }) =>
    !$isActive &&
    css`
      opacity: 0.3;
      pointer-events: none;
    `}

  transition:opacity 0.4s ease;
`;

export default ExtraSurvey;
