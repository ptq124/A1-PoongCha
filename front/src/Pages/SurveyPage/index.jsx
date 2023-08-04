import React, { useState } from "react";
import { styled } from "styled-components";
import AgeSurvey from "./AgeSurvey";
import LifestyleSurvey from "./LifestyleSurvey";
import ExtraSurvey from "./ExtraSurvey";

const SurveyPage = () => {
  const [page, setPage] = useState("Age");
  const Pages = {
    Age: <AgeSurvey buttonHandler={() => setPage("Lifestyle")} />,
    Lifestyle: <LifestyleSurvey linkHandler={() => setPage("Extra")} />,
    Extra: <ExtraSurvey />,
  };
  return <Wrapper>{Pages[page]}</Wrapper>;
};

const Wrapper = styled.div`
  width: 100%;

  display: flex;
  justify-content: center;
`;
export default SurveyPage;
