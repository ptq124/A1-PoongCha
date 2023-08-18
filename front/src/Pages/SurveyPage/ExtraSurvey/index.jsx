import React from "react";
import * as S from "../styles";
import { css, styled } from "styled-components";
import Button from "@Components/Common/Button/Button";
import BudgetSliderGroup from "./BudgetSliderGroup";
import useButtonNavigation from "@hooks/useButtonNavigation";
import { useOutletContext } from "react-router-dom";
import Survey from "@Components/Survey";
import ExtraQuestion from "@Components/Survey/ExtraQuestion";

const surveyData = {
  drivingRecord: {
    title: "운전 경력이 어떻게 되시나요?",
    options: ["1년 이하", "3년 이하", "5년 이상"],
  },
  familySize: {
    title: "가족 구성원이 몇 명인가요?",
    options: ["1인", "2인", "3-4인", "5인 이상"],
  },
  purpose: {
    title: "어떤 목적으로 주로 차를 타시나요?",
    options: ["출퇴근용", "레저용", "가정용", "업무용"],
  },
  viewpoint: {
    title: "자동차를 살 때 어떤 가치가 가장 중요한가요?",
    options: ["디자인", "성능", "안전", "편의성"],
  },
};

const ExtraSurvey = () => {
  const move = useButtonNavigation();

  const [handleOptionSelect, state] = useOutletContext();

  const isActive = () => state.purpose && state.viewpoint;

  return (
    <S.SurveyContent>
      <Title>
        당신의 <strong>라이프스타일</strong>을 알려주세요.
      </Title>
      <Subtitle>당신의 라이프스타일을 반영한 차를 추천해 드릴게요.</Subtitle>
      {Object.entries(surveyData).map(([questionKey, data]) => (
        <Survey
          key={questionKey}
          questionnaire={data.title}
          label={ExtraQuestion}
          options={data.options}
          newStateHandler={(newState) =>
            handleOptionSelect(questionKey, newState)
          }
          // reducerKey={questionKey}
          initialState={state[questionKey]}
          style={extraStyle}
        />
      ))}
      <BudgetSliderGroup
        maxBudget={state.maxBudget}
        setMaxBudget={(newValue) => handleOptionSelect("maxBudget", newValue)}
      />
      <Button
        text="완료"
        $isActive={isActive()}
        style={SurveyBtnStyle}
        onClick={() => move("/survey/etc_end", state)}
      />
    </S.SurveyContent>
  );
};
const extraStyle = css`
  gap: 12px;

  margin-top: 18px;
`;

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
