import React from "react";
import { styled } from "styled-components";
import { Outlet } from "react-router-dom";

const SurveyPage = () => {
  return (
    <Wrapper>
      <Outlet />
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
