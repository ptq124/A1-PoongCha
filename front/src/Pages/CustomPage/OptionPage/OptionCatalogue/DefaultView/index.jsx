import React, { useState } from "react";
import { styled } from "styled-components";
import OptionItem from "@Components/Custom/OptionItem";
import leftArrow from "@assets/icons/chevron-left.svg";
import rightArrow from "@assets/icons/chevron-right.svg";
import { OPTION_ITEMS_PER_PAGE } from "@utils/constants";

const DefaultView = ({ filteredData, handleSelectOption, selectedOptions }) => {
  const [crntPage, setCrntPage] = useState(1);
  const handlePageChange = (newPage) => {
    if (newPage >= 1 && newPage <= filteredData?.length) {
      setCrntPage(newPage);
    }
  };
  const getPagedData = (data, page, itemsPerPage) => {
    const startIndex = (page - 1) * itemsPerPage;
    const endIndex = startIndex + itemsPerPage;
    return data?.slice(startIndex, endIndex);
  };
  return (
    <Wrapper>
      <TotalOptionsInfo>
        전체 <strong>{filteredData?.length}</strong>
      </TotalOptionsInfo>
      <OptionContainer>
        {getPagedData(filteredData, crntPage, OPTION_ITEMS_PER_PAGE)?.map(
          (data, index) => (
            <OptionItem
              key={index}
              data={data}
              selected={selectedOptions.includes(data)}
              handleSelectOption={handleSelectOption}
            />
          )
        )}
      </OptionContainer>
      <PageBtn>
        <img src={leftArrow} onClick={() => handlePageChange(crntPage - 1)} />
        {Array.from(
          { length: Math.ceil(filteredData?.length / 8) },
          (_, index) => (
            <span
              key={index}
              onClick={() => handlePageChange(index + 1)}
              className={crntPage === index + 1 ? "active" : ""}
            >
              {index + 1}
            </span>
          )
        )}
        <img src={rightArrow} onClick={() => handlePageChange(crntPage + 1)} />
      </PageBtn>
    </Wrapper>
  );
};

const TotalOptionsInfo = styled.div`
  ${({ theme }) => theme.font.Body2_Regular};
  margin-bottom: 16px;
  color: ${({ theme }) => theme.color.grey300};

  strong {
    color: ${({ theme }) => theme.color.secondary};
  }
`;
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
const Wrapper = styled.div`
  display: flex;
  flex-direction: column;
  padding: 0px 128px;
`;
export default DefaultView;
