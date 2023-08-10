import React from "react";
import BackgroundOverlay from "./BackgroundOverlay";
import { styled } from "styled-components";

const OverlaidPopup = ({ component }) => {
  return (
    <Wrapper>
      <BackgroundOverlay />
      {component}
    </Wrapper>
  );
};
const Wrapper = styled.div`
  display: flex;
  justify-content: center;
  position: fixed;
  top: 0;
  left: 0;

  width: 100%;
  height: 100%;
  z-index: 12;
  align-items: center;
`;
export default OverlaidPopup;
