import React, { useRef, useState } from "react";
import { css, styled } from "styled-components";
import {
  INIT_SLIDER_IDX,
  MAX_SLIDER_OFFSET,
  MIN_SLIDER_OFFSET,
  SLIDER_HANDLE_SIZE,
  SLIDER_IDX_COUNT,
  SLIDER_UNIT_WIDTH,
} from "../../../utils/constants";

const BudgetSliderGroup = ({ maxBudget, setMaxBudget }) => {
  const sliderRef = useRef();
  let idx = INIT_SLIDER_IDX;
  const [offset, setOffset] = useState(idx * SLIDER_UNIT_WIDTH);

  const handleMouseUp = (e) => {
    document.removeEventListener("mousemove", handleMouseMove);
  };
  const handleMouseDown = (e) => {
    document.addEventListener("mousemove", handleMouseMove);
    document.addEventListener("mouseup", handleMouseUp);
  };
  const handleMouseMove = (e) => {
    const rect = sliderRef.current.getBoundingClientRect();
    const offsetX = e.clientX - rect.left;
    if (offsetX >= MIN_SLIDER_OFFSET && offsetX <= MAX_SLIDER_OFFSET) {
      const closestIndex = Math.round((offsetX / 608) * SLIDER_IDX_COUNT);
      if (closestIndex !== idx) {
        const calcOffset =
          closestIndex < SLIDER_IDX_COUNT
            ? closestIndex * SLIDER_UNIT_WIDTH
            : closestIndex * SLIDER_UNIT_WIDTH - SLIDER_HANDLE_SIZE;
        const calcBudget = 4200 + closestIndex * 300;
        idx = closestIndex;
        setOffset(calcOffset);
        setMaxBudget(calcBudget);
      }
    }
  };
  return (
    <Wrapper>
      <Title>최대 예산을 알려주세요.</Title>
      <BudgetRange>
        <strong>4200</strong>만원 ~ <strong>{maxBudget}</strong>만원
      </BudgetRange>
      <SliderContainer>
        <SliderHandle $isFixed={true}></SliderHandle>
        <Slider ref={sliderRef}>
          <SliderContent offset={offset}></SliderContent>
        </Slider>
        <SliderHandle
          $isFixed={false}
          offset={offset}
          onMouseDown={handleMouseDown}
        ></SliderHandle>
      </SliderContainer>

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
const SliderHandle = styled.div`
  position: absolute;
  left: ${({ offset }) => offset}px;

  width: 24px;
  height: 24px;

  background-color: ${({ theme }) => theme.color.grey1000};

  border: 1px solid ${({ theme }) => theme.color.grey500};
  border-radius: 100px;

  ${({ $isFixed }) =>
    !$isFixed &&
    css`
      &:hover {
        cursor: pointer;
      }
    `}
`;
const SliderContent = styled.div`
  width: ${({ offset }) => offset + 12}px;
  height: 8px;

  background-color: ${({ theme }) => theme.color.secondary};

  border-radius: 16px;
`;
const Slider = styled.div`
  width: 100%;
  height: 8px;

  background-color: ${({ theme }) => theme.color.grey700};

  border-radius: 16px;
`;
const SliderContainer = styled.div`
  display: flex;
  position: relative;

  align-items: center;
  width: 100%;
  height: 24px;

  margin-top: 26px;
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
