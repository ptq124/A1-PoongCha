import React, { useState } from "react";
import { css, styled } from "styled-components";
import { useLocation } from "react-router";
import Button from "@Components/Common/Button/Button";
import useButtonNavigation from "@hooks/useButtonNavigation";
import Dropdown from "./DropDown";
import { useUserData } from "context/UserDataContext";

let navItems = [
  { title: "1 트림", detail: "Le Blanc(르블랑)", path: "/custom/trim" },
  {
    title: "2 색상",
    detail: "어비스 블랙펄 / 퀄팅 천연(블랙)",
    path: "/custom/color",
  },
  {
    title: "3 옵션",
    detail: "컴포트2, 현대 스마트 센스 1, 주차보조",
    path: "/custom/option",
  },
];

const Navigation = () => {
  const { pathname } = useLocation();

  const move = useButtonNavigation();

  const [isPopupOpen, setIsPopupOpen] = useState(false);

  const {
    totalData: { 트림, 엔진, 바디, 구동방식, 옵션, 외장, 내장 },
    estimated,
  } = useUserData();

  navItems[0].detail = `${트림.trimName}`;
  navItems[1].detail = `${외장.name} / ${내장.name}`;
  navItems[2].detail = `${옵션.map((option) => option.name).join(", ")}`;

  return (
    <>
      <Wrapper>
        <NavContainer>
          {navItems.map((item, index) => (
            <Nav key={index}>
              <NavTitle
                $active={item.path === pathname}
                onClick={() => move(item.path)}
              >
                {item.title}
              </NavTitle>
              <NavDetail>{item.detail}</NavDetail>
            </Nav>
          ))}
        </NavContainer>
        <BtnsContainer>
          <Button
            text="요금 상세"
            style={amountDetailBtnStyle}
            onClick={() => setIsPopupOpen(!isPopupOpen)}
          />
          <Button
            text={estimated.toLocaleString() + "원 견적내기"}
            style={estimateBtnStyle}
            onClick={() => move("/result")}
          />
        </BtnsContainer>
      </Wrapper>
      {isPopupOpen && (
        <Dropdown
          closePopup={() => setIsPopupOpen(false)}
          estimatedPrice={estimated}
        />
      )}
    </>
  );
};

const amountDetailBtnStyle = css`
  height: 40px;

  background-color: ${({ theme }) => theme.color.grey1000};
  color: ${({ theme }) => theme.color.grey400};
  ${({ theme }) => theme.font.Body4_Medium};

  border-radius: 4px;
  border: 1px solid #d9d9d9;

  padding: 14px 20px;
`;

const estimateBtnStyle = css`
  width: 166px;
  height: 40px;

  background-color: ${({ theme }) => theme.color.primary_default};
  color: ${({ theme }) => theme.color.grey1000};
  ${({ theme }) => theme.font.Body4_Medium};

  border-radius: 4px;
  border: 1px solid ${({ theme }) => theme.color.primary_default};
`;

const NavDetail = styled.div`
  ${({ theme }) => theme.font.Body4_Regular};
  color: ${({ theme }) => theme.color.grey400};
`;

const NavTitle = styled.div`
  ${({ theme }) => theme.font.Body4_Medium};
  color: ${({ $active, theme }) =>
    $active ? theme.color.primary_default : theme.color.grey600};
  &:hover {
    cursor: pointer;
  }
`;

const Nav = styled.div`
  display: flex;
  gap: 12px;

  &:nth-child(2) div:nth-child(2) {
    width: 165px;
    overflow: hidden;
    text-overflow: ellipsis;
    white-space: nowrap;
  }
  &:nth-child(3) div:nth-child(2) {
    width: 300px;
    overflow: hidden;
    text-overflow: ellipsis;
    white-space: nowrap;
  }
`;

const NavContainer = styled.div`
  display: flex;
  align-items: flex-end;

  gap: 25px;
`;

const Wrapper = styled.div`
  position: relative;

  display: flex;
  justify-content: space-between;

  padding: 10px 128px 16px;
`;

const BtnsContainer = styled.div`
  display: flex;

  gap: 8px;
`;

export default Navigation;
