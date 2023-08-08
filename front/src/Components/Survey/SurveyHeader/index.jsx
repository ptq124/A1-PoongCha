import React from "react";
import { styled } from "styled-components";
import PageIndicator from "../PageIndicator";

const titleMap = {
  Age: {
    id: 1,
    isExtra: false,
    title: (
      <>
        <strong>나이</strong>를 알려주세요.
      </>
    ),
  },
  Lifestyle: {
    id: 2,
    isExtra: false,
    title: (
      <>
        유사한 <strong>라이프스타일</strong>을 선택하면 <br /> 차량 조합을
        추천해 드려요.
      </>
    ),
  },
  Extra: {
    id: 3,
    isExtra: true,
    title: (
      <>
        당신의 <strong>라이프스타일</strong>을 알려주세요.
      </>
    ),
    subtitle: <>당신의 라이프스타일을 반영한 차를 추천해 드릴게요.</>,
  },
};

const SurveyHeader = ({ surveyType }) => {
  return (
    <Wrapper>
      <TitleWrapper>
        <Title>{titleMap[surveyType].title}</Title>
        {!titleMap[surveyType].isExtra && (
          <PageIndicator crntPage={titleMap[surveyType].id} totalPage={2} />
        )}
      </TitleWrapper>

      {titleMap[surveyType].subtitle && (
        <Subtitle>{titleMap[surveyType].subtitle}</Subtitle>
      )}
    </Wrapper>
  );
};

const Subtitle = styled.div`
  color: ${({ theme }) => theme.color.grey300};
  ${({ theme }) => theme.font.Body4_Regular};

  margin-top: 8px;
`;
const Title = styled.div`
  ${({ theme }) => theme.font.Extra1};
  strong {
    font-family: "HyundaiSansHeadMediumKR";
  }
`;
const TitleWrapper = styled.div`
  display: flex;
  justify-content: space-between;
`;
const Wrapper = styled.div`
  display: flex;
  flex-direction: column;
`;

export default SurveyHeader;
