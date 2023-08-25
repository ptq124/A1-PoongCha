import React from "react";
import styled from "styled-components";

const Loading = () => {
  return (
    <Overlay>
      <Spinner></Spinner>
    </Overlay>
  );
};

const Overlay = styled.div`
  display: flex;
  justify-content: center;
  align-items: center;

  height: 300px;
`;

const Spinner = styled.div`
  border: 4px solid #bebebe;
  border-top: 4px solid #00428e;
  border-radius: 50%;
  width: 40px;
  height: 40px;
  animation: spin 1s linear infinite;

  @keyframes spin {
    0% {
      transform: rotate(0deg);
    }
    100% {
      transform: rotate(360deg);
    }
  }
`;

export default Loading;
