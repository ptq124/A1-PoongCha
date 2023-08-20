import Button from "@Components/Common/Button/Button";
import useButtonNavigation from "@hooks/useButtonNavigation";
import React from "react";
import { css, styled } from "styled-components";
import closeIcon from "@assets/icons/close.svg";

const BackToSurveyPopup = ({ popupRef, closePopup }) => {
  const move = useButtonNavigation();
  return (
    <Wrapper ref={popupRef}>
      <Container>
        <Title>추천페이지로 돌아가시겠어요?</Title>
        <SubTitle>선택한 옵션들은 모두 초기화돼요.</SubTitle>
      </Container>
      <BtnContainer>
        <Button text="아니요" style={LeftBtnStyle} onClick={closePopup} />
        <Button
          text="추천받기"
          style={RightBtnStyle}
          onClick={() => {
            closePopup();
            move("/");
          }}
        />
      </BtnContainer>
      <img src={closeIcon} onClick={closePopup} />
    </Wrapper>
  );
};
const LeftBtnStyle = css`
  width: 178px;
  height: 46px;
  background-color: ${({ theme }) => theme.color.grey1000};
  border: 1px solid;
  border-color: ${({ theme }) => theme.color.grey600};
  border-radius: 4px;
  color: ${({ theme }) => theme.color.grey50};
  ${({ theme }) => theme.font.Body3_Medium};
`;

const RightBtnStyle = css`
  width: 178px;
  height: 46px;
  background-color: ${({ theme }) => theme.color.primary_default};
  border: 1px solid;
  border-color: ${({ theme }) => theme.color.primary_default};
  border-radius: 4px;
  color: ${({ theme }) => theme.color.grey1000};
  ${({ theme }) => theme.font.Body3_Medium};
`;

const BtnContainer = styled.div`
  display: flex;
  margin-top: 32px;
  margin-left: 32px;
  gap: 10px;
`;

const Container = styled.div`
  display: flex;
  flex-direction: column;
  margin-top: 24px;
  margin-left: 32px;
`;
const Title = styled.div`
  ${({ theme }) => theme.font.Head1};
`;
const SubTitle = styled.div`
  color: ${({ theme }) => theme.color.grey400};
  ${({ theme }) => theme.font.Body4_Regular};
  margin-top: 8px;
`;
const Wrapper = styled.div`
  position: relative;

  width: 427px;
  height: 192px;

  border-radius: 12px;

  z-index: 999;
  background-color: ${({ theme }) => theme.color.grey1000};

  img {
    position: absolute;
    top: 24px;
    right: 24px;
  }
`;
export default BackToSurveyPopup;
