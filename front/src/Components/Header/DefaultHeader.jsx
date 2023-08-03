import React from "react";
import styled from "styled-components";
import HyundaiLogo from "../../assets/icons/hyundai-logo.svg";

const DefaultHeader = () => {
  return (
    <DefaultHeaderWrapper>
      <img src={HyundaiLogo} alt="logo" />
      <span>펠리세이드</span>
    </DefaultHeaderWrapper>
  );
};

const DefaultHeaderWrapper = styled.div`
  display: flex;
  gap: 24px;
  span {
    ${({ theme }) => theme.font.Head4};
  }
`;
export default DefaultHeader;
