import React from "react";
import { styled } from "styled-components";

const BackgroundOverlay = () => {
  return <Wrapper></Wrapper>;
};

const Wrapper = styled.div`
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, 0.5);
  /* z-index: 998; */
`;

export default BackgroundOverlay;
