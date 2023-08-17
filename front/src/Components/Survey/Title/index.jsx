import React from "react";
import { useLocation } from "react-router-dom";
import { styled, css } from "styled-components";
import PageIndicator from "../PageIndicator";

const path = ["/survey/age", "/survey/lifestyle"];

const Title = ({ questionnaire }) => {
  const { pathname } = useLocation();

  const isPageIndicator = () => {
    if (path.includes(pathname)) {
      return (
        <PageIndicator
          crntPage={path.findIndex((path) => path === pathname) + 1}
          totalPage={path.length}
        />
      );
    }
  };

  return (
    <Wrapper>
      <Header $pathname={pathname}>{questionnaire}</Header>
      {isPageIndicator()}
    </Wrapper>
  );
};

const Wrapper = styled.div`
  display: flex;
  justify-content: space-between;
  width: 100%;
  align-items: start;
`;

const Header = styled.div`
  width: 100%;

  ${({ $pathname }) =>
    $pathname === "/survey/extra"
      ? css`
          ${({ theme }) => theme.font.Body2_Medium};
        `
      : css`
          ${({ theme }) => theme.font.Extra1};
        `}

  color: ${({ theme }) => theme.color.grey100};
  strong {
    font-family: "HyundaiSansHeadMediumKR";
  }
`;

export default Title;
