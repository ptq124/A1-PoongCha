import React from "react";
import { styled } from "styled-components";
import DefaultHeader from "./DefaultHeader";
import OptionalHeader from "./OptionalHeader";
import ProgressBar from "../ProgressBar";

const Header = () => {
  return (
    <HeaderWrapper>
      <DefaultHeader />
      {/* <OptionalHeader /> */}
      <ProgressBar progress={0.5} />
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
  padding-top: 33px;
`;

export default Header;
