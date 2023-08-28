import React from "react";
import { css, styled } from "styled-components";
import closeIcon from "@assets/icons/close.svg";
import Button from "@Components/Common/Button/Button";

const ShareUrlPopup = ({ popupRef, closePopup }) => {
  return (
    <Wrapper ref={popupRef}>
      <Title>
        <span>공유하기</span>
        <img src={closeIcon} onClick={closePopup} />
      </Title>
      <Subtitle>
        구성하신 견적이 URL로 생성되었어요.
        <br />
        아래 URL을 공유하시면 견적을 다시 확인하실 수 있어요.
        <br />
        (30일 유효)
      </Subtitle>
      <URLContainer>{window.location.href}</URLContainer>
      <Button
        text="복사하기"
        style={copyButtonStyle}
        onClick={() => navigator.clipboard.writeText(window.location.href)}
      />
    </Wrapper>
  );
};

const copyButtonStyle = css`
  width: 363px;
  height: 46px;
  background-color: ${({ theme }) => theme.color.primary_default};
  border: 1px solid ${({ theme }) => theme.color.primary_default};
  border-radius: 4px;
  ${({ theme }) => theme.font.Body3_Medium};
  color: white;
  margin-top: 32px;
  cursor: pointer;
`;
const URLContainer = styled.div`
  display: flex;
  justify-content: flex-start;
  align-items: center;
  width: 363px;
  height: 40px;
  border: 1px solid ${({ theme }) => theme.color.primary_default};
  border-radius: 8px;
  ${({ theme }) => theme.font.Body4_Regular};
  color: ${({ theme }) => theme.color.grey600};
  padding: 9px 12px;
  box-sizing: border-box;
  white-space: nowrap;
  overflow: hidden;
  margin-top: 36px;
`;
const Subtitle = styled.div`
  ${({ theme }) => theme.font.Body4_Regular};
  color: ${({ theme }) => theme.color.grey400};
  margin-top: 8px;
`;
const Title = styled.div`
  ${({ theme }) => theme.font.Head1};
  display: flex;
  justify-content: space-between;
  &:hover {
    cursor: pointer;
  }
`;
const Wrapper = styled.div`
  width: 427px;
  height: 312px;
  background-color: white;
  z-index: 999;
  border-radius: 12px;
  padding: 24px 32px;
  box-sizing: border-box;
`;
export default ShareUrlPopup;
