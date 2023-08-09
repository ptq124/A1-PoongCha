import React from "react";
import { styled, css } from "styled-components";
import OptionalHeader from "./OptionalHeader/index";
import HyundaiLogo from "../../assets/icons/hyundai-logo.svg";
import HyundaiWhiteLogo from "../../assets/icons/hyundai-logo-white.svg";
import { useLocation } from "react-router-dom";
import SelectOption from "./SelectOption";

const getHeaderPosition = (pathname) => {
  let position;
  switch (pathname) {
    case "/":
      position = "absolute";
      break;
    case "/custom/trim":
      position = "fixed";
      break;
    default:
      position = "relative";
      break;
  }

  return css`
    position: ${position};
  `;
};
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
    <HeaderWrapper $pathname={pathname}>
      <DefaultHeader $pathname={pathname}>
        {getLogoImage()}
        <SelectOption pathname={pathname} />
      </DefaultHeader>
      <OptionalHeader />
    </HeaderWrapper>
  );
};

const HeaderWrapper = styled.div`
  ${({ $pathname }) => getHeaderPosition($pathname)};
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

export default Header;
