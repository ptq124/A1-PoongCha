import React, { useRef, useState } from "react";
import { css, styled } from "styled-components";
import { useLocation } from "react-router";
import Button from "../../../Common/Button/Button";
import useOnClickPopUp from "../../../../hooks/useOnClickPopUp";
import useButtonNavigation from "../../../../hooks/useButtonNavigation";
import Dropdown from "./DropDown";

const navItems = [
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

  const popupRef = useRef();
  const { isPopupOpen, openPopup, closePopup } = useOnClickPopUp(popupRef);

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
            style={amoutDetailBtnStyle}
            onClick={openPopup}
          />
          <Button
            text="견적내기"
            style={estimateBtnStyle}
            onClick={() => move("/result")}
          />
        </BtnsContainer>
      </Wrapper>
      {isPopupOpen && <Dropdown popupRef={popupRef} closePopup={closePopup} />}
    </>
  );
};

const amoutDetailBtnStyle = css`
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
`;

const Nav = styled.div`
  display: flex;
  gap: 12px;
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
