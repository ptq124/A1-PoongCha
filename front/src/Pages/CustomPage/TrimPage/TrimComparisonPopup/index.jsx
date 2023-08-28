import React from "react";
import { styled } from "styled-components";
import closeIcon from "@assets/icons/close.svg";
import ImgSample from "@assets/images/trim-comparison-popup-sample.png";

const TrimComparisonPopup = ({ popupRef, closePopup }) => {
  return (
    <Wrapper ref={popupRef}>
      <Header>
        <span>비교하기</span>
        <img src={closeIcon} onClick={closePopup} />
      </Header>
      <Content>
        <img src={ImgSample} />
      </Content>
    </Wrapper>
  );
};

const Content = styled.div`
  position: relative;
  img {
    width: 90%;
  }

  margin-top: 40px;
`;
const Header = styled.div`
  position: relative;
  width: 100%;
  span {
    ${({ theme }) => theme.font.Head1};
  }
  img {
    position: absolute;
    right: 0;
    &:hover {
      cursor: pointer;
    }
  }
`;
const Wrapper = styled.div`
  position: relative;
  text-align: center;

  width: 900px;
  height: 1335px;

  background-color: ${({ theme }) => theme.color.grey1000};

  border-radius: 12px;
  z-index: 12;

  padding: 24px;
  margin-top: 600px;
  margin-bottom: 100px;

  box-sizing: border-box;
  z-index: 999;
`;
export default TrimComparisonPopup;
