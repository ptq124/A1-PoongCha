import React, { useRef } from "react";
import { styled } from "styled-components";
import Check28BlueIcon from "@assets/checkcircle/check-28-blue.svg";
import Check28GreyIcon from "@assets/checkcircle/check-28-grey.svg";
import DefaultOption from "./DefaultOption";
import OverlaidPopup from "@Components/Common/OverlaidPopup";
import TrimChangePopup from "@Pages/CustomPage/TrimPage/TrimChangePopup";
import useOnClickPopUp from "@hooks/useOnClickPopUp";

const TrimOptionLabel = (option, selectedItem, handleSelectItem) => {
  const TrimChangePopupRef = useRef();
  const {
    isPopupOpen: isTrimChangePopupOpen,
    openPopup: openTrimChangePopup,
    closePopup: closeTrimChangePopup,
  } = useOnClickPopUp(TrimChangePopupRef);
  const handleTrimChangeAttempt = (newState) => {
    if (newState === selectedItem) return;
    if (true) {
      // 일단 항상 팝업 띄우도록 설정
      openTrimChangePopup();
    } else {
      setOptionSelect("trim", newValue);
    }
  };
  return (
    <Wrapper>
      {isTrimChangePopupOpen && (
        <OverlaidPopup
          component={
            <TrimChangePopup
              popupRef={TrimChangePopupRef}
              closePopup={closeTrimChangePopup}
              changeTrim={() => handleSelectItem(option.name)}
            />
          }
        />
      )}
      <TrimOptionUpper>
        <TrimInfo>
          <NameAndModelItem>
            <span className="trimName">{option.name}</span>
            <span className="modelItemSummary">디젤 2.2 • 7인승 • 2WD</span>
          </NameAndModelItem>
          <span className="comment">{option.information}</span>
          <span className="price">{option.minPrice.toLocaleString()}원</span>
        </TrimInfo>
        <CheckBtn onClick={() => handleTrimChangeAttempt(option.name)}>
          {option.name === selectedItem ? (
            <img src={Check28BlueIcon} alt="checked" />
          ) : (
            <img src={Check28GreyIcon} alt="checked" />
          )}
        </CheckBtn>
      </TrimOptionUpper>

      <TrimDefaultOptions>
        <span className="defaultOptionTitle">기본 옵션</span>
        <DefaultOptions>
          {option.defaultOptions.map((option, index) => (
            <DefaultOption key={index} option={option} />
          ))}
        </DefaultOptions>
      </TrimDefaultOptions>
    </Wrapper>
  );
};

const CheckBtn = styled.label`
  &:hover {
    cursor: pointer;
  }
`;
const DefaultOptions = styled.div`
  display: flex;
  flex-wrap: wrap;
`;
const NameAndModelItem = styled.div`
  display: flex;
  align-items: center;
  gap: 8px;

  .trimName {
    color: ${({ theme }) => theme.color.grey300};
    ${({ theme }) => theme.font.Body4_Medium};
  }
  .modelItemSummary {
    color: ${({ theme }) => theme.color.grey500};
    ${({ theme }) => theme.font.Caption1_Regular};
  }
`;
const TrimInfo = styled.div`
  display: flex;
  flex-direction: column;
  .comment {
    ${({ theme }) => theme.font.Body3_Regular};
    margin-top: 4px;
  }
  .price {
    ${({ theme }) => theme.font.Head2};
    margin-top: 8px;
  }
`;
const TrimOptionUpper = styled.div`
  display: flex;
  justify-content: space-between;
  align-items: flex-start;
  width: 100%;
`;
const TrimDefaultOptions = styled.div`
  display: flex;
  align-items: flex-start;
  gap: 12px;

  margin-top: 14px;
  .defaultOptionTitle {
    display: flex;
    flex-shrink: 0;

    color: ${({ theme }) => theme.color.grey300};
    ${({ theme }) => theme.font.Body4_Medium};
  }
`;
const Wrapper = styled.div`
  display: flex;
  flex-direction: column;
  margin-top: 24px;
  padding-bottom: 24px;

  border-bottom: 1px solid ${({ theme }) => theme.color.grey700};
  &:last-child {
    border-bottom: none;
  }
`;
export default TrimOptionLabel;
