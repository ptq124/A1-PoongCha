import * as S from "../styles";
import React, { useState } from "react";
import Button from "../../../Components/Common/Button/Button";
import { css } from "styled-components";
import SurveyHeader from "../../../Components/Survey/SurveyHeader";

const LifestyleSurvey = ({ linkHandler }) => {
  const [selectedOption, setSelectedOption] = useState(0);
  const handleOptionChange = (option) => {
    setSelectedOption(option);
  };
  return (
    <S.SurveyContent>
      <SurveyHeader index={2} />
      <Button
        text="원하는 라이프스타일이 없다면?"
        style={LinkBtnStyle}
        onClick={linkHandler}
      />
      <S.SurveyOptions></S.SurveyOptions>

      <Button text="선택 완료" style={SurveyBtnStyle} />
    </S.SurveyContent>
  );
};

const LinkBtnStyle = css`
  color: ${({ theme }) => theme.color.secondary};
  background-color: ${({ theme }) => theme.color.grey1000};

  border: none;
  ${({ theme }) => theme.font.Extra4};
  background: none;
  padding: 0;
  outline: 0;
  text-decoration: underline;
  text-underline-offset: 3px;

  margin-top: 16px;
`;
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

export default LifestyleSurvey;
