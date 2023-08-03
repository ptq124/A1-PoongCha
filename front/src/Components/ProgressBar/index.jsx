import React from "react";
import { styled } from "styled-components";

const ProgressBar = ({ progress }) => {
  return (
    <Wrapper>
      <Progress $progress={progress}></Progress>
    </Wrapper>
  );
};

const Progress = styled.div`
  width: ${({ $progress }) => $progress * 100}%;
  height: 4px;
  background-color: ${({ theme }) => theme.color.secondary};
`;
const Wrapper = styled.div`
  width: 100%;
  height: 4px;
  background-color: ${({ theme }) => theme.color.grey800};
  margin-top: 39px;
`;
export default ProgressBar;
