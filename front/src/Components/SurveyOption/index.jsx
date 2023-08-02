import React, { useState } from "react";
import { css, styled } from "styled-components";
import RadioBtn from "../Common/RadioBtn";
import Check24BlueIcon from "../../assets/icons/check_24_blue.svg";

const SurveyOption = ({ label, index, name, selected, onChange }) => {
  return (
    <>
      <SurveyOptionLabel htmlFor={"radioInput" + index} selected={selected}>
        {label}
        {selected && <img src={Check24BlueIcon} alt="check" />}
      </SurveyOptionLabel>
      <RadioBtn id={"radioInput" + index} onChange={onChange} name={name} />
    </>
  );
};

const SurveyOptionLabel = styled.label`
  width: 298px;
  height: 56px;
  display: flex;
  align-items: center;
  justify-content: space-between;
  border-radius: 6px;
  padding: 17px 12px;
  box-sizing: border-box;
  &:hover {
    cursor: pointer;
  }
  ${(props) =>
    props.selected
      ? css`
          background-color: ${({ theme }) => theme.color.grey1000};
          border: 1.5px solid ${({ theme }) => theme.color.primary_default};
          ${({ theme }) => theme.font.Body2_Bold};
          color: ${({ theme }) => theme.color.primary_default};
        `
      : css`
          background-color: ${({ theme }) => theme.color.grey800};
          ${({ theme }) => theme.font.Body2_Medium};
          color: ${({ theme }) => theme.color.grey500};
        `}
`;

export default SurveyOption;
