import React from "react";
import { css, styled } from "styled-components";
import Cover from "./Cover";
import Detail from "./Detail";

const PopUp = ({ popupRef }) => {
  return (
    <Wrapper ref={popupRef}>
      <Cover />
      <Detail />
    </Wrapper>
  );
};

const Wrapper = styled.div`
  position: absolute;

  width: 100%;
  max-width: 688px;
  height: 1318px;
  flex-shrink: 0;

  background-color: ${({ theme }) => theme.color.grey1000};
  border-radius: 20px;

  z-index: 10;
`;

export default PopUp;
