import React, { Suspense, useEffect, useState } from "react";
import { styled } from "styled-components";
import SituationView from "./SituationView";
import DefaultView from "./DefaultView";
import { getOption } from "apis/custom";
import Loading from "@Components/Common/Loading";

const OptionCatalogue = ({
  selectedTab,
  selectedTag,
  handleSelectOption,
  selectedOptions,
}) => {
  const [optionData, setOptionData] = useState();

  useEffect(() => {
    const fetchData = async () => {
      const data = await getOption();
      if (selectedTab === "추가 옵션") {
        setOptionData(data?.filter((option) => option.additionalPrice > 0));
      } else {
        setOptionData(data?.filter((option) => option.additionalPrice === 0));
      }
    };
    fetchData();
  }, [selectedTab]);

  const filteredData = optionData?.filter((data) =>
    data.tagNames.includes(selectedTag.name)
  );

  const [isLoading, setLoading] = useState(true);

  useEffect(() => {
    setLoading(true);
    setTimeout(() => {
      setLoading(false);
    }, 1500);
  }, [selectedTag]);

  if (isLoading) return <Loading />;

  return (
    <Wrapper>
      {selectedTag.name == "대표" || selectedTag.name === "전체" ? (
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
