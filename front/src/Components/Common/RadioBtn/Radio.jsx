import React from "react";
import { css, styled } from "styled-components";

const Radio = ({ name, value, index }) => {
  return (
    <LabelTag checked={value}>
      옵션
      <RadioTag name={name} value={value} id={index}></RadioTag>
    </LabelTag>
  );
};

export default Radio;
