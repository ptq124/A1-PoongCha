import React from "react";
import { styled, css } from "styled-components";
import OptionalHeader from "./OptionalHeader/index";
import HyundaiLogo from "../../assets/icons/hyundai-logo.svg";
import HyundaiWhiteLogo from "../../assets/icons/hyundai-logo-white.svg";
import { useLocation } from "react-router-dom";
import SelectOption from "./SelectOption";

const getHeaderStyle = (pathname) => {
  let position;
  let backgroundColor;
  let boxShadow;
  switch (pathname) {
    case "/":
    case "/result":
      position = "absolute";
      backgroundColor = "transparent";
      break;
    case "/custom/trim":
    case "/custom/color":
      position = "fixed";
      backgroundColor = "#FFF";
      boxShadow = "0px 4px 6px 0px rgba(0, 0, 0, 0.08)";
      break;
    default:
      position = "relative";
      break;
  }

  return css`
    position: ${position};
    background-color: ${backgroundColor};
    box-shadow: ${boxShadow};
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
        {pathname !== "/result" && <SelectOption pathname={pathname} />}
      </DefaultHeader>
      <OptionalHeader />
    </HeaderWrapper>
  );
};

const HeaderWrapper = styled.div`
  ${({ $pathname }) => getHeaderStyle($pathname)};
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
