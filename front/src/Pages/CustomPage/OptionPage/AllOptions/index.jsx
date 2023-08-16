import React, { useState, useEffect, useRef } from "react";
import { styled } from "styled-components";
import OptionTag from "@Components/Custom/OptionTag";
import OptionItem from "@Components/Custom/OptionItem";
import TaggedPage from "./TaggedPage";
import { tags, tagSelectIcons, tagsNotSelectIcons } from "../tagIcon";
import left from "@assets/icons/chevron-left.svg";
import right from "@assets/icons/chevron-right.svg";
import useOnClickPopUp from "@hooks/useOnClickPopUp";
import OverlaidPopup from "@Components/Common/OverlaidPopup";
import OptionPopup from "../OptionPopup";

const AllOptions = ({
  tab,
  options,
  handleSelectOption,
  checkOptionSelected,
}) => {
  const [tagsOption, setTagsOption] = useState([]);
  const [selectTag, setSelectTag] = useState(null);
  const handleSelectTag = (tag) => setSelectTag(tag);
  useEffect(() => {
    if (tab === "추가 옵션") {
      setTagsOption([
        tags.slice(1),
        tagSelectIcons.slice(1),
        tagsNotSelectIcons.slice(1),
      ]);
      setSelectTag("전체");
    }
    if (tab === "기본 포함 옵션") {
      setTagsOption([tags, tagSelectIcons, tagsNotSelectIcons]);
      setSelectTag("대표");
    }
  }, [tab]);

  // 더 알아보기 팝업
  const optionPopupRef = useRef();
  const { isPopupOpen, openPopup, closePopup } =
    useOnClickPopUp(optionPopupRef);
  const [popupOptionName, setPopupOptionName] = useState(null);
  const handleOpenPopup = (data) => {
    setPopupOptionName(data);
    openPopup();
  };

  // 페이지네이션
  const getDataForPage = (data, page, itemsPerPage) => {
    const startIndex = (page - 1) * itemsPerPage;
    const endIndex = startIndex + itemsPerPage;
    return data.slice(startIndex, endIndex);
  };

  const [currentPage, setCurrentPage] = useState(1);

  const handlePageChange = (newPage) => {
    if (newPage >= 1 && newPage <= totalPages) {
      setCurrentPage(newPage);
    }
  };
  let totalPages = 0;
  const renderFilteredOption = () => {
    if (selectTag === "전체") {
      const currentData = getDataForPage(options, currentPage, 8);
      totalPages = Math.ceil(options.length / 8);
      return currentData.map((data, index) => (
        <OptionItem
          key={index}
          data={data}
          selected={checkOptionSelected(data.option)}
          handleSelectOption={handleSelectOption}
          handleOpenPopup={handleOpenPopup}
        />
      ));
    } else if (selectTag === "대표") {
      const currentData = options.filter((data) => data.tag === selectTag);
      return currentData.map((data, index) => (
        <OptionItem
          key={index}
          data={data}
          selected={checkOptionSelected(data.option)}
          handleSelectOption={handleSelectOption}
          handleOpenPopup={handleOpenPopup}
        />
      ));
    } else
      return (
        <TaggedPage
          handleOpenPopup={handleOpenPopup}
          handleSelectOption={handleSelectOption}
          optionData={options.filter((data) => data.tag === selectTag)}
          checkOptionSelected={checkOptionSelected}
        />
      );
  };

  return (
    <Wrapper>
      {isPopupOpen && (
        <OverlaidPopup
          component={
            <OptionPopup
              popupRef={optionPopupRef}
              closePopup={closePopup}
              popupOptionName={popupOptionName}
              handleSelectOption={handleSelectOption}
              checkOptionSelected={checkOptionSelected}
            />
          }
        />
      )}
      <OptionTag
        selectTag={selectTag}
        tagsOption={tagsOption}
        handleSelectTag={handleSelectTag}
      ></OptionTag>
      <MainContainer>
        {selectTag === "전체" && (
          <Count>
            <div>전체</div>
            <span>{options.filter((data) => data.tag !== "대표").length}</span>
          </Count>
        )}
        <OptionContainer>{renderFilteredOption()}</OptionContainer>
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

export default AllOptions;
