import React from "react";
import { styled, css } from "styled-components";

const Button = ({ text, style }) => {
  return <CommonButton style={style}>{text}</CommonButton>;
};

const ButtonStyle = css`
  width: ${(props) => props.width};
  height: ${(props) => props.height};

  border: ${(props) => props.border};
  border-radius: ${(props) => props.borderRadius};

  background-color: ${(props) => props.backgroundColor};
  color: ${(props) => props.color};
`;

const CommonButton = styled.button`
  display: flex;
  justify-content: center;
  align-items: center;

  ${ButtonStyle}
`;

export default Button;
