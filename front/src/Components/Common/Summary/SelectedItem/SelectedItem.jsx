import React from "react";
import { styled } from "styled-components";
import { useLocation } from "react-router-dom";

const SelectedItem = ({ data, option }) => {
  const { pathname } = useLocation();
  let imageUrl;
  if (option === "내장" || option === "외장") {
    imageUrl = data?.imageUrl;
  } else {
    imageUrl = data?.options && data?.options[0].imageUrl;
  }
  if (!data) return null;
  function getRandomNumber(min, max) {
    return Math.floor(Math.random() * (max - min + 1)) + min;
  }

  // 0부터 3까지의 랜덤 변수 얻기
  var randomNumber = getRandomNumber(0, 6);
  const reco = [
    "75%의 20대~30대 구매자들이 선택했어요.",
    "35%의 50대~60대 구매자들이 선택했어요.",
    "25%의 70대~80대 구매자들이 선택했어요.",
    "15%의 30대~40대 구매자들이 선택했어요.",
    "75%의 20대~30대 구매자들이 선택했어요.",
    "85%의 40대~50대 구매자들이 선택했어요.",
    "35%의 30대~40대 구매자들이 선택했어요.",
  ];

  return (
    <Wrapper>
      <ItemDetail>
        <Img src={imageUrl}></Img>
        <TextBox>
          <Body4Regular>
            {option !== "옵션" && `${option} -`} {data?.name}
          </Body4Regular>
          <Head4>
            {data.additionalPrice ? data.additionalPrice.toLocaleString() : 0}원
          </Head4>
        </TextBox>
      </ItemDetail>
      {/* 데이터에 Recommend Reason Phrase 있는 경우에만 보여줌*/}
      {pathname !== "/result" && (
        <RecReasonPhrase>{reco[randomNumber]}</RecReasonPhrase>
      )}
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

  object-fit: cover;
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

  width: 125px;
  overflow: hidden;
  text-overflow: ellipsis;
  white-space: nowrap;
`;

const Head4 = styled.div`
  ${({ theme }) => theme.font.Head4};
`;

export default SelectedItem;
