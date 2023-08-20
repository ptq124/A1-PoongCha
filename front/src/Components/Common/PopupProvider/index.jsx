import useOnClickPopUp from "@hooks/useOnClickPopUp";
import React, { useRef } from "react";
import { styled } from "styled-components";
import OverlaidPopup from "../OverlaidPopup";

const PopupProvider = ({ label, children }) => {
  const popupRef = useRef();
  const { isPopupOpen, openPopup, closePopup } = useOnClickPopUp(popupRef);
  return (
    <Wrapper>
      {isPopupOpen && (
        <OverlaidPopup
          component={React.cloneElement(label, { closePopup, popupRef })}
        />
      )}
      {React.cloneElement(children, {
        ...children.props,
        onClick: openPopup,
      })}
    </Wrapper>
  );
};

const Wrapper = styled.div``;
export default PopupProvider;
