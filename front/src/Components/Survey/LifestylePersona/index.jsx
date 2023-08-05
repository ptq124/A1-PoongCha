import React from "react";
import { styled } from "styled-components";
import check24blue from "../../../assets/checkcircle/check-32-blue.svg";
import check24grey from "../../../assets/checkcircle/check-24-grey.svg";
import life from "../../../assets/lifestyle/lifestyle1.svg";

const LifestylePersona = () => {
  return (
    <Wrapper>
      <TagWrppaer>
        <LifeStlyeTag>#주행안전</LifeStlyeTag>
        <LifeStlyeTag>#사용편의</LifeStlyeTag>
      </TagWrppaer>
      <MainWrapper>
        <span>
          가족과 함께 타서
          <br />
          안전을 중시해요.
        </span>
        <img src={check24blue} />
      </MainWrapper>
      <LifeStyleDetail>라이프스타일 엿보기</LifeStyleDetail>
      <LifeStyleImg src={life} alt="Lifestyle" />
    </Wrapper>
  );
};

const LifeStyleImg = styled.img`
  position: absolute;

  width: 97.948px;
  height: 88px;
  flex-shrink: 0;

  background: ${({ src }) => `url('${src}')`}, lightgray 50% / cover no-repeat;
  border-radius: 50%;

  object-fit: cover;
  top: -40px;
  right: 20px;
`;

const Wrapper = styled.div`
  position: relative;

  display: flex;
  flex-direction: column;
  justify-content: space-between;
  align-items: center;

  width: 256px;
  height: 180px;

  border: 1.5px solid;
  border-color: ${({ theme }) => theme.color.primary_default};
  border-radius: 8px;

  padding: 20px;
  padding-bottom: 0px;
`;

const LifeStlyeTag = styled.span`
  display: flex;
  align-items: center;

  background: rgba(33, 151, 201, 0.1);
  color: ${({ theme }) => theme.color.secondary};

  padding: 6px 10px;
  border-radius: 100px;
  ${({ theme }) => theme.font.Caption1_Medium};
  text-align: center;
`;

const TagWrppaer = styled.div`
  display: flex;

  width: 256px;
  height: 30px;

  gap: 8px;
`;

const MainWrapper = styled.div`
  display: flex;
  justify-content: space-between;
  align-items: center;

  width: 256px;

  span {
    ${({ theme }) => theme.font.Body2_Medium}
    color: ${({ theme }) => theme.color.primary_default};
  }
`;

const LifeStyleDetail = styled.div`
  width: 256px;
  height: 48px;

  display: flex;
  justify-content: center;
  align-items: center;

  border-top: 1px solid;
  border-top-color: ${({ theme }) => theme.color.grey700};

  color: ${({ theme }) => theme.color.grey200};
  ${({ theme }) => theme.font.Body4_Medium};
`;

export default LifestylePersona;
