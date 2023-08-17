import React from "react";
import { styled, css } from "styled-components";
import check32blue from "../../../assets/checkcircle/check-32-blue.svg";
import check32grey from "../../../assets/checkcircle/check-32-grey.svg";
import LifeImg from "../../../assets/lifestyle/lifestyle1.svg";

const LifestyleQuestion = (option, selected, handleSelected, openPopup) => {
  return (
    <Wrapper
      selected={option.index === selected}
      onClick={() => handleSelected(option.index)}
    >
      <TagWrapper>
        {option.tags.map((tag, index) => (
          <LifestyleTag selected={option.index === selected} key={index}>
            {tag}
          </LifestyleTag>
        ))}
      </TagWrapper>
      <LifestylePhrase selected={option.index === selected}>
        <span>{option.phrase}</span>
        <CheckImg src={option.index === selected ? check32blue : check32grey} />
      </LifestylePhrase>
      <LifestyleDetail onClick={openPopup} selected={option.index === selected}>
        라이프스타일 엿보기
      </LifestyleDetail>
      <LifestyleImg
        selected={option.index === selected}
        src={LifeImg}
        alt="Lifestyle"
      />
    </Wrapper>
  );
};

const Wrapper = styled.div`
  position: relative;

  display: flex;
  flex-direction: column;
  align-items: center;

  width: 296px;
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

  margin-top: 52px;
  padding: 20px;
  padding-bottom: 0px;

  box-sizing: border-box;

  cursor: pointer;
`;

const LifestyleTag = styled.span`
  display: flex;
  align-items: center;
  justify-content: center;

  height: 30px;

  background: ${({ selected }) =>
    selected
      ? `rgba(33, 151, 201, 0.1)`
      : css`
          ${({ theme }) => theme.color.grey1000}
        `};
  color: ${({ theme }) => theme.color.secondary};

  ${({ theme }) => theme.font.Caption1_Medium};

  padding: 6px 10px;
  border-radius: 100px;

  box-sizing: border-box;
`;

const TagWrapper = styled.div`
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

  margin: 10px 0px 20px;
`;

const CheckImg = styled.img`
  width: 32px;
  height: 32px;
`;

const LifestyleDetail = styled.div`
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

const LifestyleImg = styled.img`
  position: absolute;

  width: 88px;
  height: 88px;
  flex-shrink: 0;

  background: ${({ src }) => `url('${src}')`}, lightgray 50% / cover no-repeat;
  border-radius: 50%;
  ${({ selected }) =>
    selected &&
    css`
      border: 1.5px solid ${({ theme }) => theme.color.primary_default};
    `}

  object-fit: cover;
  top: -40px;
  right: 20px;

  box-sizing: border-box;
`;

export default LifestyleQuestion;
