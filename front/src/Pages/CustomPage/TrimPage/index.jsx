import React from "react";
import { styled } from "styled-components";

const TrimPage = () => {
  return (
    <Wrapper>
      <Component1></Component1>
      <Component2></Component2>
    </Wrapper>
  );
};
const Component2 = styled.div`
  display: flex;
  justify-content: flex-end;
  height: 100%;
  width: 345px;
  background-color: beige;

  margin-right: 128px;
`;
const Component1 = styled.div`
  flex: 1;
  width: 100px;
  height: 100%;

  background-color: skyblue;
`;
const Wrapper = styled.div`
  display: flex;
  width: 100%;
  height: 100%;
  justify-content: center;
`;
export default TrimPage;
