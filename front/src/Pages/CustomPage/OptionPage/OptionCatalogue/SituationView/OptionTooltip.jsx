import React from "react";
import { css, keyframes, styled } from "styled-components";
import TooltipTail from "@assets/icons/option-tooltip-tail.svg";
import ArrowRightIcon from "@assets/icons/arrow-right.svg";
import OptionPopup from "../../OptionPopup";
import PopupProvider from "@Components/Common/PopupProvider";

const OptionTooltip = ({
  tag,
  isOpen,
  data,
  handleSelectOption,
  selected,
  position,
}) => {
  return (
    <Wrapper $position={position} $isOpen={isOpen}>
      <Content>
        <Img src={data.options[0].imageUrl}></Img>
        <Detail>
          <div className="tag">{tag.name}</div>
          <div className="option">{data.name}</div>
          {data.additionalPrice !== 0 && (
            <div className="price">
              {data.additionalPrice.toLocaleString()}원
            </div>
          )}
        </Detail>
      </Content>
      <PopupProvider
        label={
          <OptionPopup
            data={data}
            handleSelectOption={handleSelectOption}
            selected={selected}
          />
        }
      >
        <Arrow src={ArrowRightIcon} className="arrow" />
      </PopupProvider>
      <ArrowTail src={TooltipTail} className="tail" $position={position} />
    </Wrapper>
  );
};
const ArrowTail = styled.img`
  position: absolute;
  top: ${({ $position }) => $position?.y < 23 && "-8px"};
  ${({ $position }) =>
    $position.y < 23
      ? css`
          top: -8px;
          transform: rotate(180deg);
        `
      : css`
          bottom: -8px;
        `}
  width: 14px;
  height: 10px;

  left: ${({ $position }) =>
    $position?.x < 13 ? "10px" : $position?.x > 85 ? "250px" : "130px"};
`;
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
    width: 138px;
    white-space: nowrap;
    overflow: hidden;
    text-overflow: ellipsis;
  }
  .price {
    color: ${({ theme }) => theme.color.grey100};
    ${({ theme }) => theme.font.Head4};
    margin-top: 8px;
  }
`;
const Img = styled.img`
  width: 72px;
  height: 72px;
  object-fit: cover;
`;
const Content = styled.div`
  display: flex;
  gap: 8px;
`;
const fadeIn = keyframes`
  from {
    opacity:0;
  }
  to {
    opacity: 1;
  }
`;
const fadeOut = keyframes`
  from {
    opacity:1;
  }
  to {
    opacity:0;
  }
`;
const Wrapper = styled.div`
  position: absolute;
  top: -100px;

  top: ${({ $position }) =>
    $position?.y < 23
      ? `calc(${$position?.y}% + 50px)`
      : `calc(${$position?.y}% - 110px)`};
  left: ${({ $position }) =>
    $position?.x < 13
      ? `calc(${$position?.x}% - 5px)`
      : $position?.x > 85
      ? `calc(${$position?.x}% - 240px)`
      : `calc(${$position?.x}% - 124px)`};

  display: flex;
  justify-content: space-between;
  align-items: center;

  width: 270px;
  height: 96px;

  background-color: ${({ theme }) => theme.color.grey1000};
  border-radius: 8px;

  padding: 12px;
  box-sizing: border-box;

  z-index: 997;

  animation: ${({ $isOpen }) => ($isOpen ? fadeIn : fadeOut)} 0.2s linear;
`;

export default OptionTooltip;
