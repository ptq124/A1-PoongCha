import React, { useEffect, useState } from "react";
import { styled } from "styled-components";
import SituationView from "./SituationView";
import DefaultView from "./DefaultView";
import { GET } from "@utils/fetch";

const OptionCatalogue = ({
  selectedTab,
  selectedTag,
  handleSelectOption,
  selectedOptions,
}) => {
  const [optionData, setOptionData] = useState();
  useEffect(() => {
    GET(import.meta.env.VITE_BASE_URL + "/option-group").then((data) => {
      if (selectedTab === "추가 옵션") {
        setOptionData(data?.filter((option) => option.additionalPrice > 0));
      } else {
        // 기본 포함 옵션

        setOptionData(data?.filter((option) => option.additionalPrice === 0));
      }
    });
  }, [selectedTab]);

  const filteredData = optionData?.filter((data) =>
    data.tagNames.includes(selectedTag.name)
  );

  return (
    <Wrapper>
      {selectedTag.name === "대표" || selectedTag.name === "전체" ? (
        <DefaultView
          filteredData={selectedTag.name === "대표" ? filteredData : optionData}
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
