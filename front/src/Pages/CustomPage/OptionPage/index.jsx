import React, { useState } from "react";
import { styled, css } from "styled-components";
import AdditionalOption from "./AdditionalOption";
import DefaultOption from "./DefaultOption";

const OptionPage = () => {
  const [selectedTab, setSelectedTab] = useState("추가 옵션");

  const isOptionPage = () => {
    if (selectedTab === "추가 옵션") return <AdditionalOption />;
    if (selectedTab === "기본 포함 옵션") return <DefaultOption />;
  };

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
      {isOptionPage()}
    </Wrapper>
  );
};

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
`;

const TabWrapper = styled.div`
  display: flex;

  width: 100%;

  gap: 40px;
  margin-top: 15px;
  padding: 0px 128px;

  border-bottom: 1px solid;
  border-bottom-color: ${({ theme }) => theme.color.grey700};
`;

const Wrapper = styled.div`
  height: 1170px;
`;

export default OptionPage;
