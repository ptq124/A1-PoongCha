import React, { useEffect, useState } from "react";
import * as S from "../styles";
import SurveyHeader from "../../../Components/Survey/SurveyHeader";
import SurveyOptionGroup from "../../../Components/Survey/SurveyOptionGroup";
import Button from "../../../Components/Common/Button/Button";
import BudgetSliderGroup from "./BudgetSliderGroup";
import { css } from "styled-components";

const extraSurveyInfo = [
  {
    groupname: "drivingRecord",
    title: "운전 경력이 어떻게 되시나요?",
    options: [
      {
        index: 0,
        label: "1년 이하",
      },
      {
        index: 1,
        label: "3년 이하",
      },
      {
        index: 2,
        label: "5년 이상",
      },
    ],
  },
  {
    groupname: "familySize",
    title: "가족 구성원이 몇 명인가요?",
    options: [
      {
        index: 0,
        label: "1인",
      },
      {
        index: 1,
        label: "2인",
      },
      {
        index: 2,
        label: "3-4인",
      },
      {
        index: 3,
        label: "5인 이상",
      },
    ],
  },
  {
    groupname: "purpose",
    title: "어떤 목적으로 주로 차를 타시나요?",
    options: [
      {
        index: 0,
        label: "출퇴근용",
      },
      {
        index: 1,
        label: "레저용",
      },
      {
        index: 2,
        label: "가정용",
      },
      {
        index: 3,
        label: "업무용",
      },
    ],
  },
  {
    groupname: "viewpoint",
    title: "자동차를 살 때 어떤 가치가 가장 중요한가요?",
    options: [
      {
        index: 0,
        label: "디자인",
      },
      {
        index: 1,
        label: "성능",
      },
      {
        index: 2,
        label: "안전",
      },
      {
        index: 3,
        label: "편의성",
      },
    ],
  },
];
const ExtraSurvey = ({ buttonHandler }) => {
  const [surveyData, setSurveyData] = useState({
    drivingRecord: 0,
    familySize: 0,
    purpose: null,
    viewpoint: null,
    maxBudget: 5100,
  });
  const [isBtnActive, setIsBtnActive] = useState(false);

  const handleOptionChange = (group, newValue) => {
    setSurveyData((prevData) => ({
      ...prevData,
      [group]: newValue,
    }));
  };
  const updateButtonStatusIfAllAnswered = () => {
    if (
      surveyData["drivingRecord"] !== null &&
      surveyData["familySize"] !== null &&
      surveyData["purpose"] !== null &&
      surveyData["viewpoint"] !== null &&
      surveyData["maxBudget"] !== null
    ) {
      setIsBtnActive(true);
    }
  };
  useEffect(() => {
    if (!isBtnActive) {
      updateButtonStatusIfAllAnswered();
    }
  }, [surveyData]);

  return (
    <S.SurveyContent>
      <SurveyHeader index={3} />
      {extraSurveyInfo.map((info, index) => (
        <SurveyOptionGroup
          key={index}
          options={info.options}
          title={info.title}
          handleOptionChange={(newValue) => {
            handleOptionChange(info.groupname, newValue);
          }}
          selectedOption={surveyData[info.groupname]}
          groupname={info.groupname}
        />
      ))}

      <BudgetSliderGroup
        maxBudget={surveyData["maxBudget"]}
        setMaxBudget={(newValue) => handleOptionChange("maxBudget", newValue)}
      />
      <Button
        text="완료"
        $isActive={isBtnActive}
        style={SurveyBtnStyle}
        onClick={buttonHandler}
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
