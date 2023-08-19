import React, { useEffect, useRef, useState } from "react";
import { styled } from "styled-components";
import { additionalOptionData, defaultOptionData } from "../optionData";
import SituationView from "./SituationView";
import DefaultView from "./DefaultView";

const OptionCatalogue = ({
  selectedTab,
  selectedTag,
  handleSelectOption,
  selectedOptions,
}) => {
  const [optionData, setOptionData] = useState();
  useEffect(() => {
    // 추가 옵션 또는 기본 포함 옵션 데이터 불러오기
    if (selectedTab === "추가 옵션") setOptionData(additionalOptionData);
    else setOptionData(defaultOptionData);
  }, [selectedTab]);
  const filteredData = optionData?.filter((data) =>
    data.tags.includes(selectedTag)
  );

  return (
    <Wrapper>
      {selectedTag === "대표" || selectedTag === "전체" ? (
        <DefaultView
          filteredData={filteredData}
          handleSelectOption={handleSelectOption}
          selectedOptions={selectedOptions}
        />
      ) : (
        <SituationView
          filteredData={filteredData}
          selectedTag={selectedTag}
          handleSelectOption={handleSelectOption}
          selectedOptions={selectedOptions}
        />
      )}
    </Wrapper>
  );
};

const Wrapper = styled.div`
  width: 100%;
`;
export default OptionCatalogue;
