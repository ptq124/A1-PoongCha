import React from "react";
import { css, styled } from "styled-components";
import closeIcon from "@assets/icons/close.svg";
import Button from "@Components/Common/Button/Button";
import { useUserData } from "context/UserDataContext";

const TrimChangePopup = ({ popupRef, closePopup, changeTrim }) => {
  const { totalData } = useUserData();

  return (
    <Wrapper ref={popupRef}>
      <Header>
        <span>트림 변경 시, 선택하신 색상과 옵션이 해제돼요</span>
        <img src={closeIcon} onClick={closePopup} />
      </Header>
      <Content>
        <CanceledItemDetail>
          <span className="title">해제 색상</span>
          <div className="separator"></div>
          <Items>
            <Item>
              <div className="img">
                <img src={totalData.내장.imageUrl} />
              </div>
              <span className="name">내장 - {totalData.내장.name}</span>
            </Item>
            <Item>
              <div className="img">
                <img src={totalData.외장.imageUrl} />
              </div>
              <span className="name">외장 - {totalData.외장.name}</span>
            </Item>
          </Items>
        </CanceledItemDetail>
        <CanceledItemDetail>
          <span className="title">해제 옵션</span>
          <div className="separator"></div>
          <Items>
            <Item>
              <div className="img">
                <img src={totalData.옵션[0].options[0].imageUrl} />
              </div>
              <span className="name">{totalData.옵션[0].name}</span>
            </Item>
            <Item>
              <div className="img">
                <img src={totalData.옵션[1].options[0].imageUrl} />
              </div>
              <span className="name">{totalData.옵션[1].name}</span>
            </Item>
          </Items>
        </CanceledItemDetail>
      </Content>
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
const Item = styled.div`
  display: flex;
  align-items: flex-start;
  gap: 12px;
  width: 50%;

  .img {
    width: 60px;
    height: 60px;
    background-color: grey;
    border-radius: 3.25px;
    overflow: hidden;
    display: flex;
    justify-content: center;
  }
  .name {
    ${({ theme }) => theme.font.Body3_Regular}
    color:${({ theme }) => theme.color.grey100};
  }
`;
const Items = styled.div`
  display: flex;
`;
const CanceledItemDetail = styled.div`
  .title {
    ${({ theme }) => theme.font.Body3_Medium}
    color:${({ theme }) => theme.color.primary_default}
  }
  .separator {
    height: 1px;
    width: 100%;
    background-color: ${({ theme }) => theme.color.grey700};
    margin: 7px 0px 12px;
  }
`;

const BtnContainer = styled.div`
  display: flex;
  justify-content: flex-end;
  gap: 10px;

  width: 100%;

  margin-top: 48px;
`;
const Content = styled.div`
  display: flex;
  flex-direction: column;
  gap: 26px;
`;
const Header = styled.div`
  display: flex;
  justify-content: space-between;
  align-items: flex-start;

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
