import React from "react";
import { styled } from "styled-components";
const Radio = ({ children, layout, selected, onClickSelect }) => {
  return (
    <Label $layout={layout} selected={selected} onClick={onClickSelect}>
      {children}
    </Label>
  );
};
const Label = styled.label`
  ${$layout}
`;
export default Radio;
