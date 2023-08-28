import React, { useState } from "react";
import { styled, css } from "styled-components";
import headerDownArrowBlack from "@assets/icons/headerDownArrowBlack.svg";
import headerDownArrow from "@assets/icons/headerDownArrow.svg";
import headerDownArrowSmall from "@assets/icons/headerDownArrowSmall.svg";

const SelectOption = ({ pathname }) => {
  const [isOpen, setIsOpen] = useState(false);
  const [option, setOption] = useState(["펠리세이드"]);

  const handleToggle = () => {
    setIsOpen((prevState) => !prevState);
  };

  const handleOptionClick = (index) => {
    setOption([option[index], ...option.filter((_, i) => i !== index)]);
  };

  const getArrowImage = () => {
    switch (pathname) {
      case "/":
        return <img src={headerDownArrow} alt="headerDownArrow" />;
      case "/etc_end":
      case "/survey_end":
        return <img src={headerDownArrowBlack} alt="headerDownArrowBlack" />;
      default:
        return <img src={headerDownArrowSmall} alt="headerDownArrowSmall" />;
    }
  };

  return (
    <SelectWrapper onClick={handleToggle} $pathname={pathname}>
      <span>{option[0]}</span>
      {getArrowImage()}
      {isOpen && (
        <OptionList $isOpen={isOpen} $pathname={pathname}>
          {option.map(
            (item, index) =>
              index !== 0 && (
                <li key={index} onClick={() => handleOptionClick(index)}>
                  {item}
                </li>
              )
          )}
        </OptionList>
      )}
    </SelectWrapper>
  );
};

const OptionList = styled.ul`
  position: absolute;
  top: 100%;
  left: 0;

  display: ${($isOpen) => ($isOpen ? "block" : "none")};

  li {
    ${({ $pathname }) =>
      $pathname === "/"
        ? css`
            color: ${({ theme }) => theme.color.grey600};
          `
        : css`
            color: ${({ theme }) => theme.color.grey50};
          `}

    padding-top: 2%;
  }
`;

const SelectWrapper = styled.div`
  display: flex;
  align-items: center;
  position: relative;

  width: 96px;
  height: 22px;

  gap: 4px;

  span {
    ${({ $pathname }) =>
      $pathname === "/"
        ? css`
            color: ${({ theme }) => theme.color.grey600};
          `
        : css`
            color: ${({ theme }) => theme.color.grey50};
          `}

    padding-top: 2%;
  }

  ${({ theme }) => theme.font.Head4};
`;

export default SelectOption;
