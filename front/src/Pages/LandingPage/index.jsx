import React from "react";
import { styled, css } from "styled-components";
import BackGroundVideo from "./BackGroundVideo";
import Button from "../../Components/Common/Button/Button";

const LandingPage = () => {
  return (
    <Wrapper>
      <Text>
        당신의 <strong>라이프스타일</strong>에 맞게
        <br />
        차량을 추천해드려요
      </Text>

      <BtnWrapper>
        <Button text="직접 만들래요" style={Direct} />
        <Button text="추천받기" style={Recommend} />
      </BtnWrapper>

      <BackGroundVideo />
    </Wrapper>
  );
};

const Wrapper = styled.div`
  position: relative;

  width: 100vw;
  height: 100vh;
  overflow: hidden;

  display: flex;
  justify-content: center;
  align-items: flex-end;
`;

const Text = styled.span`
  position: absolute;

  top: 143px;
  left: 128px;

  color: ${({ theme }) => theme.color.grey1000};
  ${({ theme }) => theme.font.Extra3};

  strong {
    font-family: "HyundaiSansHeadMediumKR";
  }
`;

const BtnWrapper = styled.div`
  display: flex;

  gap: 3%;
  margin-bottom: 2%;
`;

const Direct = css`
  width: 300px;
  height: 52px;

  background-color: transparent;
  color: ${({ theme }) => theme.color.grey1000};

  border-radius: 6px;
  border: 1px solid ${({ theme }) => theme.color.grey1000};

  ${({ theme }) => theme.font.Body3_Medium};
`;

const Recommend = css`
  width: 300px;
  height: 52px;

  background-color: ${({ theme }) => theme.color.grey9000};
  color: ${({ theme }) => theme.color.primary_default};

  border-radius: 6px;
  border: 1px solid ${({ theme }) => theme.color.grey1000};

  ${({ theme }) => theme.font.Body3_Medium};
`;

export default LandingPage;
