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
  width: 473px;

  overflow-y: scroll;
`;
const Component1 = styled.div`
  flex: 1;
  height: 100%;

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
