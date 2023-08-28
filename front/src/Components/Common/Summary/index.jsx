import React from "react";
import { styled } from "styled-components";
import SelectedItem from "./SelectedItem/SelectedItem";
import { renderEstimatedPrice } from "context/UserDataContext";

const Summary = ({ data, estimated = 0 }) => {
  return (
    <Wrapper>
      <TrimContainer>
        <TrimTitle>
          <TrimName>
            <span className="palisade">팰리세이드</span>
            <span className="trimName">{data?.트림?.name}</span>
          </TrimName>
          <TrimPrice>{data.트림?.minPrice.toLocaleString()}원</TrimPrice>
        </TrimTitle>
        <TrimSubtitle>
          {data.엔진?.name} • {data.바디?.name} • {data.구동방식?.name}
        </TrimSubtitle>
      </TrimContainer>
      <Separator></Separator>
      <ColorOptionContainer>
        <Title>색상</Title>
        <ItemContainer>
          <SelectedItem data={data?.외장} option="외장" />
          <SelectedItem data={data?.내장} option="내장" />
        </ItemContainer>
      </ColorOptionContainer>
      <Separator></Separator>
      <ColorOptionContainer>
        <Title>옵션</Title>
        <ItemContainer>
          <SelectedItem data={data.옵션 && data.옵션[0]} option="옵션" />
          <SelectedItem data={data.옵션 && data.옵션[1]} option="옵션" />
        </ItemContainer>
      </ColorOptionContainer>
      <Separator></Separator>
      <EstimateContainer>
        <span className="estimate">총 금액</span>
        <span className="value">
          {renderEstimatedPrice(data)?.toLocaleString()}원
        </span>
      </EstimateContainer>
    </Wrapper>
  );
};

const Separator = styled.div`
  width: 100%;
  height: 1px;

  background-color: ${({ theme }) => theme.color.grey700};
`;

const EstimateContainer = styled.div`
  display: flex;
  justify-content: space-between;

  margin-top: 16px;

  .estimate {
    color: ${({ theme }) => theme.color.grey400};
    ${({ theme }) => theme.font.Extra13};
  }
  .value {
    ${({ theme }) => theme.font.Extra14};
  }
`;

const ItemContainer = styled.div`
  display: flex;
  gap: 16px;

  margin-top: 6px;
`;

const Title = styled.div`
  color: ${({ theme }) => theme.color.grey300};
  ${({ theme }) => theme.font.Caption1_Regular};
`;

const ColorOptionContainer = styled.div`
  margin: 26px 0px 40px;
`;

const TrimName = styled.div`
  display: flex;
  align-items: center;
  gap: 8px;
`;

const TrimPrice = styled.div`
  color: ${({ theme }) => theme.color.grey100};
  ${({ theme }) => theme.font.Head3};
`;

const TrimSubtitle = styled.div`
  color: ${({ theme }) => theme.color.grey400};
  ${({ theme }) => theme.font.Body4_Regular};

  margin-top: 5px;
`;

const TrimTitle = styled.div`
  display: flex;
  justify-content: space-between;
  align-items: center;

  .palisade {
    ${({ theme }) => theme.font.Head2};
  }
  .trimName {
    color: ${({ theme }) => theme.color.grey300};
    ${({ theme }) => theme.font.Extra12};
  }
`;

const TrimContainer = styled.div`
  margin-bottom: 16px;
`;

const Wrapper = styled.div`
  width: 608px;

  padding: 56px 0px 60px;
`;

export default Summary;
