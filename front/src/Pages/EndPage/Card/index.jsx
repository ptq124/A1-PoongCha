import React from "react";
import { styled, css } from "styled-components";
import car from "../../../assets/car.svg";
import point from "../../../assets/point.svg";
import logo from "../../../assets/icons/hyundaicardlogo.svg";

const Card = () => {
  return (
    <Wrapper>
      <RecommendCard>
        <Logo src={logo} />
        <CardTop>
          <Name>펠리세이드 - Le Blanc(르블랑)</Name>
          <Phrase>
            <span>가족</span>을 생각하는 당신을 위한 펠리세이드
          </Phrase>
        </CardTop>
        <Description>
          우리 아이들과 함께 타는 차는 항상 안전해야 한다고 생각해요
          <Point src={point} />
        </Description>
        <CarImg src={car} />
      </RecommendCard>
    </Wrapper>
  );
};
const CardTop = styled.div`
  margin-top: 29px;
  text-align: center;
`;

const Description = styled.div`
  position: relative;

  display: flex;
  align-items: flex-start;

  width: 257px;
  height: 55px;

  ${({ theme }) => theme.font.Extra16};
  color: ${({ theme }) => theme.color.grey400};
  background: ${({ theme }) => theme.color.grey1000};

  box-sizing: border-box;
  padding: 8px 12px;
  margin-bottom: 25px;

  border-radius: 8px;
`;

const Phrase = styled.div`
  width: 217px;
  height: 56px;
  ${({ theme }) => theme.font.Extra15};

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

const RecommendCard = styled.div`
  position: relative;

  display: flex;
  justify-content: space-between;
  align-items: center;
  flex-direction: column;

  width: 300px;
  height: 419px;
  flex-shrink: 0;

  border-radius: 12px;
  border: 2px solid rgba(255, 255, 255, 0.5);

  background: rgba(255, 255, 255, 0.3);
  box-shadow: 0px 4px 30px 0px rgba(97, 129, 177, 0.2);
  backdrop-filter: blur(5px);

  margin: auto;
  overflow: hidden;
  z-index: 1;
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
  left: -22px;

  z-index: 10;
`;

const Point = styled.img`
  position: absolute;

  width: 8px;
  height: 6px;

  top: -6.2px;
`;

export default Card;
