import React from "react";
import { styled, css } from "styled-components";
import OptionalHeader from "../Header/OptionalHeader/index";
import HyundaiLogo from "../../assets/icons/hyundai-logo.svg";
import HyundaiWhiteLogo from "../../assets/icons/hyundai-logo-white.svg";
import { useLocation } from "react-router-dom";

const Header = () => {
  const { pathname } = useLocation();

  const getLogoImage = () => {
    switch (pathname) {
      case "/":
        return <img src={HyundaiWhiteLogo} alt="Hyundai White Logo" />;
      default:
        return <img src={HyundaiLogo} alt="Hyundai Logo" />;
    }
  };

  return (
    <HeaderWrapper>
      <DefaultHeader $pathname={pathname}>
        {getLogoImage()}
        <HeaderTitle $pathname={pathname}>펠리세이드</HeaderTitle>
      </DefaultHeader>
      <OptionalHeader />
    </HeaderWrapper>
  );
};

const HeaderWrapper = styled.div`
  position: absolute;

  display: flex;
  flex-direction: column;

  width: 100%;
  min-height: 92px;

  padding-top: 33px;

  box-sizing: border-box;
  overflow-y: auto;
  z-index: 10;
`;

const DefaultHeader = styled.div`
  display: flex;
  align-items: center;

  padding: 0px 128px;

  ${({ $pathname }) =>
    $pathname === "/"
      ? css`
          gap: 16px;
        `
      : css`
          gap: 24px;
        `}
`;

const HeaderTitle = styled.span`
  ${({ $pathname }) =>
    $pathname === "/"
      ? css`
          color: ${({ theme }) => theme.color.grey600};
        `
      : css`
          color: ${({ theme }) => theme.color.grey50};
        `}

  ${({ theme }) => theme.font.Head4};
`;

export default Header;
