import React, { useState } from "react";
import * as S from "../styles";
import { css } from "styled-components";
import Button from "../../../Components/Common/Button/Button";
import SurveyHeader from "../../../Components/Survey/SurveyHeader";
import SurveyOptionGroup from "../../../Components/Survey/SurveyOptionGroup";
import useButtonNavigation from "../../../hooks/useButtonNavigation";

const surveyData = {
  age: {
    title: "",
    options: ["20대", "30대", "40대", "50대 이상"],
  },
};

const AgeSurvey = () => {
  const move = useButtonNavigation();
  const [selectedOption, setSelectedOption] = useState("20대");
  const handleOptionSelect = (option) => {
    setSelectedOption(option);
  };
  return (
    <S.SurveyContent>
      <SurveyHeader surveyType={"Age"} />

      <SurveyOptionGroup
        data={surveyData["age"]}
        handleOptionSelect={handleOptionSelect}
        selectedOption={selectedOption}
      />
      <Button
        text="다음"
        style={SurveyBtnStyle}
        onClick={() => move("/survey/lifestyle")}
      />
    </S.SurveyContent>
  );
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
