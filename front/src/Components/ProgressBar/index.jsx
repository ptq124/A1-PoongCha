import React from "react";
import { styled } from "styled-components";

const ProgressBar = ({ progress }) => {
  return (
    <ProgressBarContainer>
      <Progress $progress={progress}></Progress>
    </ProgressBarContainer>
  );
};

const Progress = styled.div`
  width: ${({ $progress }) => $progress * 100}%;
  height: 4px;
  background-color: ${({ theme }) => theme.color.secondary};
`;
const ProgressBarContainer = styled.div`
  width: 100%;
  height: 4px;
  background-color: ${({ theme }) => theme.color.grey800};
`;
export default ProgressBar;
