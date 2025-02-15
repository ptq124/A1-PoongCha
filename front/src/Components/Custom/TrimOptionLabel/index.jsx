import React, { useRef } from "react";
import { styled } from "styled-components";
import Check28BlueIcon from "@assets/checkcircle/check-28-blue.svg";
import Check28GreyIcon from "@assets/checkcircle/check-28-grey.svg";
import DefaultOption from "./DefaultOption";
import OverlaidPopup from "@Components/Common/PopupProvider/OverlaidPopup";
import TrimChangePopup from "@Pages/CustomPage/TrimPage/TrimChangePopup";
import useOnClickPopUp from "@hooks/useOnClickPopUp";
import { useUserData } from "context/UserDataContext";

const TrimOptionLabel = ({ value, handleSelectItem, checked }) => {
  const {
    totalData: { 엔진, 바디, 구동방식 },
  } = useUserData();
  const TrimChangePopupRef = useRef();
  const {
    isPopupOpen: isTrimChangePopupOpen,
    openPopup: openTrimChangePopup,
    closePopup: closeTrimChangePopup,
  } = useOnClickPopUp(TrimChangePopupRef);

  const handleTrimChangeAttempt = (newState) => {
    if (checked) return;
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
              changeTrim={() => handleSelectItem(value)}
            />
          }
        />
      )}
      <TrimOptionUpper>
        <TrimInfo>
          <NameAndModelItem>
            <span className="trimName">{value?.trimName}</span>
            <span className="modelItemSummary">
              {엔진.name} • {바디.name} • {구동방식.name}
            </span>
          </NameAndModelItem>
          <span className="comment">합리적인 당신을 위한</span>
          <span className="price">{value?.minPrice.toLocaleString()}원</span>
        </TrimInfo>
        <CheckBtn onClick={() => handleTrimChangeAttempt(value)}>
          {checked ? (
            <img src={Check28BlueIcon} alt="checked" />
          ) : (
            <img src={Check28GreyIcon} alt="checked" />
          )}
        </CheckBtn>
      </TrimOptionUpper>

      <TrimDefaultOptions>
        <span className="defaultOptionTitle">기본 옵션</span>
        <DefaultOptions>
          {value.optionGroups.slice(0, 3).map((option, index) => (
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
  width: 100%;
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
