import React from "react";
import { styled } from "styled-components";

const DefaultOptionPopup = ({ popupRef }) => {
  return <Wrapper ref={popupRef}>hi</Wrapper>;
};

const Wrapper = styled.div`
  position: absolute;
  width: 300px;
  height: 420px;

  /* background-color: ${({ theme }) => theme.color.grey1000}; */
  background-color: beige;
`;
export default DefaultOptionPopup;
