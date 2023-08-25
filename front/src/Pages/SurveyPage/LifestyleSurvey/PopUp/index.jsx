import React from "react";
import { css, styled } from "styled-components";
import Cover from "./Cover";
import Detail from "./Detail";

const PopUp = ({ popupRef, value }) => {
  return (
    <Wrapper ref={popupRef}>
      <Cover value={value} />
      <Detail value={value} />
    </Wrapper>
  );
};

const Wrapper = styled.div`
  position: relative;

  width: 100%;
  max-width: 688px;
  height: 1318px;
  flex-shrink: 0;

  background-color: ${({ theme }) => theme.color.grey1000};
  border-radius: 20px;

  z-index: 12;
  margin: 610px 0px 100px;
`;

export default PopUp;
