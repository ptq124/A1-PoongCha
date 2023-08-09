import React from "react";
import { styled } from "styled-components";
import CarImg from "./CarImg";

const CarView = () => {
  return (
    <Wrapper>
      <BackgrondTop />
      <BackgrondBottom />
      <CarImg />
    </Wrapper>
  );
};
const BackgrondTop = styled.div`
  height: 50%;
  width: 100%;
  background: rgba(0, 66, 142, 0.1);
`;
const BackgrondBottom = styled.div`
  height: 50%;
  width: 100%;
  background: linear-gradient(
    180deg,
    rgba(0, 66, 142, 0.3) 0%,
    rgba(255, 255, 255, 0) 100%
  );
`;
const Wrapper = styled.div`
  position: fixed;

  display: flex;
  flex-direction: column;

  width: 71%;
  height: 100%;

  left: 0;
`;

export default CarView;
