import useOnClickPopUp from "@hooks/useOnClickPopUp";
import React, { useRef, useState } from "react";
import { styled } from "styled-components";
import OverlaidPopup from "../OverlaidPopup";

const PopupProvider = ({ label, children }) => {
  const popupRef = useRef();
  const { isPopupOpen, openPopup, closePopup } = useOnClickPopUp(popupRef);
  return (
    <Wrapper onClick={openPopup}>
      {isPopupOpen && (
        <OverlaidPopup
          component={React.cloneElement(label, { closePopup, popupRef })}
        />
      )}
      {children}
    </Wrapper>
  );
};

const Wrapper = styled.div``;
export default PopupProvider;
