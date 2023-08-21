import React from "react";
import { css, styled } from "styled-components";

const OptionTagLabel = ({ option, selectedItem, handleSelectItem }) => {
  const isSelected = selectedItem === option.name;
  return (
    <Wrapper
      $isSelected={isSelected}
      onClick={() => handleSelectItem(option.name)}
    >
      <TagImg
        src={isSelected ? option.activeIcon : option.inactiveIcon}
      ></TagImg>
      {option.name}
    </Wrapper>
  );
};

const TagImg = styled.img`
  height: 22px;
`;
const Wrapper = styled.div`
  display: flex;
  align-items: center;

  border-radius: 4px;
  ${({ theme }) => theme.font.Body4_Regular};

  ${({ $isSelected }) =>
    $isSelected
      ? css`
          color: ${({ theme }) => theme.color.primary_default};
          background: ${({ theme }) => theme.color.grey1000};
          border: 1.5px solid;
          border-color: ${({ theme }) => theme.color.primary_default};
        `
      : css`
          color: ${({ theme }) => theme.color.grey400};
          background: ${({ theme }) => theme.color.grey800};
          border: 1.5px solid;
          border-color: ${({ theme }) => theme.color.grey800};
        `};

  gap: 8px;
  padding: 7px 10px;
  cursor: pointer;
  box-sizing: border-box;
`;
export default OptionTagLabel;
