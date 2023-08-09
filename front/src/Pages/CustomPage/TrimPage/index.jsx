import React from "react";
import { styled } from "styled-components";
import TrimCustomSideBar from "./TrimCustomSideBar";

const TrimPage = () => {
  return (
    <Wrapper>
      <Component1></Component1>
      <TrimCustomSideBar />
    </Wrapper>
  );
};

const Component1 = styled.div`
  flex: 0 0 auto;
  width: calc(100% - 473px);
  position: fixed;

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
