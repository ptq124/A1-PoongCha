import React from "react";
import { useLocation } from "react-router";
import { keyframes, styled } from "styled-components";
import PalisadeImg from "@assets/images/etc-end-palisade.svg";
import {
  DRIVING_RECORD_SURVEY_ID,
  FAMILY_SIZE_SURVEY_ID,
  PURPOSE_SURVEY_ID,
  VIEWPOINT_SURVEY_ID,
} from "@utils/constants";

const QNASummary = () => {
  const { state } = useLocation();

  return (
    <Wrapper>
      <SummaryContent>
        <AnswerTagContainer>
          <AnswerTag>{state[DRIVING_RECORD_SURVEY_ID].name}</AnswerTag>
          <AnswerTag>{state[FAMILY_SIZE_SURVEY_ID].name}</AnswerTag>
          <AnswerTag>{state[PURPOSE_SURVEY_ID].name}</AnswerTag>
          <AnswerTag>{state[VIEWPOINT_SURVEY_ID].name}</AnswerTag>
          <AnswerTag>{state["maxBudget"]}만원</AnswerTag>
        </AnswerTagContainer>
        <Title>질문에 기반한 추천 차량이에요.</Title>
        <Subtitle>전국의 카마스터분들이 엄선하여 추천했어요.</Subtitle>
        <Img src={PalisadeImg} />
      </SummaryContent>

      <BottomFiller></BottomFiller>
    </Wrapper>
  );
};
const Title = styled.div`
  ${({ theme }) => theme.font.Extra10};

  margin-top: 16px;
`;
const Subtitle = styled.div`
  ${({ theme }) => theme.font.Body4_Regular};
  color: ${({ theme }) => theme.color.grey200};

  margin-top: 8px;
`;
const AnswerTag = styled.div`
  display: flex;
  align-items: center;
  justify-content: center;

  color: ${({ theme }) => theme.color.grey300};
  ${({ theme }) => theme.font.Extra9};

  border: 1px solid ${({ theme }) => theme.color.grey600};
  border-radius: 30px;

  padding: 6px 10px;
`;
const AnswerTagContainer = styled.div`
  display: flex;
  gap: 6px;

  margin-top: 64px;
`;
const SummaryContent = styled.div`
  position: relative;
  display: flex;
  flex-direction: column;

  width: 608px;
`;
const BottomFiller = styled.div`
  position: absolute;
  bottom: 0;
  z-index: 1;

  width: 100%;
  height: 116px;

  background-color: ${({ theme }) => theme.color.grey300};
`;
const slideImg = keyframes`
  from {
    left:450px;
  }
  to {
    left: 278px;
  }
`;
const Img = styled.img`
  position: absolute;
  left: 278px;

  width: 600px;
  z-index: 2;

  animation: ${slideImg} 0.7s ease-out;
`;
const Wrapper = styled.div`
  display: flex;
  position: relative;
  justify-content: center;

  width: 100%;
  height: 334px;

  background-color: ${({ theme }) => theme.color.extra1};
`;

export default QNASummary;
