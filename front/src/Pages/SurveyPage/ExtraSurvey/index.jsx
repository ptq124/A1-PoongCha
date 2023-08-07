import React, { useEffect, useState } from "react";
import * as S from "../styles";
import SurveyHeader from "../../../Components/Survey/SurveyHeader";
import SurveyOptionGroup from "../../../Components/Survey/SurveyOptionGroup";
import Button from "../../../Components/Common/Button/Button";
import BudgetSliderGroup from "./BudgetSliderGroup";
import { css } from "styled-components";
import { surveyData } from "./surveyData";

const ExtraSurvey = ({ buttonHandler }) => {
  const [surveyAnswers, setSurveyAnswers] = useState({
    drivingRecord: 0,
    familySize: 0,
    purpose: null,
    viewpoint: null,
    maxBudget: 5100,
  });
  const [isBtnActive, setIsBtnActive] = useState(false);
  const refineAnswersAndNavigate = () => {
    const refinedAnswers = {};
    surveyData.map(({ groupname, options }) => {
      refinedAnswers[groupname] = options[surveyAnswers[groupname]].label;
    });
    refinedAnswers["maxBudget"] = surveyAnswers["maxBudget"];
    buttonHandler(refinedAnswers);
  };
  const handleOptionChange = (group, newValue) => {
    setSurveyAnswers((prevData) => ({
      ...prevData,
      [group]: newValue,
    }));
  };
  const updateButtonStatusIfAllAnswered = () => {
    if (
      surveyAnswers["drivingRecord"] !== null &&
      surveyAnswers["familySize"] !== null &&
      surveyAnswers["purpose"] !== null &&
      surveyAnswers["viewpoint"] !== null &&
      surveyAnswers["maxBudget"] !== null
    ) {
      setIsBtnActive(true);
    }
  };
  useEffect(() => {
    if (!isBtnActive) {
      updateButtonStatusIfAllAnswered();
    }
  }, [surveyAnswers]);

  return (
    <S.SurveyContent>
      <SurveyHeader surveyType={"Extra"} />
      {surveyData.map((info, index) => (
        <SurveyOptionGroup
          key={index}
          options={info.options}
          title={info.title}
          handleOptionChange={(newValue) => {
            handleOptionChange(info.groupname, newValue);
          }}
          selectedOption={surveyAnswers[info.groupname]}
          groupname={info.groupname}
        />
      ))}

      <BudgetSliderGroup
        maxBudget={surveyAnswers["maxBudget"]}
        setMaxBudget={(newValue) => handleOptionChange("maxBudget", newValue)}
      />
      <Button
        text="완료"
        $isActive={isBtnActive}
        style={SurveyBtnStyle}
        onClick={refineAnswersAndNavigate}
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
