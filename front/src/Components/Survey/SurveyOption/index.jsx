import React from "react";
import { css, styled } from "styled-components";
import RadioBtn from "../../Common/RadioBtn";
import Check24BlueIcon from "../../../assets/checkcircle/check-24-blue.svg";

const SurveyOption = ({
  label,
  radioGroup,
  selected,
  handleOptionSelect,
  isLong,
}) => {
  return (
    <>
      <SurveyOptionLabel selected={selected} $isLong={isLong}>
        {label}
        {selected && <img src={Check24BlueIcon} alt="check" />}
        <RadioBtn onChange={handleOptionSelect} name={radioGroup} />
      </SurveyOptionLabel>
    </>
  );
};

const SurveyOptionLabel = styled.label`
  width: ${(props) => (props.$isLong ? "100%" : "298px")};
  height: 56px;

  display: flex;
  align-items: center;
  justify-content: space-between;

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

export default SurveyOption;
