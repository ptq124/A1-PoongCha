import React from "react";
import { styled } from "styled-components";
import SelectedItem from "./SelectedItem/SelectedItem";
const Summary = () => {
  return (
    <Wrapper>
      <TrimContainer>
        <TrimTitle>
          <TrimName>
            <span className="palisade">팰리세이드</span>
            <span className="trimName">Le Blanc(르블랑)</span>
          </TrimName>
          <TrimPrice>43,460,000원</TrimPrice>
        </TrimTitle>
        <TrimSubtitle>가솔린 • 2WD • 8인승</TrimSubtitle>
      </TrimContainer>
      <Separator></Separator>
      <ColorOptionContainer>
        <Title>색상</Title>
        <ItemContainer>
          <SelectedItem />
          <SelectedItem />
        </ItemContainer>
      </ColorOptionContainer>
      <Separator></Separator>
      <ColorOptionContainer>
        <Title>옵션</Title>
        <ItemContainer>
          <SelectedItem />
          <SelectedItem />
        </ItemContainer>
      </ColorOptionContainer>
      <Separator></Separator>
      <EstimateContainer>
        <span className="estimate">총 금액</span>
        <span className="value">48,120,000원</span>
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
