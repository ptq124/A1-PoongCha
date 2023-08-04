import React from "react";
import { styled, css } from "styled-components";
import CoverVideo from "./CoverVideo";
import Button from "../../Components/Common/Button/Button";
import useButtonNavigation from "../../hooks/useButtonNavigation";

const LandingPage = () => {
  const handleButtonClick = useButtonNavigation();

  return (
    <Wrapper>
      <Text>
        당신의 <TextBold>라이프스타일</TextBold>에 맞게
        <br />
        차량을 추천해드려요
      </Text>

      <BtnWrapper>
        <Button
          text="직접 만들래요"
          style={Direct}
          onClick={() => handleButtonClick("/custom")}
        />
        <Button
          text="추천받기"
          style={Recommend}
          onClick={() => handleButtonClick("/survey")}
        />
      </BtnWrapper>
      <CoverVideo />
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
  font-family: "HyundaiSansTextRegularKR";
  font-size: 28px;
  font-style: normal;
  font-weight: 400;
  line-height: 150%;
  letter-spacing: -0.3px;
`;

const TextBold = styled.span`
  font-family: "HyundaiSansHeadBoldKR";
  font-size: 28px;
  font-style: normal;
  font-weight: 600;
  line-height: 150%;
  letter-spacing: -0.3px;
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
