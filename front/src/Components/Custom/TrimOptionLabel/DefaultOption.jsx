import React, { useRef } from "react";
import { css, styled } from "styled-components";
import DefaultOptionPopup from "../DefaultOptionPopup";
import Button from "@Components/Common/Button/Button";
import useOnClickPopUp from "@hooks/useOnClickPopUp";

const DefaultOption = ({ option }) => {
  const popupRef = useRef();
  const { isPopupOpen, openPopup, closePopup } = useOnClickPopUp(popupRef);

  return (
    <Wrapper>
      {isPopupOpen && (
        <DefaultOptionPopup
          popupRef={popupRef}
          closePopup={closePopup}
          option={option}
        />
      )}
      <Button
        text={option.name}
        style={DefaultOptionBtnStyle}
        onClick={() => openPopup()}
      ></Button>
    </Wrapper>
  );
};

const DefaultOptionBtnStyle = css`
  display: flex;
  text-align: left;

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
const Wrapper = styled.div`
  position: relative;
  display: flex;
  flex-wrap: wrap;
`;
export default DefaultOption;
