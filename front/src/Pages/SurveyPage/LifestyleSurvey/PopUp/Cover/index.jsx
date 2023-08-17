import React from "react";
import { styled } from "styled-components";
import cover from "@assets/lifestyle/lifestylecover.svg";
import logo from "@assets/icons/hyundai-logo-white.svg";

const Cover = () => {
  return (
    <Wrapper>
      <Logo src={logo} />
      <MainContent>
        <TagContent>
          <Tag>#수행안전</Tag>
          <Tag>#사용편의</Tag>
        </TagContent>
        <Phrase>가족과 함께 타서 안전을 중시해요.</Phrase>
        <Item>김현대씨의 라이프스타일 엿보기</Item>
      </MainContent>
    </Wrapper>
  );
};

const Wrapper = styled.div`
  position: relative;
  display: flex;
  align-items: end;

  width: 688px;
  height: 256px;
  flex-shrink: 0;

  background: linear-gradient(
      180deg,
      rgba(15, 17, 20, 0) 0%,
      rgba(15, 17, 20, 0.7) 100%
    ),
    url(${cover}), lightgray -2px -302.825px / 104.506% 280.243% no-repeat;
`;

const Logo = styled.img`
  position: absolute;
  top: 36px;
  left: 40px;

  width: 129px;
  height: 14px;
`;

const MainContent = styled.div`
  width: 416px;
  height: 143px;
  color: white;

  margin-left: 40px;
`;

const TagContent = styled.div`
  display: flex;
  gap: 8px;

  margin-bottom: 8px;
`;

const Tag = styled.div`
  display: flex;
  align-items: center;
  justify-content: center;

  width: 69px;
  height: 30px;

  border-radius: 100px;
  background: rgba(15, 17, 20, 0.8);
  backdrop-filter: blur(4px);

  color: ${({ theme }) => theme.color.grey1000};
  ${({ theme }) => theme.font.Caption1_Medium};
`;

const Phrase = styled.div`
  ${({ theme }) => theme.font.Extra11};
  margin-bottom: 8px;
`;

const Item = styled.div`
  color: rgba(255, 255, 255, 0.7);
  ${({ theme }) => theme.font.Body3_Regular};
`;

export default Cover;
