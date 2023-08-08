import React from "react";
import { css, styled } from "styled-components";

const ModelItemOption = ({
  label,
  radioGroup,
  selected,
  handleOptionSelect,
}) => {
  return (
    <Label selected={selected}>
      {label}
      <Radio type="radio" onChange={handleOptionSelect} name={radioGroup} />
    </Label>
  );
};

const Radio = styled.input`
  display: none;
`;
const Label = styled.label`
  display: flex;
  align-items: center;
  justify-content: center;

  width: 50%;
  height: 40px;

  color: ${({ theme }) => theme.color.primary_default};
  background-color: beige;
  ${({ theme }) => theme.font.Body4_Medium};

  border-radius: 6px;

  box-sizing: border-box;

  &:hover {
    cursor: pointer;
  }
  ${(props) =>
    props.selected
      ? css`
          background-color: ${({ theme }) => theme.color.grey1000};
          ${({ theme }) => theme.font.Body4_Medium};
          color: ${({ theme }) => theme.color.primary_default};
          border: 1.5px solid ${({ theme }) => theme.color.primary_default};
        `
      : css`
          background-color: ${({ theme }) => theme.color.grey800};
          ${({ theme }) => theme.font.Body4_Regular};
          color: ${({ theme }) => theme.color.grey500};
        `}
`;
export default ModelItemOption;
