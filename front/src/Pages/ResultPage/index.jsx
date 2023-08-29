import React, { useEffect, useState } from "react";
import { styled, css } from "styled-components";
import Card from "./Card";
import Summary from "@Components/Common/Summary";
import Button from "@Components/Common/Button/Button";
import Accordion from "@Components/Result/Accordian";
import { renderEstimatedPrice } from "context/UserDataContext";
import { useParams } from "react-router-dom";
import { getEstimate } from "apis/custom";

const initialAccordions = [
  { title: "탁송", content: "이곳에 내용이 들어갑니다.", isOpen: false },
  {
    title: "할인/포인트",
    content: "다른 내용도 들어갈 수 있습니다.",
    isOpen: false,
  },
  {
    title: "결제방법",
    content: "더 많은 내용도 들어갈 수 있습니다.",
    isOpen: false,
  },
  {
    title: "면제 구분 및 등록비",
    content: "마지막 내용입니다.",
    isOpen: false,
  },
];

const ResultPage = () => {
  const { resultId } = useParams();
  const [resultData, setResultData] = useState({});

  useEffect(() => {
    getEstimate(resultId).then((data) => {
      setResultData({
        트림: data.trim,
        엔진: data.components[0],
        바디: data.components[1],
        구동방식: data.components[2],
        외장: data.exteriorColor,
        내장: data.interiorColor,
        옵션: data.optionGroups,
      });
    });
  }, []);

  const [accordions, setAccordions] = useState(initialAccordions);

  const toggleAccordion = (index) => {
    const updatedAccordions = [...accordions];
    updatedAccordions[index].isOpen = !updatedAccordions[index].isOpen;
    setAccordions(updatedAccordions);
  };

  return (
    <Wrapper>
      <Card data={resultData.트림} />
      <MainContainer>
        <Summary data={resultData} />
        <BtnContainer>
          <Button style={BtnStyle} text="내 계정에 저장" />
          <Button style={BtnStyle} text="PDF로 저장" />
          <Button style={BtnStyle} text="메일로 발송" />
        </BtnContainer>
        <Separator></Separator>
        <PurchaseContainer>
          <Title>차량 구매</Title>
          <AccordionBox>
            {accordions.map((accordion, index) => (
              <Accordion
                key={index}
                title={accordion.title}
                content={accordion.content}
                isOpen={accordion.isOpen}
                toggleAccordion={() => toggleAccordion(index)}
              />
            ))}
          </AccordionBox>
        </PurchaseContainer>
        <AmountBox>
          <div>차량 견적 총 금액</div>
          <div>{renderEstimatedPrice(resultData).toLocaleString()}원</div>
        </AmountBox>
        <Footer>
          <Button style={Btn1} text="수정" />
          <Button style={Btn2} text="구매/상담" />
        </Footer>
      </MainContainer>
    </Wrapper>
  );
};
const AmountBox = styled.div`
  display: flex;
  justify-content: space-between;

  width: 608px;

  margin-top: 32px;
  margin-bottom: 68px;

  div:nth-child(1) {
    ${({ theme }) => theme.font.Extra13};
    color: ${({ theme }) => theme.color.grey100};
  }
  div:nth-child(2) {
    ${({ theme }) => theme.font.Extra14};
    color: ${({ theme }) => theme.color.secondary};
  }
`;

const Footer = styled.div`
  display: flex;
  justify-content: center;
  width: 100%;
  gap: 16px;
`;

const Btn2 = css`
  width: 296px;
  height: 52px;
  flex-shrink: 0;

  color: ${({ theme }) => theme.color.grey1000};
  background-color: ${({ theme }) => theme.color.primary_default};

  border-radius: 6px;
  border: 1px solid ${({ theme }) => theme.color.primary_default};
  ${({ theme }) => theme.font.Body3_Medium};

  margin-bottom: 36px;
`;

const Btn1 = css`
  width: 296px;
  height: 52px;
  flex-shrink: 0;

  background-color: ${({ theme }) => theme.color.grey1000};
  color: ${({ theme }) => theme.color.primary_default};

  border-radius: 6px;
  border: 1px solid ${({ theme }) => theme.color.grey600};

  ${({ theme }) => theme.font.Body3_Medium};
`;

const AccordionBox = styled.div`
  display: flex;
  flex-direction: column;
  justify-content: flex-start;
  margin-top: 5px;
  width: 608px;
`;

const Title = styled.div`
  ${({ theme }) => theme.font.Head3};
`;

const PurchaseContainer = styled.div`
  margin-top: 32px;
  display: flex;
  flex-direction: column;
  width: 608px;
`;

const BtnStyle = css`
  width: 168px;
  height: 52px;

  background-color: white;
  color: ${({ theme }) => theme.color.grey200};
  ${({ theme }) => theme.font.Body3_Medium};
  border-radius: 6px;
  border: 1px solid var(--grey-scale-grey-600, #d1d7df);
`;

const Separator = styled.div`
  display: flex;
  width: 608px;
  height: 1px;

  background-color: ${({ theme }) => theme.color.grey700};
`;

const BtnContainer = styled.div`
  display: flex;
  width: 608px;
  gap: 8px;

  margin-bottom: 32px;
`;

const MainContainer = styled.div`
  display: flex;
  flex-direction: column;
  justify-content: flex-start;
  align-items: center;

  height: 1071px;
  width: 100%;
`;

const Wrapper = styled.div`
  position: relative;
  height: 1577px;
`;

export default ResultPage;
