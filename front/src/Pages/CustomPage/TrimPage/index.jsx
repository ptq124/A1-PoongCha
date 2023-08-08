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
  flex: 1;
  width: 100px;
  height: 100%;

  background-color: beige;
`;
const Wrapper = styled.div`
  display: flex;
  width: 100%;
  height: 100%;
  justify-content: center;

  margin-right: 128px;
`;
export default TrimPage;
