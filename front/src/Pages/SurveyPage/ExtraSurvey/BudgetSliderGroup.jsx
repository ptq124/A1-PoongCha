import React, { useRef, useState } from "react";
import { css, styled } from "styled-components";

// 슬라이더 값 범위
// 0: 4200
// 1: 4500
// 2: 4800
// 3: 5100
// 4: 5400
// 5: 5700
// 6: 6000
// 7: 6300
// 8: 6600
// 9: 6900

const BudgetSliderGroup = () => {
  const sliderRef = useRef();
  const [offset, setOffset] = useState((5 * 608) / 9);
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
    if (offsetX >= 12 && offsetX <= 608) {
      // setOffset(offsetX);
      const closestIndex = Math.round((offsetX / 608) * 9);
      let calcOffset = (closestIndex * 608) / 9;
      if (closestIndex === 9) {
        calcOffset -= 24;
      }
      setOffset(calcOffset);
      setValue(4200 + closestIndex * 300);
      console.log(closestIndex);
    }
  };
  return (
    <Wrapper>
      <Title>최대 예산을 알려주세요.</Title>
      <BudgetRange>
        <strong>4200</strong>만원 ~ <strong>{value}</strong>만원
      </BudgetRange>
      <SliderContainer>
        <SliderHandle $isFixed={false}></SliderHandle>
        <Slider ref={sliderRef}>
          <SliderBody offset={offset}></SliderBody>
        </Slider>
        <SliderHandle
          $isFixed={true}
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
    $isFixed &&
    css`
      &:hover {
        cursor: pointer;
      }
    `}
`;
const SliderBody = styled.div`
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
