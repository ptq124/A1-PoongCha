import React from "react";
import { useLocation } from "react-router";
import { styled } from "styled-components";

const path = ["/survey/age", "/survey/lifestyle"];

const PageIndicator = () => {
  const { pathname } = useLocation();

  return (
    <PageIndicatorWrapper>
      {path.findIndex((path) => path === pathname) + 1}/{path.length}
    </PageIndicatorWrapper>
  );
};

export const PageIndicatorWrapper = styled.div`
  width: 64px;
  height: 36px;

  display: flex;
  align-items: center;
  justify-content: center;

  color: ${({ theme }) => theme.color.grey400};
  background-color: ${({ theme }) => theme.color.grey900};

  border-radius: 22px;

  ${({ theme }) => theme.font.Extra2}
`;

export default PageIndicator;
