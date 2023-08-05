import React, { useRef, useState } from "react";
import { styled } from "styled-components";

const BudgetSliderGroup = () => {
  const sliderRef = useRef();
  const [offset, setOffset] = useState(1);
  const [value, setValue] = useState(5700);

  const handleMouseUp = (e) => {
    document.removeEventListener("mousemove", handleMouseMove);
    document.removeEventListener("mouseup", handleMouseUp);
  };
  const handleMouseDown = (e) => {
    document.addEventListener("mousemove", handleMouseMove);
    document.addEventListener("mouseup", handleMouseUp);
  };
  const handleMouseMove = (e) => {
    const rect = sliderRef.current.getBoundingClientRect();
    const offsetX = e.clientX - rect.left;
    setOffset(offsetX);
  };
  return (
    <Wrapper>
      <Title>최대 예산을 알려주세요.</Title>
      <BudgetRange>
        <strong>4200</strong>만원 ~ <strong>{value}</strong>만원
      </BudgetRange>
      <Slider ref={sliderRef} onMouseDown={handleMouseDown}>
        <SliderBody offset={offset}></SliderBody>
        <SliderHandle></SliderHandle>
      </Slider>
      <SliderMark>
        <span>4200만원</span>
        <span>6900만원</span>
      </SliderMark>
    </Wrapper>
  );
};

const SliderMark = styled.div`
  display: flex;
  justify-content: space-between;

  color: ${({ theme }) => theme.color.grey400};
  ${({ theme }) => theme.font.Body4_Regular};

  margin-top: 14px;
`;
const SliderHandle = styled.div``;
const SliderBody = styled.div`
  width: ${({ offset }) => offset}px;
  height: 8px;
  background-color: ${({ theme }) => theme.color.secondary};
`;
const Slider = styled.div`
  width: 100%;
  height: 8px;

  background-color: ${({ theme }) => theme.color.grey700};

  border-radius: 16px;
  margin-top: 34px;

  overflow: hidden;
`;
const BudgetRange = styled.div`
  ${({ theme }) => theme.font.Extra7};
  strong {
    font-weight: 500;
  }

  margin-top: 38px;
`;
const Title = styled.div`
  ${({ theme }) => theme.font.Body2_Medium}
`;
const Wrapper = styled.div`
  display: flex;
  flex-direction: column;

  margin-top: 52px;
`;
export default BudgetSliderGroup;
