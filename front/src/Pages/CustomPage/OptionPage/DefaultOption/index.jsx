import React, { useState } from "react";
import { styled } from "styled-components";

import OptionTag from "../../../../Components/Custom/OptionTag";
import OptionItem from "../../../../Components/Custom/OptionItem";

import { tags, tagSelectIcons, tagsNotSelectIcons } from "../tagIcon";
import { options } from "../optionData";
import left from "../../../../assets/icons/chevron-left.svg";
import right from "../../../../assets/icons/chevron-right.svg";
import TaggedPage from "../TaggedPage";

const DefaultOption = ({ openPopup }) => {
  const tagsOption = [tags, tagSelectIcons, tagsNotSelectIcons];
  const [selectTag, setSelectTag] = useState("대표");
  const handleSelectTag = (tag) => setSelectTag(tag);

  // 탭
  const [selectOption, setSelectOption] = useState([]);
  const handleSelectOption = (option) => {
    if (hasOption(option))
      setSelectOption((prev) => prev.filter((opt) => opt !== option));
    else setSelectOption((prev) => [...prev, option]);
  };
  const hasOption = (option) => {
    return selectOption.includes(option);
  };

  // 페이지 네이션
  const getDataForPage = (data, page, itemsPerPage) => {
    const startIndex = (page - 1) * itemsPerPage;
    const endIndex = startIndex + itemsPerPage;
    return data.slice(startIndex, endIndex);
  };

  const [currentPage, setCurrentPage] = useState(1);
  let totalPages = 0;

  const handlePageChange = (newPage) => {
    if (newPage >= 1 && newPage <= totalPages) {
      setCurrentPage(newPage);
    }
  };

  const renderAllOptionItems = () => {
    const currentData = getDataForPage(options, currentPage, 8);
    totalPages = Math.ceil(options.length / 8);

    return currentData.map((data, index) => (
      <OptionItem
        key={index}
        data={data}
        selected={hasOption(data.option)}
        handleSelectOption={handleSelectOption}
        openPopup={openPopup}
      />
    ));
  };

  const renderTagOptionPage = () => {
    const newData = options.filter((data) => data.tag === selectTag);
    const currentData = getDataForPage(newData, currentPage, 8);
    totalPages = Math.ceil(newData.length / 8);

    return <TaggedPage openPopup={openPopup} optionData={currentData} />;
  };

  const renderOptionItems = () => {
    if (selectTag === "전체" || selectTag === "대표")
      return renderAllOptionItems();
    else return renderTagOptionPage();
  };

  return (
    <Wrapper>
      <OptionTag
        selectTag={selectTag}
        tagsOption={tagsOption}
        handleSelectTag={handleSelectTag}
      />
      <MainContainer>
        {(selectTag === "전체" || selectTag === "대표") && (
          <Count>
            <div>전체</div>
            <span>{options.length}</span>
          </Count>
        )}
        <OptionContainer>{renderOptionItems()}</OptionContainer>
        {(selectTag === "전체" || selectTag === "대표") && (
          <PageBtn>
            <img src={left} onClick={() => handlePageChange(currentPage - 1)} />
            {Array.from({ length: totalPages }, (_, index) => (
              <span
                key={index}
                onClick={() => handlePageChange(index + 1)}
                className={currentPage === index + 1 ? "active" : ""}
              >
                {index + 1}
              </span>
            ))}
            <img
              src={right}
              onClick={() => handlePageChange(currentPage + 1)}
            />
          </PageBtn>
        )}
      </MainContainer>
    </Wrapper>
  );
};

const PageBtn = styled.div`
  display: flex;
  align-items: center;
  justify-content: center;
  margin: auto;
  ${({ theme }) => theme.font.Body3_Regular};
  color: ${({ theme }) => theme.color.grey100};
  gap: 8px;
  margin-top: 63px;
  cursor: pointer;

  span {
    display: flex;
    justify-content: center;
    align-items: center;
    width: 27px;
    height: 27px;
    border-radius: 50%;
    text-align: center;
    &.active {
      background-color: ${({ theme }) => theme.color.grey700};
    }
  }
  & > img {
    cursor: pointer;
  }
`;

const OptionContainer = styled.div`
  display: flex;
  flex-wrap: wrap;
  gap: 16px;
`;

const Count = styled.div`
  display: flex;
  gap: 4px;

  ${({ theme }) => theme.font.Body3_Medium};
  color: ${({ theme }) => theme.color.grey300};

  span {
    color: ${({ theme }) => theme.color.primary_default};
  }

  margin-top: 19px;
  margin-bottom: 16px;
`;

const MainContainer = styled.div``;

const Wrapper = styled.div`
  padding: 0px 128px;
`;

export default DefaultOption;
