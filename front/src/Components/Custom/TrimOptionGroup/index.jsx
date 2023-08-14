import React, { useRef } from "react";
import { css, styled } from "styled-components";
import Button from "@Components/Common/Button/Button";
import TrimOption from "./TrimOption";
import Tooltip from "../Tooltip";
import useTooltip from "@hooks/useTooltip";
import TrimComparisonPopup from "@Pages/CustomPage/TrimPage/TrimComparisonPopup";
import useOnClickPopUp from "@hooks/useOnClickPopUp";
import OverlaidPopup from "@Components/Common/OverlaidPopup";

const TrimOptionGroup = ({ options, selectedOption, handleOptionSelect }) => {
  const { isTooltipOpen, openTooltip, closeTooltip } = useTooltip();
  const popupRef = useRef();
  const {
    isPopupOpen: isComparisonPopupOpen,
    openPopup,
    closePopup,
  } = useOnClickPopUp(popupRef);
  return (
    <Wrapper>
      {isTooltipOpen && <Tooltip offset={810} />}
      {isComparisonPopupOpen && (
        <OverlaidPopup
          component={
            <TrimComparisonPopup popupRef={popupRef} closePopup={closePopup} />
          }
        />
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
          selected={selectedOption === option.name}
          handleOptionSelect={() => handleOptionSelect(option.name)}
        />
      ))}
    </Wrapper>
  );
};

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
