import React, { useState } from "react";
import { styled } from "styled-components";
import ColorOption from "./ColorOption";
import ArrowDownIcon from "../../../assets/icons/24-chevron-down.svg";
import ArrowUpIcon from "../../../assets/icons/24-chevron-up.svg";

const ColorOptionGroup = () => {
  const [isDropdownOpen, setIsDropdownOpen] = useState(false);
  return (
    <Wrapper>
      <Header>외장 색상</Header>
      <Subtitle>
        <span className="color">그라파이트 그레이 메탈릭</span>
        <span className="stat">
          <strong>75%</strong>의 구매자가 선택한
        </span>
      </Subtitle>
      <OptionsContainer>
        <ColorOption />
        <ColorOption />
        <ColorOption />
        <ColorOption />
        <ColorOption />
      </OptionsContainer>
      <Dropdown>
        <DropdownTitle>
          <span>다른 외장 색상을 찾고 있나요?</span>
          {isDropdownOpen ? (
            <img src={ArrowUpIcon} onClick={() => setIsDropdownOpen(false)} />
          ) : (
            <img src={ArrowDownIcon} onClick={() => setIsDropdownOpen(true)} />
          )}
        </DropdownTitle>
        {isDropdownOpen && (
          <OptionsContainer>
            <ColorOption />
            <ColorOption />
            <ColorOption />
          </OptionsContainer>
        )}
      </Dropdown>
    </Wrapper>
  );
};
const DropdownTitle = styled.div`
  display: flex;
  justify-content: space-between;
`;
const Dropdown = styled.div`
  width: 308px;
  border-radius: 4px;
  border: 1px solid ${({ theme }) => theme.color.primary_default};
  padding: 11px 16px;
  box-sizing: border-box;
  span {
    color: ${({ theme }) => theme.color.primary_default};
    ${({ theme }) => theme.font.Body4_Medium};
  }
  img:hover {
    cursor: pointer;
  }
`;
const OptionsContainer = styled.div`
  display: flex;
  width: 100%;
  flex-wrap: wrap;
  margin-top: 12px;
  gap: 12px;
`;
const Subtitle = styled.div`
  display: flex;
  justify-content: space-between;
  align-items: center;

  .color {
    color: ${({ theme }) => theme.color.grey100};
    ${({ theme }) => theme.font.Body4_Medium};
  }
  .stat {
    color: ${({ theme }) => theme.color.grey300};
    ${({ theme }) => theme.font.Caption1_Medium};
    strong {
      color: ${({ theme }) => theme.color.secondary};
    }
  }
  margin-top: 16px;
`;
const Header = styled.div`
  ${({ theme }) => theme.font.Head2};
`;
const Wrapper = styled.div`
  display: flex;
  flex-direction: column;
  margin-top: 24px;
`;
export default ColorOptionGroup;
