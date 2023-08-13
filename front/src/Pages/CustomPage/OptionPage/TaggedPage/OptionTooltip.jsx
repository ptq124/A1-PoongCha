import React, { useEffect } from "react";
import { styled } from "styled-components";
import TooltipTail from "../../../../assets/icons/option-tooltip-tail.svg";
import ArrowRightIcon from "../../../../assets/icons/arrow-right.svg";

const OptionTooltip = ({ data, openPopup }) => {
  return (
    <Wrapper $position={data.position}>
      <Content>
        <Img></Img>
        <Detail>
          <div className="tag">주행안전</div>
          <div className="option">현대 스마트 센스 1</div>
          <div className="price">790,000 원</div>
        </Detail>
      </Content>
      <Arrow src={ArrowRightIcon} className="arrow" onClick={openPopup} />
      <img src={TooltipTail} className="tail" />
    </Wrapper>
  );
};
const Arrow = styled.img`
  width: 24px;
  height: 24px;
  &:hover {
    cursor: pointer;
  }
`;
const Detail = styled.div`
  .tag {
    color: ${({ theme }) => theme.color.grey400};
    ${({ theme }) => theme.font.Caption1_Regular};
  }
  .option {
    color: ${({ theme }) => theme.color.grey50};
    ${({ theme }) => theme.font.Body3_Medium};
  }
  .price {
    color: ${({ theme }) => theme.color.grey100};
    ${({ theme }) => theme.font.Head4};
    margin-top: 8px;
  }
`;
const Img = styled.div`
  width: 72px;
  height: 72px;
  background-color: beige;
`;
const Content = styled.div`
  display: flex;
  gap: 8px;
`;
const Wrapper = styled.div`
  position: absolute;
  top: calc(${({ $position }) => $position.y}% - 110px);
  left: calc(${({ $position }) => $position.x}% - 124px);
  display: flex;
  justify-content: space-between;
  align-items: center;

  width: 270px;
  height: 96px;
  border-radius: 8px;
  background-color: ${({ theme }) => theme.color.grey1000};
  padding: 12px;
  box-sizing: border-box;
  .tail {
    position: absolute;
    bottom: -9px;
    left: 130px;
    width: 14px;
    height: 10px;
  }
`;
export default OptionTooltip;
