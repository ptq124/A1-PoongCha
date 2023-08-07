import * as S from "../styles";
import React, { useState, useRef } from "react";
import Button from "../../../Components/Common/Button/Button";
import { css, styled } from "styled-components";
import SurveyHeader from "../../../Components/Survey/SurveyHeader";
import LifestylePersona from "../../../Components/Survey/LifestylePersona";
import useOnClickPopUp from "../../../hooks/useOnClickPopUp";
import PopUp from "./PopUp";

const testData = [0, 1, 2, 3];

const LifestyleSurvey = ({ linkHandler }) => {
  const [selectedOption, setSelectedOption] = useState("");
  const handleOptionChange = (event) => {
    setSelectedOption(parseInt(event.target.value));
  };

  const [isPopupOpen, setPopupOpen] = useState(false);
  const popupRef = useRef();
  useOnClickPopUp(popupRef, () => setPopupOpen(false));

  return (
    <>
      <S.SurveyContent>
        <SurveyHeader index={2} />
        <Button
          text="원하는 라이프스타일이 없다면?"
          style={LinkBtnStyle}
          onClick={linkHandler}
        />
        <S.SurveyOptions>
          {testData.map((_, index) => (
            <label key={index}>
              <LifestylePersona
                selected={selectedOption === index}
                setPopupOpen={setPopupOpen}
              />
              <Radio
                type="radio"
                value={index}
                checked={selectedOption === index}
                onChange={handleOptionChange}
              />
            </label>
          ))}
        </S.SurveyOptions>
      </S.SurveyContent>
      {isPopupOpen && (
        <>
          <BackgroundOverlay />
          <PopUp popupRef={popupRef} />
        </>
      )}
      <Button text="선택 완료" style={SurveyBtnStyle} />
    </>
  );
};

const BackgroundOverlay = styled.div`
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, 0.5);
  z-index: 9;
`;
const Radio = styled.input`
  display: none;
`;

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
