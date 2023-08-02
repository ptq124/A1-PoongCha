import React from "react";
import styled from "styled-components";

const DefaultHeader = () => {
  return (
    <DefaultHeaderWrapper>
      <img alt="현대" src="" />
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
