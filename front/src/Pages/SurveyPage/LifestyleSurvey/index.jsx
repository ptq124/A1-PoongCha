import React, { useState, useRef } from "react";
import * as S from "../styles";
import { css, styled } from "styled-components";
import Button from "../../../Components/Common/Button/Button";
import SurveyHeader from "../../../Components/Survey/SurveyHeader";
import LifestylePersona from "../../../Components/Survey/LifestylePersona";
import useOnClickPopUp from "../../../hooks/useOnClickPopUp";
import PopUp from "./PopUp";
import useButtonNavigation from "../../../hooks/useButtonNavigation";
import BackgroundOverlay from "../../../Components/Common/OverlaidPopup/BackgroundOverlay";

const lifestyleSurveyInfo = {
  options: [
    {
      index: 0,
      phrase: (
        <>
          가족과 함께 타서 <br /> 안전을 중시해요.
        </>
      ),
      tags: ["#주행안전", "#사용편의"],
    },
    {
      index: 1,
      phrase: (
        <>
          매일 출퇴근하여 경제적이고
          <br />
          편안한 주행을 원해요.
        </>
      ),
      tags: ["#사용편의", "#추위/더위"],
    },
    {
      index: 2,
      phrase: (
        <>
          운전 경력이 짧아 <br />
          똑똑한 주행을 원해요.
        </>
      ),
      tags: ["#주행안전", "#주차/출차"],
    },
    {
      index: 3,
      phrase: (
        <>
          트렌드에 민감해 <br />
          디자인과 성능이 중요해요.
        </>
      ),
      tags: ["#스타일", "#퍼포먼스"],
    },
  ],
};

const LifestyleSurvey = () => {
  const [selectedOption, setSelectedOption] = useState("");
  const handleOptionChange = (event) => {
    setSelectedOption(parseInt(event.target.value));
  };
  const popupRef = useRef();
  const { isPopupOpen, openPopup, closePopup } = useOnClickPopUp(popupRef);

  const move = useButtonNavigation();

  return (
    <>
      <S.SurveyContent>
        <SurveyHeader surveyType={"Lifestyle"} />
        <Button
          text="원하는 라이프스타일이 없다면?"
          style={LinkBtnStyle}
          onClick={() => move("/survey/extra")}
        />
        <S.LifeStyleOptions>
          {lifestyleSurveyInfo.options.map((_, index) => (
            <label key={index}>
              <LifestylePersona
                selected={selectedOption === index}
                openPopup={openPopup}
                data={lifestyleSurveyInfo.options[index]}
              />
              <Radio
                type="radio"
                value={index}
                checked={selectedOption === index}
                onChange={handleOptionChange}
              />
            </label>
          ))}
        </S.LifeStyleOptions>
      </S.SurveyContent>
      {isPopupOpen && (
        <>
          <BackgroundOverlay />
          <PopUp popupRef={popupRef} />
        </>
      )}
      <Button
        text="선택 완료"
        style={SurveyBtnStyle}
        onClick={() => move("/survey/end")}
      />
    </>
  );
};

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
