import React from "react";
import { styled } from "styled-components";
import TrimCustomBar from "./TrimCustomBar";

const TrimPage = () => {
  return (
    <Wrapper>
      <Component1></Component1>
      <TrimCustomBar />
    </Wrapper>
  );
};

const Component1 = styled.div`
  position: fixed;

  width: 71%;
  height: 100%;

  left: 0;

  background-color: beige;
`;
const Wrapper = styled.div`
  display: flex;
  width: 100%;
  height: 100%;
  justify-content: flex-end;

  padding-top: 121px;

  box-sizing: border-box;
`;
export default TrimPage;
