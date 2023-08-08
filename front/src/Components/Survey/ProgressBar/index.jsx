import React from "react";
import { useLocation } from "react-router";
import { keyframes, styled } from "styled-components";

const ProgressBar = () => {
  const { pathname } = useLocation();
  const progressStatus = pathname === "/survey/age" ? 0.5 : 1;

  return (
    <Wrapper>
      <Progress $progressStatus={progressStatus}></Progress>
    </Wrapper>
  );
};

const Progress = styled.div`
  width: ${({ $progressStatus }) => $progressStatus * 100}%;
  height: 4px;
  background-color: ${({ theme }) => theme.color.secondary};
  transition: width 0.3s ease;
`;
const Wrapper = styled.div`
  width: 100%;
  height: 4px;
  background-color: ${({ theme }) => theme.color.grey800};
`;
export default ProgressBar;
