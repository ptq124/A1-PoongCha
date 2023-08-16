import React, { useRef, useState } from "react";
import { styled, css } from "styled-components";
import AllOptions from "./AllOptions";
import Button from "@Components/Common/Button/Button";
import useButtonNavigation from "@hooks/useButtonNavigation";
import { options } from "./optionData";

const OptionPage = () => {
  // 선택한 옵션들 상태관리
  const [selectOption, setSelectOption] = useState([]);
  const handleSelectOption = (option) => {
    if (checkOptionSelected(option))
      setSelectOption((prev) => prev.filter((opt) => opt !== option));
    else setSelectOption((prev) => [...prev, option]);
  };
  const checkOptionSelected = (option) => {
    return selectOption.includes(option);
  };

  const [selectedTab, setSelectedTab] = useState("추가 옵션");
  const move = useButtonNavigation();

  return (
    <Wrapper>
      <TabWrapper>
        <TabItem
          selected={selectedTab === "추가 옵션"}
          onClick={() => setSelectedTab("추가 옵션")}
        >
          추가 옵션
        </TabItem>
        <TabItem
          selected={selectedTab === "기본 포함 옵션"}
          onClick={() => setSelectedTab("기본 포함 옵션")}
        >
          기본 포함 옵션
        </TabItem>
      </TabWrapper>
      <AllOptions
        tab={selectedTab}
        options={options}
        handleSelectOption={handleSelectOption}
        checkOptionSelected={checkOptionSelected}
      />
      <ButtonContainer>
        <Button
          text="색상선택"
          style={BtnStyle1}
          onClick={() => move("/custom/color")}
        />
        <Button
          text="견적내기"
          style={BtnStyle2}
          onClick={() => move("/result")}
        />
      </ButtonContainer>
    </Wrapper>
  );
};

const BtnStyle2 = css`
  width: 298px;
  height: 52px;

  color: ${({ theme }) => theme.color.grey1000};
  background-color: ${({ theme }) => theme.color.primary_default};
  ${({ theme }) => theme.font.Body3_Medium};

  border: 1px solid ${({ theme }) => theme.color.primary_default};
  border-radius: 6px;
`;

const BtnStyle1 = css`
  width: 298px;
  height: 52px;

  color: ${({ theme }) => theme.color.grey50};
  background-color: ${({ theme }) => theme.color.grey1000};
  ${({ theme }) => theme.font.Body3_Medium};

  border: 1px solid ${({ theme }) => theme.color.grey600};
  border-radius: 6px;
`;

const ButtonContainer = styled.div`
  display: flex;
  justify-content: center;

  margin-top: 50px;
  gap: 12px;
  width: 100%;
`;

const TabItem = styled.div`
  ${({ selected }) =>
    !selected
      ? css`
          color: ${({ theme }) => theme.color.grey700};
        `
      : css`
          color: ${({ theme }) => theme.color.grey200};
          border-bottom: 1.5px solid;
          border-bottom-color: ${({ theme }) => theme.color.grey200};
        `};

  ${({ theme }) => theme.font.Head2};
  cursor: pointer;
  padding-bottom: 8px;
`;

const TabWrapper = styled.div`
  display: flex;

  gap: 40px;
  margin-top: 15px;
  padding: 0px 128px;

  border-bottom: 1px solid;
  border-bottom-color: ${({ theme }) => theme.color.grey700};
`;

const Wrapper = styled.div`
  padding-top: 140px;
  height: 1070px;
`;

export default OptionPage;
