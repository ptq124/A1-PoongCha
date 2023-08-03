import React from "react";
import styled from "styled-components";
import HyundaiLogo from "../../assets/icons/hyundai-logo.svg";

const DefaultHeader = () => {
  return (
    <Wrapper>
      <img src={HyundaiLogo} alt="logo" />
      <span>펠리세이드</span>
    </Wrapper>
  );
};

const Wrapper = styled.div`
  padding: 0px 128px;
  display: flex;
  align-items: center;
  gap: 24px;
  span {
    ${({ theme }) => theme.font.Head4};
  }
`;
export default DefaultHeader;
