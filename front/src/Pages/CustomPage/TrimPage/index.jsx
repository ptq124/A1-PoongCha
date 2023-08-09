import React from "react";
import { styled } from "styled-components";
import TrimCustomBar from "./TrimCustomBar";

const TrimPage = () => {
  return (
    <Wrapper>
      <Component1></Component1>
      <CustomBarWrapper>
        <TrimCustomBar />
      </CustomBarWrapper>
    </Wrapper>
  );
};

const CustomBarWrapper = styled.div`
  width: 30%;
  margin-left: 70%;
`;
const Component1 = styled.div`
  position: fixed;

  width: 70%;
  height: 100%;

  left: 0;

  background-color: beige;
`;
const Wrapper = styled.div`
  display: flex;
  width: 100%;
  height: 100%;
  justify-content: center;

  margin-right: 128px;
  padding-top: 121px;

  overflow: scroll;

  box-sizing: border-box;
`;
export default TrimPage;
