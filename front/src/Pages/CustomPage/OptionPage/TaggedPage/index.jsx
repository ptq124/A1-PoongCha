import React, { useRef, useState } from "react";
import { css, styled } from "styled-components";
import TaggedPageSampleImg from "../../../../assets/images/tagged-page-sample.svg";
import PlusIcon from "../../../../assets/icons/plus.svg";
import OptionTooltip from "./OptionTooltip";
import OptionItem from "../../../../Components/Custom/OptionItem";
import useOnClickPopUp from "../../../../hooks/useOnClickPopUp";
import OptionPopup from "../OptionPopup";
import OverlaidPopup from "../../../../Components/Common/OverlaidPopup";

const optionData = [
  {
    title: "option1",
    position: { x: 5, y: 35 },
    option: "컴포트 II",
    description: "편의성을 위해 구성된 세트 옵션",
    price: "1,090,000원",
    img: "https://www.hyundai.com/contents/spec/LX24/dualwidesunroof_s.jpg",
    tag: "주행안전",
  },
  {
    title: "option2",
    position: { x: 20, y: 80 },
    option: "컴포트 II",
    description: "편의성을 위해 구성된 세트 옵션",
    price: "1,090,000원",
    img: "https://www.hyundai.com/contents/spec/LX24/dualwidesunroof_s.jpg",
    tag: "주행안전",
  },
  {
    title: "option3",
    position: { x: 50, y: 10 },
    option: "컴포트 II",
    description: "편의성을 위해 구성된 세트 옵션",
    price: "1,090,000원",
    img: "https://www.hyundai.com/contents/spec/LX24/dualwidesunroof_s.jpg",
    tag: "주행안전",
  },
  {
    title: "option4",
    position: { x: 95, y: 85 },
    option: "컴포트 II",
    description: "편의성을 위해 구성된 세트 옵션",
    price: "1,090,000원",
    img: "https://www.hyundai.com/contents/spec/LX24/dualwidesunroof_s.jpg",
    tag: "주행안전",
  },
];
const TaggedPage = () => {
  const optionPopupRef = useRef();
  const { isPopupOpen, openPopup, closePopup } =
    useOnClickPopUp(optionPopupRef);
  const [activeOptionIdx, setActiveOptionIdx] = useState(null);

  const handlePlusBtnClick = (index) => {
    if (activeOptionIdx === null || activeOptionIdx !== index)
      setActiveOptionIdx(index);
    else setActiveOptionIdx(null);
  };
  return (
    <Wrapper>
      {isPopupOpen && (
        <OverlaidPopup
          component={
            <OptionPopup popupRef={optionPopupRef} closePopup={closePopup} />
          }
        />
      )}
      <SituationScreen>
        {activeOptionIdx !== null && (
          <OptionTooltip
            data={optionData[activeOptionIdx]}
            openPopup={openPopup}
          />
        )}
        <img src={TaggedPageSampleImg} />
        {optionData.map((data, index) => (
          <PlusButton
            key={index}
            $position={data.position}
            $clicked={activeOptionIdx === index}
            onClick={() => handlePlusBtnClick(index)}
          >
            <img src={PlusIcon} />
          </PlusButton>
        ))}
      </SituationScreen>
      <OptionItemsContainer>
        {optionData.map((data, index) => (
          // 옵션 컴포넌트 들어갈 자리
          <OptionItem key={index} data={data} openPopup={openPopup} />
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
  gap: 16px;
  width: 100%;
  margin-top: 40px;
  & > div {
    width: 244px;
    height: 314px;
  }
`;
const Wrapper = styled.div`
  display: flex;
  flex-direction: column;
  padding-top: 24px;
  width: 100%;
`;
export default TaggedPage;
