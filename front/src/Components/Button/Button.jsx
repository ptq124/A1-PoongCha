import React from "react";
import { styled, css } from "styled-components";

const Button = ({ text, style }) => {
  return <CommonButton $style={style}>{text}</CommonButton>;
};

const CommonButton = styled.button`
  display: flex;
  justify-content: center;
  align-items: center;

  ${({ $style }) => $style}
`;

export default Button;
