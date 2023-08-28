import React from "react";
import { keyframes, styled } from "styled-components";
import car from "@assets/car.svg";
import point from "@assets/point.svg";
import logo from "@assets/icons/hyundaicardlogo.svg";

const data1 = ["", "가족", "편안함", "성능", "트렌디함"];
const data2 = [
  "",
  "우리 아이들과 함께 타는 차는 항상 안전해야 한다고 생각해요",
  "경제적이면서 사용하기 편한 차가 좋아요",
  "운전 경력이 짧아 쉬운 주행을 원해요",
  "성능과 디자인이 뛰어난 차를 원해요",
];

const Card = ({ id }) => {
  return (
    <Wrapper>
      <RecommendCard>
        <div className="border top"></div>
        <div className="border right"></div>
        <div className="border bottom"></div>
        <div className="border left"></div>
        <Content>
          <Logo src={logo} />
          <CardTop>
            <Name>펠리세이드 - Le Blanc(르블랑)</Name>
            <Phrase>
              <span>{data1 && data1[id]}</span>을 생각하는 당신을 위한
              펠리세이드
            </Phrase>
          </CardTop>
          <Description>
            {data2 && data2[id]}
            <Point src={point} />
          </Description>
          <CarImg src={car} />
        </Content>
      </RecommendCard>
    </Wrapper>
  );
};

const fadeIn = keyframes`
  from {
    opacity: 0;
  }
  to {
    opacity: 1;
  }
`;
const slideImg = keyframes`
  from {
    left:300px;
  }
  to {
    left:-22px;
  }
`;
const addShadow = keyframes`
  from {

  }
  to {
    box-shadow: 0px 4px 30px 0px rgba(97, 129, 177, 0.3);
  }
`;
const horizontalBorderFill = keyframes`
  from {
    width:0%
  }
  to {
    width:100%;
  }
`;
const verticalBorderFill = keyframes`
  from {
    height:0%;
  }
  to {
    height:100%;
  }
`;
const CardTop = styled.div`
  margin-top: 29px;
  text-align: center;
`;

const Description = styled.div`
  position: relative;

  display: flex;
  align-items: flex-start;
  justify-content: center;

  width: 257px;
  height: 55px;

  ${({ theme }) => theme.font.Extra16};
  color: ${({ theme }) => theme.color.grey400};
  background: ${({ theme }) => theme.color.grey1000};

  box-sizing: border-box;
  padding: 8px 12px;
  margin-bottom: 25px;

  border-radius: 8px;

  opacity: 0;
  animation: ${fadeIn} 0.5s forwards;
  animation-delay: 2.2s;
`;

const Phrase = styled.div`
  width: 217px;
  height: 56px;
  ${({ theme }) => theme.font.Extra15};

  opacity: 0;
  animation: ${fadeIn} 0.7s forwards;
  animation-delay: 1.7s;

  span {
    color: ${({ theme }) => theme.color.primary_default};
  }
`;

const Wrapper = styled.div`
  width: 100%;
  height: 485px;
  display: flex;
  background: linear-gradient(180deg, #a2b1d3 0%, #edf2fe 100%);
`;

const fillContentBackground = keyframes`
  from {
    background: linear-gradient(180deg, #a2b1d3 0%, #edf2fe 100%);

  }
  to {
    background: linear-gradient(180deg, #cbd3e8 0%, #eef2fc 100%);
  }
`;
const Content = styled.div`
  position: relative;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: space-between;

  width: 100%;
  height: 100%;
  border-radius: 8px;
  background: linear-gradient(180deg, #a2b1d3 0%, #edf2fe 100%);
  animation: ${fillContentBackground} 0.3s forwards;
  animation-delay: 1.6s;

  z-index: 2;
  overflow: hidden;
`;
const RecommendCard = styled.div`
  position: relative;

  width: 300px;
  height: 419px;
  flex-shrink: 0;
  text-align: center;

  border-radius: 12px;

  animation: ${addShadow} 0.5s forwards;
  animation-delay: 1.2s;
  backdrop-filter: blur(5px);

  margin: auto;
  padding: 4px;
  overflow: hidden;
  z-index: 1;

  .border {
    position: absolute;
    background-color: rgba(255, 255, 255);
    z-index: 1;
  }
  .top {
    top: 0;
    left: 7px;
    height: 10px;
    animation: ${horizontalBorderFill} 0.2s forwards;
    animation-delay: 0s;
  }
  .right {
    right: 0;
    top: 0;
    width: 10px;
    animation: ${verticalBorderFill} 0.2s forwards;
    animation-delay: 0.2s;
  }
  .bottom {
    bottom: 0;
    right: 0;
    height: 10px;
    animation: ${horizontalBorderFill} 0.2s forwards;
    animation-delay: 0.4s;
  }
  .left {
    bottom: 0;
    left: 0;
    width: 10px;
    animation: ${verticalBorderFill} 0.2s forwards;
    animation-delay: 0.6s;
  }
`;
const Name = styled.div`
  display: inline-flex;

  flex-direction: column;
  justify-content: center;
  align-items: center;

  background: ${({ theme }) => theme.color.primary_default};
  ${({ theme }) => theme.font.Extra9};
  color: #fff;

  padding: 6px 12px;
  border-radius: 30px;
  margin-bottom: 8px;

  opacity: 0;
  animation: ${fadeIn} 0.7s forwards;
  animation-delay: 1.7s;
`;

const Logo = styled.img`
  position: absolute;
  top: 17px;
  left: 19px;
`;

const CarImg = styled.img`
  position: absolute;

  width: 496px;
  height: 246px;

  top: 91px;
  left: 300px;
  animation: ${slideImg} 1s forwards;
  animation-delay: 1.2s;

  z-index: 10;
`;

const Point = styled.img`
  position: absolute;

  width: 8px;
  height: 6px;

  top: -6.2px;
`;

export default Card;
