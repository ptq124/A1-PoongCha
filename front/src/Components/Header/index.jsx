import React from "react";
import { styled } from "styled-components";
import DefaultHeader from "./DefaultHeader";
import OptionalHeader from "./OptionalHeader";

const Header = () => {
  return (
    <HeaderWrapper>
      <DefaultHeader />
      <OptionalHeader />
    </HeaderWrapper>
  );
};

const HeaderWrapper = styled.div`
  box-sizing: border-box;
  display: flex;
  flex-direction: column;
  width: 100%;
  min-height: 92px;
  overflow-y: auto;
  padding: 33px 128px 0px;
`;

export default Header;
