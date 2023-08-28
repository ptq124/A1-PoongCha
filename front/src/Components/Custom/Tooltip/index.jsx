import React, { useEffect, useState } from "react";
import { styled } from "styled-components";
import LightBulbIcon from "@assets/icons/tooltip-lightbulb.svg";
import TooltipTail from "@assets/icons/tooltip-tail.svg";

const Tooltip = ({ content }) => {
  return (
    <Wrapper>
      <TooltipBody>
        <Img src={LightBulbIcon} />
        <span>{content}</span>
      </TooltipBody>
      <TooltipTailImg src={TooltipTail} />
    </Wrapper>
  );
};

const TooltipTailImg = styled.img`
  position: absolute;
  left: 12px;
`;
const Img = styled.img`
  width: 32px;
  height: 32px;
`;
const TooltipBody = styled.div`
  position: relative;
  display: flex;
  align-items: center;
  gap: 10px;

  width: 309px;

  background-color: ${({ theme }) => theme.color.tooltip};

  border-radius: 8px;

  padding: 12px 14px;

  box-sizing: border-box;

  span {
    ${({ theme }) => theme.font.Body4_Regular};
    color: ${({ theme }) => theme.color.grey1000};
  }
`;
const Wrapper = styled.div`
  transition: opacity 0.3s ease;

  z-index: 1;
`;

export default Tooltip;
