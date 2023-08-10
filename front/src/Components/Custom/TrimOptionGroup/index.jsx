import React, { useRef } from "react";
import { css, styled } from "styled-components";
import Button from "../../Common/Button/Button";
import TrimOption from "../TrimOption";
import Tooltip from "../Tooltip";
import useTooltip from "../../../hooks/useTooltip";
import BackgroundOverlay from "../../Common/BackgroundOverlay";
import TrimComparisonPopup from "../../../Pages/CustomPage/TrimPage/TrimComparisonPopup";
import useOnClickPopUp from "../../../hooks/useOnClickPopUp";

const TrimOptionGroup = ({ options, selectedOption, handleOptionSelect }) => {
  const { isTooltipOpen, openTooltip, closeTooltip } = useTooltip();
  const popupRef = useRef();
  const { isPopupOpen, openPopup, closePopup } = useOnClickPopUp(popupRef);
  return (
    <Wrapper>
      {isTooltipOpen && <Tooltip offset={810} />}
      {isPopupOpen && (
        <PopupWrapper>
          <BackgroundOverlay />
          <TrimComparisonPopup popupRef={popupRef} closePopup={closePopup} />
        </PopupWrapper>
      )}
      <Title onMouseEnter={openTooltip} onMouseLeave={closeTooltip}>
        <span>트림</span>
        <Button
          text="비교하기"
          style={TrimComparisonBtnStyle}
          onClick={openPopup}
        />
      </Title>
      {options.map((option, index) => (
        <TrimOption
          key={index}
          data={option}
          radioGroup={"trim"}
          selected={selectedOption === option.name}
          handleOptionSelect={() => handleOptionSelect(option.name)}
        />
      ))}
    </Wrapper>
  );
};

const PopupWrapper = styled.div`
  display: flex;
  justify-content: center;
  position: fixed;
  width: 100%;
  top: 0;
  left: 0;

  z-index: 12;
  margin-top: 120px;
`;
const TrimComparisonBtnStyle = css`
  background-color: ${({ theme }) => theme.color.grey1000};
  ${({ theme }) => theme.font.Extra17};

  border: 1px solid ${({ theme }) => theme.color.grey700};
  border-radius: 20px;

  padding: 4px 12px;
`;

const Title = styled.div`
  display: flex;
  justify-content: space-between;
  align-items: center;

  margin-top: 34px;

  span {
    ${({ theme }) => theme.font.Head2};
  }
`;
const Wrapper = styled.div`
  position: relative;
`;
export default TrimOptionGroup;
