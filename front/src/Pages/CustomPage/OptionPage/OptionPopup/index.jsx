import React, { useEffect, useState } from "react";
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
          <LeftArrow onClick={() => setCrntOptionIdx((prev) => prev - 1)}>
            <img src={ArrowLeftIcon} />
          </LeftArrow>
        )}

        <Cards $crntOptionIdx={crntOptionIdx}>
          {popupData.map((data, index) => (
            <Card
              key={index}
              index={index}
              popupData={popupData}
              closePopup={closePopup}
              handleNavClick={setCrntOptionIdx}
              selected={false}
            />
          ))}
        </Cards>
        {crntOptionIdx < popupData.length - 1 && (
          <RightArrow onClick={() => setCrntOptionIdx((prev) => prev + 1)}>
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
  background: rgba(0, 0, 0, 0.3);
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
  margin-left: -${({ $crntOptionIdx }) => $crntOptionIdx * 924}px;

  transition: margin-left 0.3s ease;
`;

const Window = styled.div`
  position: relative;
  display: flex;
  align-items: center;
  width: 900px;
  height: 440px;
  z-index: 999;
`;
const Wrapper = styled.div`
  display: flex;
  justify-content: center;
  align-items: center;
  width: 100%;
`;
export default OptionPopup;
