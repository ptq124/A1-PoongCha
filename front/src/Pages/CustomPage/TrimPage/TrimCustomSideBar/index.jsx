import React, { useReducer, useRef } from "react";
import { css, styled } from "styled-components";
import { initialState, reducer } from "./index.reducer";
import Button from "@Components/Common/Button/Button";
import useButtonNavigation from "@hooks/useButtonNavigation";
import helpIcon from "@assets/icons/help-circle.svg";
import useOnClickPopUp from "@hooks/useOnClickPopUp";
import OverlaidPopup from "@Components/Common/OverlaidPopup";
import ModelItemsDescriptionPopup from "../ModelItemsDescriptionPopup";
import { TrimOptions, modelItemData } from "./mockData";
import ModelItemOptionLabel from "@Components/Custom/ModelItemOptionLabel";
import RadioGroup from "@Components/Common/RadioGroup";
import TrimOptionLabel from "@Components/Custom/TrimOptionLabel";
import TrimComparisonPopup from "../TrimComparisonPopup";

const TrimCustomSideBar = () => {
  const move = useButtonNavigation();
  const [state, dispatch] = useReducer(reducer, initialState);
  const setOptionSelect = (questionKey, option) => {
    dispatch({
      type: "SELECT_OPTION",
      questionKey,
      option,
    });
  };

  const modelItemDescriptionPopupRef = useRef();
  const {
    isPopupOpen: isModelItemDescriptionPopupOpen,
    openPopup: openModelItemDescriptionPopup,
    closePopup: closeModelItemDescriptionPopup,
  } = useOnClickPopUp(modelItemDescriptionPopupRef);

  const trimComparisonPopupRef = useRef();
  const {
    isPopupOpen: isTrimComparisonPopupOpen,
    openPopup: openTrimComparisonPopup,
    closePopup: closeTrimComparisonPopup,
  } = useOnClickPopUp(trimComparisonPopupRef);
  const trimRadioGroupTitle = () => {
    return (
      <>
        <span>트림</span>
        <Button
          text="비교하기"
          style={TrimComparisonBtnStyle}
          onClick={openTrimComparisonPopup}
        />
      </>
    );
  };
  return (
    <Wrapper>
      {isModelItemDescriptionPopupOpen && (
        <OverlaidPopup
          component={
            <ModelItemsDescriptionPopup
              popupRef={modelItemDescriptionPopupRef}
              closePopup={closeModelItemDescriptionPopup}
            />
          }
        />
      )}
      {isTrimComparisonPopupOpen && (
        <OverlaidPopup
          component={
            <TrimComparisonPopup
              popupRef={trimComparisonPopupRef}
              closePopup={closeTrimComparisonPopup}
            />
          }
        />
      )}
      <CustomBarContent>
        <LinkBtnContainer>
          <img src={helpIcon} />
          <Button
            text="고르기 어렵다면?"
            style={LinkBtnStyle}
            onClick={openModelItemDescriptionPopup}
          />
        </LinkBtnContainer>
        {/* 엔진/바디/구동방식 선택하기 */}
        <ModelItems>
          {Object.entries(modelItemData).map(([questionKey, data]) => (
            <RadioGroup
              key={questionKey}
              title={data.title}
              label={ModelItemOptionLabel}
              options={data.options}
              newStateHandler={(newState) =>
                setOptionSelect(questionKey, newState)
              }
              initialState={state[questionKey]}
              style={modelItemRadioGroupStyle}
            />
          ))}
        </ModelItems>
        {/* 트림 선택하기 */}
        <RadioGroup
          title={trimRadioGroupTitle()}
          label={TrimOptionLabel}
          options={TrimOptions}
          newStateHandler={(newState) => {
            setOptionSelect("trim", newState);
          }}
          initialState={state["trim"]}
          style={trimOptionGroupStyle}
        />
        <Button
          text="색상 선택"
          style={nextBtnStyle}
          onClick={() => move("/custom/color")}
        />
      </CustomBarContent>
    </Wrapper>
  );
};

const trimOptionGroupStyle = {
  wrapper: css``,
  title: css`
    display: flex;
    justify-content: space-between;
    align-items: center;
    ${({ theme }) => theme.font.Head2};
    margin-top: 32px;
  `,
  options: css``,
};
const TrimComparisonBtnStyle = css`
  background-color: ${({ theme }) => theme.color.grey1000};
  ${({ theme }) => theme.font.Extra17};

  border: 1px solid ${({ theme }) => theme.color.grey700};
  border-radius: 20px;

  padding: 4px 12px;
`;
const modelItemRadioGroupStyle = {
  wrapper: css`
    position: relative;
    display: flex;
    flex-direction: column;
    margin: 0px 12px;
  `,
  title: css`
    ${({ theme }) => theme.font.Body4_Medium};
  `,
  options: css`
    position: relative;
    display: flex;
    width: 100%;
    margin-top: 4px;
    & > div {
      width: 50%;
    }
  `,
};
const LinkBtnContainer = styled.div`
  display: flex;
  gap: 2px;
  margin-top: 56px;
`;
const nextBtnStyle = css`
  width: 100%;
  height: 52px;

  color: ${({ theme }) => theme.color.grey1000};
  background-color: ${({ theme }) => theme.color.primary_default};
  ${({ theme }) => theme.font.Body3_Medium};

  border: 1px solid ${({ theme }) => theme.color.primary_default};
  border-radius: 6px;

  margin-top: 24px;
`;
const ModelItems = styled.div`
  position: relative;
  display: flex;
  flex-direction: column;
  gap: 12px;

  border: 1px solid ${({ theme }) => theme.color.grey700};
  border-radius: 8px;

  padding: 12px 0px;
  margin-top: 16px;
`;
const LinkBtnStyle = css`
  color: ${({ theme }) => theme.color.secondary};
  background-color: ${({ theme }) => theme.color.grey1000};

  border: none;
  ${({ theme }) => theme.font.Extra4};
  background: none;
  padding: 0;
  outline: 0;
  text-decoration: underline;
  text-underline-offset: 3px;
`;

const CustomBarContent = styled.div`
  width: 309px;
  margin-right: 128px;

  box-sizing: border-box;
`;

const Wrapper = styled.div`
  display: flex;
  justify-content: flex-end;
  flex: 0 0 auto;
  width: 473px;
  height: 1292px;
`;
export default TrimCustomSideBar;
