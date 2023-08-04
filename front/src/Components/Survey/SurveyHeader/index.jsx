import React from "react";
import { styled } from "styled-components";
import PageIndicator from "../PageIndicator";

const SurveyHeader = ({ index }) => {
  const titleMap = {
    1: (
      <>
        <strong>나이</strong>를 알려주세요.
      </>
    ),
    2: (
      <>
        유사한 <strong>라이프스타일</strong>을 선택하면 <br /> 차량 조합을
        추천해 드려요.
      </>
    ),
  };
  return (
    <Wrapper>
      <Title>{titleMap[index]}</Title>
      <PageIndicator crntPage={index} totalPage={2} />
    </Wrapper>
  );
};

const Title = styled.div`
  ${({ theme }) => theme.font.Extra1}

  strong {
    font-weight: bold;
  }
`;
const Wrapper = styled.div`
  display: flex;
  align-items: center;
  justify-content: space-between;
`;
export default SurveyHeader;
