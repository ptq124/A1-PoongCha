import React, { useEffect, useState } from "react";
import { styled } from "styled-components";
import LightBulbIcon from "../../../assets/icons/tooltip-lightbulb.svg";

const Tooltip = () => {
  const [isTooltipVisible, setIsTooltipVisible] = useState(false);

  useEffect(() => {
    const timeout = setTimeout(() => {
      setIsTooltipVisible(true);
    }, 200);

    return () => {
      clearTimeout(timeout);
    };
  }, []);

  return (
    <Wrapper isVisible={isTooltipVisible}>
      <Img src={LightBulbIcon} />
      <span>디젤은 연비가 좋고 가솔린은 승차감이 더 부드럽고 조용해요.</span>
    </Wrapper>
  );
};

const Img = styled.img`
  width: 32px;
  height: 32px;
`;
const Wrapper = styled.div`
  display: flex;
  align-items: center;
  gap: 10px;

  position: absolute;
  margin-top: -80px;

  width: 309px;
  height: 68px;

  background-color: ${({ theme }) => theme.color.tooltip};

  border-radius: 8px;

  padding: 18px 14px;

  box-sizing: border-box;

  z-index: 1;

  opacity: ${({ isVisible }) => (isVisible ? 1 : 0)};
  transition: opacity 0.3s ease;

  span {
    ${({ theme }) => theme.font.Body4_Regular};
    color: ${({ theme }) => theme.color.grey1000};
  }
`;

export default Tooltip;
