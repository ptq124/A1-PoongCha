import React, { useEffect, useReducer, useState } from "react";
import { css, styled } from "styled-components";
import { initialState, reducer } from "./index.reducer";
import Button from "@Components/Common/Button/Button";
import useButtonNavigation from "@hooks/useButtonNavigation";
import helpIcon from "@assets/icons/help-circle.svg";
import { TrimOptions } from "./mockData";
import ModelItemOptionLabel from "@Components/Custom/ModelItemOptionLabel";
import RadioGroup from "@Components/Common/RadioGroup";
import TrimOptionLabel from "@Components/Custom/TrimOptionLabel";
import ModelItemsDescriptionPopup from "../ModelItemsDescriptionPopup";
import TrimComparisonPopup from "../TrimComparisonPopup";
import Tooltip from "@Components/Custom/Tooltip";
import TooltipProvider from "@Components/Common/TooltipProvider";
import PopupProvider from "@Components/Common/PopupProvider";
import { getComponent } from "apis/custom";
import { useUserData } from "context/UserDataContext";

const TrimCustomSideBar = () => {
  const move = useButtonNavigation();
  const { totalData, 유저데이터저장 } = useUserData();
  const [componentGroupData, setComponentGroupData] = useState([]);

  useEffect(() => {
    getComponent().then((data) => {
      setComponentGroupData(data);
    });
  }, []);

  const trimRadioGroupTitle = () => {
    return (
      <>
        <span>트림</span>
        <PopupProvider label={<TrimComparisonPopup />}>
          <Button text="비교하기" style={TrimComparisonBtnStyle} />
        </PopupProvider>
      </>
    );
  };
  return (
    <Wrapper>
      <CustomBarContent>
        <LinkBtnContainer>
          <img src={helpIcon} />
          <PopupProvider label={<ModelItemsDescriptionPopup />}>
            <Button text="고르기 어렵다면?" style={LinkBtnStyle} />
          </PopupProvider>
        </LinkBtnContainer>

        {/* 엔진/바디/구동방식 선택하기 */}
        <ModelItems>
          {componentGroupData?.map((data) => (
            <TooltipProvider
              key={data.id}
              label={<Tooltip content={data.selectionHelpTooltip} />}
              offset={css`
                bottom: 78px;
              `}
            >
              <RadioGroup
                title={data.name}
                label={<ModelItemOptionLabel />}
                options={data.component}
                newStateHandler={(newState) =>
                  유저데이터저장(data.name, newState)
                }
                initialState={totalData[data.name]}
                style={modelItemRadioGroupStyle}
              />
            </TooltipProvider>
          ))}
        </ModelItems>

        {/* 트림 선택하기 */}
        <TooltipProvider
          label={
            <Tooltip content="트림은 등급이에요. 등급이 올라갈수록 기본 포함 옵션들이 점점 추가되고 내부 시트의 퀄리티가 높아져요." />
          }
          offset={css`
            top: -110px;
          `}
        >
          <RadioGroup
            title={trimRadioGroupTitle()}
            label={<TrimOptionLabel />}
            options={TrimOptions}
            newStateHandler={(newState) => 유저데이터저장("트림", newState)}
            initialState={totalData["트림"]}
            style={trimOptionGroupStyle}
          />
        </TooltipProvider>
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
