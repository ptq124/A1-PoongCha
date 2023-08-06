import React from "react";
import { styled, css } from "styled-components";
import check32blue from "../../../assets/checkcircle/check-32-blue.svg";
import check32grey from "../../../assets/checkcircle/check-32-grey.svg";
import life from "../../../assets/lifestyle/lifestyle1.svg";
/**
데이터 전달 값: 라이프 스타일
태그: []
문구: 텍스트
프로필 사진: 이미지
*/
const LifestylePersona = ({ selected, setPopupOpen }) => {
  return (
    <Wrapper selected={selected}>
      <TagWrppaer>
        <LifeStlyeTag selected={selected}>#주행안전</LifeStlyeTag>
        <LifeStlyeTag selected={selected}>#사용편의</LifeStlyeTag>
      </TagWrppaer>
      <LifestylePhrase selected={selected}>
        <span>
          가족과 함께 타서
          <br />
          안전을 중시해요.
        </span>
        <CheckImg src={selected ? check32blue : check32grey} />
      </LifestylePhrase>
      <LifeStyleDetail onClick={() => setPopupOpen(true)}>
        라이프스타일 엿보기
      </LifeStyleDetail>
      <LifeStyleImg src={life} alt="Lifestyle" />
    </Wrapper>
  );
};

const Wrapper = styled.div`
  position: relative;

  display: flex;
  flex-direction: column;
  justify-content: space-between;
  align-items: center;

  width: 256px;
  height: 180px;

  background-color: ${({ selected }) =>
    selected
      ? css`
          ${({ theme }) => theme.color.grey1000}
        `
      : `var(--blue-blue-100, rgba(0, 66, 142, 0.10))`};

  border: 1.5px solid;
  border-color: ${({ selected }) =>
    selected
      ? css`
          ${({ theme }) => theme.color.primary_default}
        `
      : "transparent"};
  border-radius: 8px;

  margin-top: 10%;
  padding: 20px;
  padding-bottom: 0px;

  cursor: pointer;
`;

const LifeStlyeTag = styled.span`
  display: flex;
  align-items: center;

  background: ${({ selected }) =>
    selected
      ? `rgba(33, 151, 201, 0.1)`
      : css`
          ${({ theme }) => theme.color.grey1000}
        `};
  color: ${({ theme }) => theme.color.secondary};

  ${({ theme }) => theme.font.Caption1_Medium};
  text-align: center;
  padding: 6px 10px;
  border-radius: 100px;
`;

const TagWrppaer = styled.div`
  display: flex;

  width: 256px;
  height: 30px;

  gap: 8px;
`;

const LifestylePhrase = styled.div`
  display: flex;
  justify-content: space-between;
  align-items: center;

  width: 256px;

  span {
    ${({ theme }) => theme.font.Body2_Medium}

    color: ${({ selected }) =>
      selected
        ? css`
            ${({ theme }) => theme.color.primary_default}
          `
        : css`
            ${({ theme }) => theme.color.grey0}
          `};
  }
`;

const CheckImg = styled.img`
  width: 32px;
  height: 32px;
`;

const LifeStyleDetail = styled.div`
  width: 256px;
  height: 48px;

  display: flex;
  justify-content: center;
  align-items: center;

  border-top: 1px solid;
  border-top-color: ${({ selected }) =>
    selected
      ? css`
          ${({ theme }) => theme.color.grey700}
        `
      : css`
          ${({ theme }) => theme.color.grey900}
        `};

  color: ${({ theme }) => theme.color.grey200};
  ${({ theme }) => theme.font.Body4_Medium};
`;

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

export default LifestylePersona;
