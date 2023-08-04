import React, { useState } from "react";
import { styled } from "styled-components";
import AgeSurvey from "./AgeSurvey";
import LifestyleSurvey from "./LifestyleSurvey";

const surveyPageInfo = [
  {
    id: 0,
    page: 1,
    title: "<strong>나이</strong>를 알려주세요.",
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
  },
  {
    id: 1,
    page: 2,
    title: "유사한 라이프스타일을 선택하면 차량 조합을 추천해 드려요.",
  },
];
const SurveyPage = () => {
  const [page, setPage] = useState("Age");
  const Pages = {
    Age: (
      <AgeSurvey
        data={surveyPageInfo[0]}
        buttonHandler={() => setPage("Lifestyle")}
      />
    ),
    Lifestyle: <LifestyleSurvey />,
  };
  return <Wrapper>{Pages[page]}</Wrapper>;
};

const Wrapper = styled.div`
  width: 100%;

  display: flex;
  justify-content: center;
`;
export default SurveyPage;
