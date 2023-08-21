import React from "react";
import { css, styled } from "styled-components";
import Check24BlueIcon from "../../../assets/checkcircle/check-24-blue.svg";

const ExtraQuestionLabel = ({ option, selectedItem, handleSelectItem }) => {
  return (
    <>
      <Label
        selected={option === selectedItem}
        onClick={() => handleSelectItem(option)}
      >
        {option}
        {option === selectedItem && <img src={Check24BlueIcon} alt="check" />}
      </Label>
    </>
  );
};

const Label = styled.label`
  display: flex;
  align-items: center;
  justify-content: space-between;
  //width
  width: 298px;
  height: 56px;

  border-radius: 6px;

  box-sizing: border-box;

  padding: 17px 12px;

  &:hover {
    cursor: pointer;
  }
  ${(props) =>
    props.selected
      ? css`
          background-color: ${({ theme }) => theme.color.grey1000};
          ${({ theme }) => theme.font.Body2_Bold};
          color: ${({ theme }) => theme.color.primary_default};
          border: 1.5px solid ${({ theme }) => theme.color.primary_default};
        `
      : css`
          background-color: ${({ theme }) => theme.color.grey800};
          ${({ theme }) => theme.font.Extra5};
          color: ${({ theme }) => theme.color.grey500};
        `}
`;

export default ExtraQuestionLabel;
