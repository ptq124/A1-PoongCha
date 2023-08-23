import React, { useState } from "react";
import { styled, css } from "styled-components";
import Button from "@Components/Common/Button/Button";
import useButtonNavigation from "@hooks/useButtonNavigation";
import { tagData } from "./tagData";
import OptionCatalogue from "./OptionCatalogue";
import RadioGroup from "@Components/Common/RadioGroup";
import OptionTagLabel from "@Components/Custom/OptionTagLabel";
import { useUserData } from "context/UserDataContext";
import { postUserData } from "apis/custom";

const tabData = ["추가 옵션", "기본 포함 옵션"];
const OptionPage = () => {
  const { totalData, 유저데이터저장 } = useUserData();
  const handleSelectOption = (option) => {
    if (totalData["옵션"].map((option) => option.id).includes(option.id)) {
      유저데이터저장(
        "옵션",
        totalData["옵션"].filter((data) => data.id !== option.id)
      );
    } else {
      유저데이터저장("옵션", [...totalData["옵션"], option]);
    }
  };

  // 선택한 태그 상태 관리
  const [selectedTag, setSelectedTag] = useState(
    tagData.find((tag) => tag.name === "전체")
  );
  const handleSelectTag = (tag) => {
    setSelectedTag(tag);
  };

  // 선택한 탭 상태 관리
  const [selectedTab, setSelectedTab] = useState("추가 옵션");
  const handleSelectTab = (tab) => {
    setSelectedTab(tab);
    if (tab === "추가 옵션") {
      setSelectedTag(tagData.find((tag) => tag.name === "전체"));
    } else setSelectedTag(tagData.find((tag) => tag.name === "대표"));
  };

  const move = useButtonNavigation();
  // 커스텀 정보 서버 전송
  const formatAndPost = () => {
    const { 트림, 엔진, 바디, 구동방식, 외장, 내장, 옵션 } = totalData;
    const formattedData = {
      trimId: 트림.id,
      componentIds: [엔진.id, 바디.id, 구동방식.id],
      interiorId: 내장.id,
      exteriorId: 외장.id,
      optionGroupIds: 옵션.map((option) => option.id),
    };

    postUserData(formattedData).then((data) => {
      move(`/result/${data.code}`);
    });
  };

  return (
    <Wrapper>
      <TabContainer>
        {tabData.map((tab, index) => (
          <TabItem
            key={index}
            selected={selectedTab === tab}
            onClick={() => handleSelectTab(tab)}
          >
            {tab}
          </TabItem>
        ))}
      </TabContainer>
      <RadioGroup
        label={<OptionTagLabel />}
        options={selectedTab === "추가 옵션" ? tagData.slice(1) : tagData}
        newStateHandler={handleSelectTag}
        initialState={selectedTag}
        style={optionTagGroupLabelStyle}
      />
      <OptionCatalogue
        selectedTab={selectedTab}
        selectedTag={selectedTag}
        selectedOptions={totalData["옵션"]}
        handleSelectOption={handleSelectOption}
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
          onClick={() => formatAndPost()}
        />
      </ButtonContainer>
    </Wrapper>
  );
};
const optionTagGroupLabelStyle = {
  wrapper: css`
    display: flex;

    padding-bottom: 18px;
    margin: 15px 128px;

    border-bottom: 1.5px solid;
    border-bottom-color: ${({ theme }) => theme.color.grey700};
  `,
  title: css``,
  options: css`
    display: flex;
    gap: 8px;
  `,
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

  margin-top: 48px;
  padding-bottom: 79px;
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

const TabContainer = styled.div`
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
