import React, { useState } from "react";
import * as S from "../styles";
import SurveyHeader from "../../../Components/Survey/SurveyHeader";
import SurveyOptionGroup from "../../../Components/Survey/SurveyOptionGroup";
import Button from "../../../Components/Common/Button/Button";
import { css, styled } from "styled-components";
import BudgetSliderGroup from "./BudgetSliderGroup";

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
const ExtraSurvey = () => {
  const [surveyData, setSurveyData] = useState({
    drivingRecord: 0,
    familySize: 0,
    purpose: null,
    viewpoint: null,
  });

  const handleOptionChange = (group, newValue) => {
    setSurveyData((prevData) => ({
      ...prevData,
      [group]: newValue,
    }));
  };

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

      <BudgetSliderGroup />
    </S.SurveyContent>
  );
};

export default ExtraSurvey;
