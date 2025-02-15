import React, { useState } from "react";
import { css, styled } from "styled-components";
import closeIcon from "@assets/icons/close.svg";

const navOptions = ["엔진", "바디타입", "구동방식"];
const ModelItemsDescriptionPopup = ({ popupRef, closePopup, data }) => {
  const [selectedNav, setSelectedNav] = useState(0);
  return (
    <Wrapper ref={popupRef}>
      <Header>
        <NavBar>
          {navOptions.map((option, index) => (
            <Nav
              key={index}
              onClick={() => setSelectedNav(index)}
              selected={selectedNav === index}
            >
              {option}
            </Nav>
          ))}
        </NavBar>
        <img src={closeIcon} onClick={closePopup} />
      </Header>
      <NavStateBar>
        <Filler $state={selectedNav}></Filler>
      </NavStateBar>
      <ContentWindow>
        <Content $state={selectedNav}>
          {data.map((item, index) => (
            <CarouselContent key={index}>
              <img src={item && item.component[0].descriptionImageUrl} />
              <img src={item && item.component[1].descriptionImageUrl} />
            </CarouselContent>
          ))}
        </Content>
      </ContentWindow>
    </Wrapper>
  );
};

const Content = styled.div`
  display: flex;
  gap: 40px;
  ${({ $state }) => css`
    margin-left: -${$state * 760}px;
  `}

  transition: margin-left 0.5s ease;
`;
const CarouselContent = styled.div`
  width: 100%;
  display: flex;
  flex-direction: column;
  gap: 21px;

  img {
    width: 720px;
  }
`;
const ContentWindow = styled.div`
  display: flex;
  margin: 20px 25px;
  overflow: hidden;
`;
const Filler = styled.div`
  width: 62px;
  height: 2px;
  background-color: ${({ theme }) => theme.color.primary_default};

  ${({ $state }) => {
    switch ($state) {
      case 0:
        return css`
          margin-left: 40px;
        `;
      case 1:
        return css`
          margin-left: 125px;
        `;
      case 2:
        return css`
          margin-left: 225px;
        `;
    }
  }}
  transition: margin-left 0.3s ease;
`;
const NavStateBar = styled.div`
  width: 100%;
  height: 2px;
  background-color: ${({ theme }) => theme.color.grey700};
`;
const Nav = styled.div`
  ${({ selected }) =>
    selected
      ? css`
          color: ${({ theme }) => theme.color.primary_default};
          ${({ theme }) => theme.font.Body2_Bold};
        `
      : css`
          color: ${({ theme }) => theme.color.grey500};
          ${({ theme }) => theme.font.Body2_Medium};
        `}

  &:hover {
    cursor: pointer;
  }
`;
const NavBar = styled.div`
  display: flex;
  gap: 40px;

  margin-top: 37px;
  margin-left: 55px;
`;
const Header = styled.div`
  display: flex;
  justify-content: space-between;
  width: 100%;
  height: 70px;

  img {
    position: absolute;
    top: 24px;
    right: 24px;
    width: 24px;
    height: 24px;
    &:hover {
      cursor: pointer;
    }
  }
`;
const Wrapper = styled.div`
  position: relative;
  width: 800px;
  height: 535px;
  background-color: ${({ theme }) => theme.color.grey1000};
  border-radius: 12px;
  z-index: 999;
`;
export default ModelItemsDescriptionPopup;
