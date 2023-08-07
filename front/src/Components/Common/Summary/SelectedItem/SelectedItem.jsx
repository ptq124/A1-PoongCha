import React from "react";
import { styled } from "styled-components";

const SelectedItem = () => {
  return (
    <Wrapper>
      <ItemDetail>
        <Img></Img>
        <TextBox>
          <Body4Regular>외장 - 크리미 화이트 펄</Body4Regular>
          <Head4>0원</Head4>
        </TextBox>
      </ItemDetail>
      {/* 데이터에 Recommend Reason Phrase 있는 경우에만 보여줌*/}
      <RecReasonPhrase>75%의 20대~30대 구매자들이 선택했어요.</RecReasonPhrase>
    </Wrapper>
  );
};

const ItemDetail = styled.div`
  display: flex;
  gap: 16px;

  width: 100%;
`;

const RecReasonPhrase = styled.div`
  width: 100%;

  color: ${({ theme }) => theme.color.secondary};
  background-color: rgba(33, 151, 201, 0.1);
  ${({ theme }) => theme.font.Body4_Regular}

  border-radius: 8px;

  padding: 12px;

  box-sizing: border-box;
`;

const Img = styled.img`
  width: 60px;
  height: 60px;

  background-color: ${({ theme }) => theme.color.grey600};
  border-radius: 4px;
`;

const Wrapper = styled.div`
  display: inline-flex;
  flex-direction: column;
  align-items: flex-start;
  gap: 16px;

  width: 296px;
`;

const TextBox = styled.div`
  display: flex;
  flex-direction: column;
  align-items: flex-start;
  gap: 4px;

  width: 125px;
  height: 48px;
`;

const Body4Regular = styled.div`
  ${({ theme }) => theme.font.Body4_Regular};
  color: ${({ theme }) => theme.color.grey200};
`;

const Head4 = styled.div`
  ${({ theme }) => theme.font.Head4};
`;

export default SelectedItem;
