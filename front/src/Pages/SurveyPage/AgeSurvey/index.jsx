import * as S from "../styles";
import React, { useState } from "react";
import SurveyOption from "../../../Components/Survey/SurveyOption";
import Button from "../../../Components/Common/Button/Button";
import { css } from "styled-components";
import SurveyHeader from "../../../Components/Survey/SurveyHeader";
import SurveyOptionGroup from "../../../Components/Survey/SurveyOptionGroup";

const ageSurveyInfo = {
  groupname: "age",
  title: "",
  options: [
    {
      index: 0,
      label: "20대",
    },
    {
      index: 1,
      label: "30대",
    },
    {
      index: 2,
      label: "40대",
    },
    {
      index: 3,
      label: "50대 이상",
    },
  ],
};

const AgeSurvey = ({ buttonHandler }) => {
  const [selectedOption, setSelectedOption] = useState(0);
  const handleOptionChange = (option) => {
    setSelectedOption(option);
  };
  return (
    <S.SurveyContent>
      <SurveyHeader surveyType={"Age"} />
      <SurveyOptionGroup
        options={ageSurveyInfo.options}
        handleOptionChange={handleOptionChange}
        selectedOption={selectedOption}
        groupname={ageSurveyInfo.groupname}
      />
      <Button text="다음" style={SurveyBtnStyle} onClick={buttonHandler} />
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
