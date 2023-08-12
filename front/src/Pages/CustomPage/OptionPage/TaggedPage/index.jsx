import React, { useState } from "react";
import { css, styled } from "styled-components";
import TaggedPageSampleImg from "../../../../assets/images/tagged-page-sample.svg";
import PlusIcon from "../../../../assets/icons/plus.svg";
import OptionTooltip from "./OptionTooltip";

const optionData = [
  {
    title: "option1",
    position: { x: 23, y: 35 },
  },
  {
    title: "option2",
    position: { x: 20, y: 80 },
  },
  {
    title: "option3",
    position: { x: 50, y: 3 },
  },
  {
    title: "option4",
    position: { x: 65, y: 85 },
  },
];
const TaggedPage = () => {
  const [activeOptionIdx, setActiveOptionIdx] = useState(null);

  const handlePlusBtnClick = (index) => {
    if (activeOptionIdx === null || activeOptionIdx !== index)
      setActiveOptionIdx(index);
    else setActiveOptionIdx(null);
  };
  return (
    <Wrapper>
      <SituationScreen>
        {activeOptionIdx !== null && (
          <OptionTooltip data={optionData[activeOptionIdx]} />
        )}
        <img src={TaggedPageSampleImg} />
        {optionData.map((data, index) => (
          <PlusButton
            key={index}
            $position={data.position}
            clicked={activeOptionIdx === index}
            onClick={() => handlePlusBtnClick(index)}
          >
            <img src={PlusIcon} />
          </PlusButton>
        ))}
      </SituationScreen>
      <OptionItemsContainer>
        {optionData.map((data, index) => (
          // 옵션 컴포넌트 들어갈 자리
          <div key={index}></div>
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
  margin: 36px 0px;
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
  ${({ clicked }) =>
    clicked &&
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
  gap: 16px;
  width: 100%;
  margin-top: 40px;
  & > div {
    width: 244px;
    height: 314px;
    background-color: beige;
  }
`;
const Wrapper = styled.div`
  display: flex;
  flex-direction: column;
  padding-top: 24px;
  width: 100%;
`;
export default TaggedPage;
