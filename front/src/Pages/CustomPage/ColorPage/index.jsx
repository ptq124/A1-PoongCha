import React from "react";
import { styled } from "styled-components";
import CarView from "../../../Components/Custom/CarView";
import TrimCustomSideBar from "../TrimPage/TrimCustomSideBar";

const ColorPage = () => {
  return (
    <Wrapper>
      <CarView></CarView>
      <TrimCustomSideBar />
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

export default ColorPage;
