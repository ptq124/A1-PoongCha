import React from "react";
import { styled } from "styled-components";

const RadioBtn = ({ id, onChange }) => {
  return (
    <RadioBtnContainer>
      <RadioBtnInput id={id} onChange={onChange}></RadioBtnInput>
    </RadioBtnContainer>
  );
};

const RadioBtnContainer = styled.div`
  display: none;
`;
const RadioBtnInput = styled.input.attrs({ type: "radio" })``;

export default RadioBtn;
