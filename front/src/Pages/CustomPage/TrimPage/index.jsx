import React from "react";
import { styled } from "styled-components";
import TrimCustomBar from "./TrimCustomBar";
import CarView from "../../../Components/Custom/CarView";

const TrimPage = () => {
  return (
    <Wrapper>
      <CarView></CarView>
      <TrimCustomBar />
    </Wrapper>
  );
};

const Wrapper = styled.div`
  display: flex;
  width: 100%;
  height: 100%;
  justify-content: flex-end;

  padding-top: 121px;

  box-sizing: border-box;
`;

export default TrimPage;
