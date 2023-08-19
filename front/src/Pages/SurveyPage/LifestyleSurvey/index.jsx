import React from "react";
import * as S from "../styles";
import { css } from "styled-components";
import Button from "@Components/Common/Button/Button";
import useButtonNavigation from "@hooks/useButtonNavigation";
import { useOutletContext } from "react-router-dom";
import LifestyleQuestion from "@Components/Survey/LifestyleQuestion";
import PageIndicator from "@Components/Survey/PageIndicator";
import RadioGroup from "@Components/Common/RadioGroup";

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
  const move = useButtonNavigation();

  const [handleOptionSelect, state] = useOutletContext();
  const lifestyleRadioGroupTitle = () => {
    return (
      <>
        <div>
          <span>
            유사한 <strong>라이프스타일</strong>을 선택하면
            <br />
            차량 조합을 추천해 드려요.
          </span>
          <Button
            text="원하는 라이프스타일이 없다면?"
            style={LinkBtnStyle}
            onClick={() => move("/survey/extra")}
          />
        </div>
        <PageIndicator />
      </>
    );
  };

  return (
    <>
      <S.SurveyContent>
        <RadioGroup
          title={lifestyleRadioGroupTitle()}
          label={LifestyleQuestion}
          options={lifestyleSurveyInfo.options}
          newStateHandler={(newState) =>
            handleOptionSelect("lifestyle", newState)
          }
          style={lifestyleRadioGroupStyle}
        />
      </S.SurveyContent>
      <Button
        text="선택 완료"
        style={SurveyBtnStyle}
        $isActive={state.lifestyle !== ""}
        onClick={() => move("/survey/end")}
      />
    </>
  );
};

const lifestyleRadioGroupStyle = {
  wrapper: css`
    width: 100%;
    display: flex;
    flex-direction: column;
    align-items: center;
    margin-bottom: 52px;
  `,
  title: css`
    display: flex;
    justify-content: space-between;
    width: 100%;
    ${({ theme }) => theme.font.Extra1};
    strong {
      font-family: "HyundaiSansHeadMediumKR";
    }
  `,
  options: css`
    display: flex;
    flex-wrap: wrap;
    gap: 16px;
    margin-top: 32px;
  `,
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

  ${({ $isActive }) =>
    !$isActive &&
    css`
      opacity: 0.3;
      pointer-events: none;
    `}

  transition:opacity 0.4s ease;
`;

export default LifestyleSurvey;
