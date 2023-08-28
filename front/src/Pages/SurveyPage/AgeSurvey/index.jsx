import React, { useEffect, useState } from "react";
import * as S from "../styles";
import { css } from "styled-components";
import Button from "@Components/Common/Button/Button";
import useButtonNavigation from "@hooks/useButtonNavigation";
import { useOutletContext } from "react-router-dom";
import RadioGroup from "@Components/Common/RadioGroup";
import AgeQuestionLabel from "@Components/Survey/AgeQuestionLabel";
import PageIndicator from "@Components/Survey/PageIndicator";
import { getSurvey } from "apis/survey";
import { AGE_SURVEY_ID } from "@utils/constants";
import RadioGroupComposition from "@Components/Common/RadioGroup/RadioGroupComposition";

const ageRadioGroupTitle = (data) => {
  return (
    <>
      <span>
        {/* <strong>나이</strong>를 알려주세요. */}
        {data?.description}
      </span>
      <PageIndicator />
    </>
  );
};

const AgeSurvey = () => {
  const move = useButtonNavigation();
  const [handleOptionSelect, state] = useOutletContext();
  const [surveyData, setSurveyData] = useState({});

  useEffect(() => {
    getSurvey(AGE_SURVEY_ID).then((data) => {
      setSurveyData(data);
    });
  }, []);

  return (
    <S.SurveyContent>
      <RadioGroupComposition
        label={<AgeQuestionLabel />}
        options={surveyData.options}
        newStateHandler={(newState) =>
          handleOptionSelect(surveyData.id, newState)
        }
        initialState={surveyData.options && surveyData.options[0]}
        style={ageRadioGroupStyle}
      >
        <RadioGroupComposition.Title style={ageRadioGroupStyle.title}>
          <>
            <span>{surveyData?.description}</span>
            <PageIndicator />
          </>
        </RadioGroupComposition.Title>
      </RadioGroupComposition>
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
