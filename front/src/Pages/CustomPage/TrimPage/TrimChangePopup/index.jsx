import React from "react";
import { css, styled } from "styled-components";
import closeIcon from "../../../../assets/icons/close.svg";
import Button from "../../../../Components/Common/Button/Button";

const TrimChangePopup = ({ popupRef, closePopup, changeTrim }) => {
  return (
    <Wrapper ref={popupRef}>
      <Header>
        <span>트림 변경 시, 선택하신 색상과 옵션이 해제돼요</span>
        <img src={closeIcon} onClick={closePopup} />
      </Header>
      <Content></Content>
      <BtnContainer>
        <Button text="취소하기" style={CancelBtnStyle} onClick={closePopup} />
        <Button
          text="변경하기"
          style={ChangeBtnStyle}
          onClick={() => {
            changeTrim();
            closePopup();
          }}
        />
      </BtnContainer>
    </Wrapper>
  );
};

const BtnStyle = css`
  width: 120px;
  height: 46px;
  ${({ theme }) => theme.font.Body3_Medium};
  border-radius: 4px;
`;
const CancelBtnStyle = css`
  ${BtnStyle}
  background-color: ${({ theme }) => theme.color.grey1000};
  border: 1px solid ${({ theme }) => theme.color.grey600};
`;
const ChangeBtnStyle = css`
  ${BtnStyle}
  background-color: ${({ theme }) => theme.color.primary_default};
  border: 1px solid ${({ theme }) => theme.color.primary_default};
  color: ${({ theme }) => theme.color.grey1000};
`;
const BtnContainer = styled.div`
  display: flex;
  justify-content: flex-end;
  gap: 10px;

  width: 100%;

  margin-top: 48px;
  /* margin-right: 24px; */
`;
const Content = styled.div``;
const Header = styled.div`
  display: flex;
  justify-content: space-between;
  align-items: flex-start;

  /* padding: 24px 27px 0 33px; */

  span {
    ${({ theme }) => theme.font.Head2};
  }
  img:hover {
    cursor: pointer;
  }
`;
const Wrapper = styled.div`
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  width: 582px;
  height: 446px;

  background-color: ${({ theme }) => theme.color.grey1000};

  border-radius: 12px;
  z-index: 999;

  padding: 24px 33px;
`;

export default TrimChangePopup;
