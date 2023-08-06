import React, { useState } from "react";
import { styled } from "styled-components";
import AgeSurvey from "./AgeSurvey";
import LifestyleSurvey from "./LifestyleSurvey";
import ExtraSurvey from "./ExtraSurvey";
import ProgressBar from "../../Components/Survey/ProgressBar";
import { useNavigate } from "react-router-dom";

const SurveyPage = () => {
  const navigate = useNavigate();
  const [page, setPage] = useState(0);
  const Pages = {
    0: <AgeSurvey buttonHandler={() => setPage(1)} />,
    1: <LifestyleSurvey linkHandler={() => setPage(2)} />,
    2: <ExtraSurvey buttonHandler={() => navigate("/etc_end")} />,
  };
  return (
    <Wrapper>
      {page < 2 && <ProgressBar progress={(page + 1) / 2} />}
      {Pages[page]}
    </Wrapper>
  );
};

const Wrapper = styled.div`
  width: 100%;
  display: flex;
  flex-direction: column;
  align-items: center;
`;
export default SurveyPage;
