import React from "react";
import { styled } from "styled-components";
import carImage from "@assets/image342.svg";
import HyundaiWhiteLogo from "@assets/icons/hyundai-logo.svg";
import download from "@assets/icons/download.svg";
import PopupProvider from "@Components/Common/PopupProvider";
import ShareUrlPopup from "../ShareUrlPopup";

const Card = ({ data }) => {
  return (
    <Wrapper>
      <Title>나만의 차가 완성되었어요!</Title>
      <SubTitle>만든 차는 저장하고 공유할 수 있어요.</SubTitle>
      <Container>
        <CarImg src={carImage} />
        <TriangleDecoration />
        <PopupProvider label={<ShareUrlPopup />}>
          <ShareBtn>
            <img src={download} />
          </ShareBtn>
        </PopupProvider>
      </Container>
      <Footer>
        <Top>
          펠리세이드
          <img src={HyundaiWhiteLogo} />
        </Top>
        <Trim>{data?.name}</Trim>
      </Footer>
    </Wrapper>
  );
};

const TriangleDecoration = styled.div`
  position: absolute;
  top: 0;
  width: 0;
  height: 0;
  border-bottom: 0px solid transparent;
  border-top: 50px solid #e6eaef;
  border-left: 50px solid transparent;
  border-right: 0px solid transparent;
  transform: rotate(-90deg);
  content: "";
`;

const ShareBtn = styled.div`
  position: absolute;
  top: 16px;
  right: 20px;

  display: flex;
  justify-content: center;
  align-items: center;

  width: 40px;
  height: 40px;

  border-radius: 50%;
  background-color: rgba(255, 255, 255, 0.5);

  cursor: pointer;

  img {
    width: 20px;
    height: 20px;
  }
`;

const Trim = styled.div`
  ${({ theme }) => theme.font.Head4};
  color: ${({ theme }) => theme.color.grey0};
  padding-top: 2px;
  padding-left: 16px;
`;

const Top = styled.div`
  display: flex;
  justify-content: space-between;
  align-items: center;

  width: 90%;

  ${({ theme }) => theme.font.Body4_Medium};
  color: ${({ theme }) => theme.color.grey300};
  padding-top: 12px;
  padding-left: 16px;
  padding-right: 16px;
  > img {
    width: 70px;
    height: 10px;
  }
`;

const Footer = styled.div`
  background: ${({ theme }) => theme.color.grey1000};
  width: 320px;
  height: 76px;
`;

const CarImg = styled.img`
  border-radius: 0px 8px 0px 0px;
`;

const Container = styled.div`
  height: 199px;
  position: relative;
  /* & > div:after {
    position: absolute;
    top: 0;
    width: 0;
    height: 0;
    border-bottom: 0px solid transparent;
    border-top: 50px solid #e6eaef;
    border-left: 50px solid transparent;
    border-right: 0px solid transparent;
    transform: rotate(-90deg);
    content: "";
  } */
`;
const SubTitle = styled.div`
  text-align: center;
  color: ${({ theme }) => theme.color.grey200};
  ${({ theme }) => theme.font.Body4_Regular};
  margin-top: 4px;
  margin-bottom: 33px;
`;

const Title = styled.div`
  text-align: center;
  color: ${({ theme }) => theme.color.grey0};
  ${({ theme }) => theme.font.Extra10}
`;

const Wrapper = styled.div`
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  background: #e6eaef;
  height: 506px;
`;

export default Card;
