import React, { useRef, useState } from "react";
import { css, styled } from "styled-components";
import DefaultOptionPopup from "../DefaultOptionPopup";
import Button from "../../Common/Button/Button";
import useOnClickPopUp from "../../../hooks/useOnClickPopUp";

const DefaultOption = ({ option }) => {
  const popupRef = useRef();
  const { isPopupOpen, openPopup, closePopup } = useOnClickPopUp(popupRef);

  return (
    <Wrapper>
      {isPopupOpen && <DefaultOptionPopup popupRef={popupRef} />}
      <Button
        text={option}
        style={DefaultOptionBtnStyle}
        onClick={() => openPopup()}
      ></Button>
    </Wrapper>
  );
};

const DefaultOptionBtnStyle = css`
  flex-shrink: 0;

  color: ${({ theme }) => theme.color.secondary};
  background-color: ${({ theme }) => theme.color.grey1000};

  border: none;
  ${({ theme }) => theme.font.Body4_Regular};
  background: none;
  padding: 0;
  outline: 0;
  text-decoration: underline;
  text-underline-offset: 3px;

  margin-right: 12px;
`;
const Wrapper = styled.div``;
export default DefaultOption;
