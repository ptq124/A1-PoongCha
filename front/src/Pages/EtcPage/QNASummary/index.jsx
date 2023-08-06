import React from "react";
import { styled } from "styled-components";
import PalisadeImg from "../../../assets/images/etc-end-palisade.svg";
import { useLocation } from "react-router";

const QNASummary = () => {
  const { state } = useLocation();
  const AnswerTags = Object.entries(state).map(([key, value]) => (
    <AnswerTag key={key}>
      {value}
      {key == "maxBudget" && "만원"}
    </AnswerTag>
  ));
  return (
    <Wrapper>
      <SummaryContent>
        <AnswerTagContainer>{AnswerTags}</AnswerTagContainer>
        <Img src={PalisadeImg} />
      </SummaryContent>

      <BottomFiller></BottomFiller>
    </Wrapper>
  );
};
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
const Img = styled.img`
  position: absolute;
  left: 278px;

  width: 538px;
  height: 334px;
  z-index: 2;
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
