import React, { useState } from "react";
import { css, styled } from "styled-components";
import OptionTooltip from "./OptionTooltip";
import OptionItem from "@Components/Custom/OptionItem";
import SituationViewSampleImg from "@assets/images/tagged-page-sample.svg";
import PlusIcon from "@assets/icons/plus.svg";

const SituationView = ({
  filteredData,
  selectedTag,
  handleSelectOption,
  selectedOptions,
}) => {
  // 툴팁 오픈 상태 관리
  const [activeOption, setActiveOption] = useState(null);
  const [isTooltipOpen, setIsTooltipOpen] = useState(false);
  const [isTooltipFixed, setIsTooltipFixed] = useState(false);
  const handlePlusBtnHover = (id) => {
    if (isTooltipFixed && activeOption !== id) {
      setIsTooltipFixed(false);
    }
    setIsTooltipOpen(true);
    setActiveOption(id);
  };
  const handlePlusBtnLeave = () => {
    if (!isTooltipFixed) {
      setIsTooltipOpen(false);
      setTimeout(() => {
        setActiveOption(null);
      }, 200);
    }
  };
  const handlePlusBtnClick = () => {
    setIsTooltipFixed(!isTooltipFixed);
  };

  return (
    <Wrapper>
      <SituationScreen>
        {activeOption !== null &&
          filteredData.map((data) => data.id).includes(activeOption) && (
            <OptionTooltip
              tag={selectedTag}
              isOpen={isTooltipOpen}
              data={filteredData.find((item) => item.id === activeOption)}
              handleSelectOption={handleSelectOption}
              selected={selectedOptions.includes(activeOption)}
            />
          )}
        <img src={SituationViewSampleImg} />
        {/* {filteredData.map((data, index) => (
          <PlusButton
            key={index}
            $position={data.position}
            $clicked={activeOption === data.id}
            onMouseEnter={() => handlePlusBtnHover(data.id)}
            onMouseLeave={handlePlusBtnLeave}
            onClick={handlePlusBtnClick}
          >
            <img src={PlusIcon} />
          </PlusButton>
        ))} */}
      </SituationScreen>
      <OptionItemsContainer>
        {filteredData.map((data, index) => (
          <OptionItem
            key={index}
            data={data}
            selected={selectedOptions.includes(data.id)}
            handleSelectOption={handleSelectOption}
          />
        ))}
      </OptionItemsContainer>
      <AdditionalComment>
        *상기 이미지는 이해를 돕기 위한 이미지로 실제 옵션 사진은 상세보기에서
        확인해주세요.
      </AdditionalComment>
    </Wrapper>
  );
};

const AdditionalComment = styled.div`
  ${({ theme }) => theme.font.Caption1_Regular};
  color: ${({ theme }) => theme.color.grey500};
  margin-top: -30px;
`;
const PlusButton = styled.div`
  position: absolute;
  top: ${({ $position }) => $position.y}%;
  left: ${({ $position }) => $position.x}%;

  display: flex;
  align-items: center;
  justify-content: center;

  width: 28px;
  height: 28px;

  background-color: #acb8c8;

  border-radius: 55px;
  opacity: 0.8;

  &:hover {
    background-color: ${({ theme }) => theme.color.secondary};
    cursor: pointer;
  }
  img {
    width: 18px;
    height: 18px;
  }
  ${({ $clicked }) =>
    $clicked &&
    css`
      background-color: ${({ theme }) => theme.color.secondary};
    `}
`;
const SituationScreen = styled.div`
  position: relative;
  & > img {
    width: 100%;
  }
`;
const OptionItemsContainer = styled.div`
  display: flex;
  overflow-x: scroll;
  gap: 16px;
  width: 100%;
`;
const Wrapper = styled.div`
  display: flex;
  flex-direction: column;
  padding: 24px 128px 0px;
  gap: 40px;
`;
export default SituationView;
