import React, { useState } from "react";
import { css, styled } from "styled-components";
import Card from "./Card";
import ArrowLeftIcon from "../../../../assets/icons/arrow-left-32-white.svg";
import ArrowRightIcon from "../../../../assets/icons/arrow-right-32-white.svg";

const popupData = [
  "후석 승객 알림",
  "메탈 리어범퍼스텝",
  "메탈 도어스커프",
  "3열 파워폴딩시트",
  "3열 열선시트",
  "헤드업 디스플레이",
];

const OptionPopup = ({ popupRef, closePopup }) => {
  const [crntOptionIdx, setCrntOptionIdx] = useState(0);
  return (
    <Wrapper ref={popupRef}>
      <Window>
        {crntOptionIdx > 0 && (
          <LeftArrow className="left">
            <img src={ArrowLeftIcon} />
          </LeftArrow>
        )}

        <Cards crntOptionIdx={crntOptionIdx}>
          {popupData.map((data, index) => (
            <Card
              key={index}
              index={index}
              popupData={popupData}
              closePopup={closePopup}
              crntOptionIdx={crntOptionIdx}
            />
          ))}
        </Cards>
        {crntOptionIdx < popupData.length - 1 && (
          <RightArrow className="right">
            <img src={ArrowRightIcon} />
          </RightArrow>
        )}
      </Window>
    </Wrapper>
  );
};

const Arrow = styled.div`
  position: absolute;
  display: flex;
  justify-content: center;
  align-items: center;
  width: 50px;
  height: 50px;
  background: rgba(255, 255, 255, 0.3);
  border-radius: 4px;
  z-index: 1000;
  &:hover {
    cursor: pointer;
  }
`;
const LeftArrow = styled(Arrow)`
  left: -102px;
`;
const RightArrow = styled(Arrow)`
  right: -102px;
`;
const Cards = styled.div`
  display: flex;
  flex-wrap: nowrap;
  justify-content: flex-start;
  gap: 24px;
  margin-left: -${({ crntOptionIdx }) => crntOptionIdx * 924}px;
`;
const Window = styled.div`
  position: relative;
  display: flex;
  align-items: center;
  width: 900px;
  height: 440px;
  /* overflow: hidden; */
`;
const Wrapper = styled.div`
  display: flex;
  justify-content: center;
  align-items: center;
  z-index: 999;
`;
export default OptionPopup;
