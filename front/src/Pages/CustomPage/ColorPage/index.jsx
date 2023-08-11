import React from "react";
import { styled } from "styled-components";
import CarView from "../../../Components/Custom/CarView";
import ColorCustomSideBar from "./ColorCustomSIdeBar";

const ColorPage = () => {
  return (
    <Wrapper>
      <CarView />
      <ColorCustomSideBar />
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
