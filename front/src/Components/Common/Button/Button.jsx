import React from "react";
import { styled, css } from "styled-components";

const Button = ({ text, style, onClick }) => {
  return (
    <CommonButton $style={style} onClick={onClick}>
      {text}
    </CommonButton>
  );
};

const CommonButton = styled.button`
  display: flex;
  justify-content: center;
  align-items: center;

  &:hover {
    cursor: pointer;
  }

  ${({ $style }) => $style}
`;

export default Button;
