import React, { useEffect, useState } from "react";
import { css, styled } from "styled-components";
import closeIcon from "@assets/icons/close.svg";
import Button from "@Components/Common/Button/Button";
import useButtonNavigation from "@hooks/useButtonNavigation";
import { getTrim } from "apis/custom";

const trim = ["", "Exclusive", " Le Blanc", "Prestige", "Caligraphy"];

const ColorChangePopup = ({ popupRef, closePopup, name }) => {
  const move = useButtonNavigation();
  const id = trim.indexOf(name);

  const [price, setPrice] = useState();

  getTrim(id).then((data) => {
    setPrice(data.minPrice);
  });

  return (
    <Wrapper ref={popupRef}>
      <Title>
        <span>
          {name} 트림으로
          <br />
          변경하시겠어요?
        </span>
        <img src={closeIcon} onClick={closePopup} />
      </Title>
      <Subtitle>인조가죽 (블랙) 색상은 트림 변경 후 선택할 수 있어요.</Subtitle>
      <TrimInfo>
        <span className="title">현재 트림</span>
        <div className="separator"></div>
        <TrimDetail>
          <span className="trimName">Le Blanc(르블랑)</span>
          <span className="trimPrice">40,440,000원</span>
        </TrimDetail>
      </TrimInfo>
      <TrimInfo>
        <span className="title">변경 트림</span>
        <div className="separator"></div>
        <TrimDetail>
          <span className="trimName">{name}</span>
          <span className="trimPrice">{price?.toLocaleString()}원</span>
        </TrimDetail>
      </TrimInfo>
      <Separator></Separator>
      <PriceInfo>
        <span className="title">변경 금액</span>
        <span className="price">+ 10,620,000원</span>
      </PriceInfo>
      <BtnContainer>
        <Button text="아니요" style={CancelBtnStyle} onClick={closePopup} />
        <Button
          text="변경하기"
          style={ChangeBtnStyle}
          onClick={() => {
            closePopup();
            move("/custom/trim");
          }}
        />
      </BtnContainer>
    </Wrapper>
  );
};

const BtnStyle = css`
  width: 120px;
  height: 46px;
  border-radius: 4px;
`;
const CancelBtnStyle = css`
  ${BtnStyle}
  background-color: ${({ theme }) => theme.color.grey1000};
  color: ${({ theme }) => theme.color.grey400};
  border: 1px solid ${({ theme }) => theme.color.grey600};
`;
const ChangeBtnStyle = css`
  ${BtnStyle}
  background-color:${({ theme }) => theme.color.primary_default};
  border: 1px solid ${({ theme }) => theme.color.primary_default};
  color: ${({ theme }) => theme.color.grey1000};
`;
const BtnContainer = styled.div`
  display: flex;
  justify-content: flex-end;
  margin-top: 60px;
  width: 100%;
  gap: 10px;
`;
const PriceInfo = styled.div`
  display: flex;
  justify-content: space-between;
  margin-top: 13px;
  .title {
    color: ${({ theme }) => theme.color.secondary};
    ${({ theme }) => theme.font.Body3_Medium};
  }
  .price {
    ${({ theme }) => theme.font.Head3};
  }
`;
const Separator = styled.div`
  width: 100%;
  height: 1px;
  background-color: ${({ theme }) => theme.color.grey500};
  margin-top: 68px;
`;
const TrimDetail = styled.div`
  display: flex;
  justify-content: space-between;
  margin-top: 12px;
  color: ${({ theme }) => theme.color.grey100};

  .trimName {
    ${({ theme }) => theme.font.Body3_Regular};
  }
  .trimPrice {
    ${({ theme }) => theme.font.Body3_Medium};
  }
`;
const TrimInfo = styled.div`
  display: flex;
  flex-direction: column;

  margin-top: 32px;
  .title {
    color: ${({ theme }) => theme.color.secondary};
    ${({ theme }) => theme.font.Body3_Medium};
  }
  .separator {
    width: 100%;
    height: 1px;
    background-color: ${({ theme }) => theme.color.grey700};
    margin-top: 7px;
  }
`;
const Subtitle = styled.div`
  color: ${({ theme }) => theme.color.grey400};
  ${({ theme }) => theme.font.Body4_Regular};
  margin-top: 8px;
  margin-bottom: 16px;
`;
const Title = styled.div`
  display: flex;
  justify-content: space-between;
  align-items: flex-start;
  ${({ theme }) => theme.font.Head1};
  img {
    position: absolute;
    top: 24px;
    right: 27px;
    &:hover {
      cursor: pointer;
    }
  }
`;
const Wrapper = styled.div`
  position: relative;
  width: 582px;
  height: 514px;
  background-color: ${({ theme }) => theme.color.grey1000};
  z-index: 999;
  border-radius: 12px;
  padding: 24px 33px;
`;
export default ColorChangePopup;
