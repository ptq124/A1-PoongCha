import React, { useEffect, useState } from "react";
import { useLocation } from "react-router";
import { keyframes, styled } from "styled-components";

const ProgressBar = () => {
  const { pathname } = useLocation();
  const [progressStatus, setProgressStatus] = useState(0);
  useEffect(() => {
    setProgressStatus(pathname === "/survey/age" ? 0.5 : 1);
  }, [pathname]);

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
