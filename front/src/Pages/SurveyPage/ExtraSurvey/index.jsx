import React, { useEffect, useReducer, useState } from "react";
import * as S from "../styles";
import { css } from "styled-components";
import SurveyHeader from "../../../Components/Survey/SurveyHeader";
import SurveyOptionGroup from "../../../Components/Survey/SurveyOptionGroup";
import Button from "../../../Components/Common/Button/Button";
import BudgetSliderGroup from "./BudgetSliderGroup";
import { initialState, reducer } from "./index.reducer";
import useButtonNavigation from "../../../hooks/useButtonNavigation";

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
  const [state, dispatch] = useReducer(reducer, initialState);
  const handleOptionSelect = (questionKey, option) => {
    dispatch({
      type: "SELECT_OPTION",
      questionKey,
      option,
    });
  };

  // 완료 버튼 활성화 관련 기능
  const [isBtnActive, setIsBtnActive] = useState(false);
  const updateButtonStatusIfAllAnswered = () => {
    if (Object.values(state).includes("")) {
      return;
    }
    setIsBtnActive(true);
  };
  useEffect(() => {
    if (!isBtnActive) {
      updateButtonStatusIfAllAnswered();
    }
  }, [state]);

  return (
    <S.SurveyContent>
      <SurveyHeader surveyType={"Extra"} />
      {Object.entries(surveyData).map(([questionKey, data]) => (
        <SurveyOptionGroup
          key={questionKey}
          data={data}
          handleOptionSelect={(newValue) => {
            handleOptionSelect(questionKey, newValue);
          }}
          selectedOption={state[questionKey]}
        />
      ))}
      <BudgetSliderGroup
        maxBudget={state["maxBudget"]}
        setMaxBudget={(newValue) => handleOptionSelect("maxBudget", newValue)}
      />
      <Button
        text="완료"
        $isActive={isBtnActive}
        style={SurveyBtnStyle}
        onClick={() => move("/survey/etc_end", state)}
      />
    </S.SurveyContent>
  );
};

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
`;

export default ExtraSurvey;
