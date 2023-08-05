import React from "react";
import { styled } from "styled-components";
import ImgItem from "../ImgItem/ImgItem";

const SelectedItem = () => {
  return (
    <Wrapper>
      <ImgItem></ImgItem>
      <TextBox>
        <Body4Regular>외장 . 크리미 화이트 펄</Body4Regular>
        <Head4>0원</Head4>
      </TextBox>
    </Wrapper>
  );
};
const Wrapper = styled.div`
  display: inline-flex;
  justify-content: center;
  align-items: flex-start;
  gap: 16px;

  width: 201px;
  height: 60px;
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
