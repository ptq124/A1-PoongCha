import React, { useEffect, useState } from "react";
import { styled } from "styled-components";
import { options } from "../optionData";
import Card from "./Card";
import ArrowLeftIcon from "@assets/icons/arrow-left-32-white.svg";
import ArrowRightIcon from "@assets/icons/arrow-right-32-white.svg";

const OptionPopup = ({
  popupRef,
  closePopup,
  data,
  handleSelectOption,
  checkOptionSelected,
}) => {
  const [crntOptionIdx, setCrntOptionIdx] = useState(0);
  const [setData, setSetData] = useState([]);

  useEffect(() => {
    // data의 세트 옵션들 서버에서 불러오기
    if (data.set !== null) {
      setSetData(options.filter((option) => option.set === data.set));
    } else {
      setSetData([data]);
    }
  }, []);
  useEffect(() => {
    setCrntOptionIdx(setData.findIndex((elem) => elem.option === data.option));
  }, [setData]);

  return (
    <Wrapper ref={popupRef}>
      <Window>
        {crntOptionIdx > 0 && (
          <LeftArrow onClick={() => setCrntOptionIdx((prev) => prev - 1)}>
            <img src={ArrowLeftIcon} />
          </LeftArrow>
        )}

        <Cards $crntOptionIdx={crntOptionIdx}>
          {setData.map((data, index) => (
            <Card
              key={index}
              index={index}
              setData={setData}
              selected={checkOptionSelected(data.option)}
              closePopup={closePopup}
              handleNavClick={setCrntOptionIdx}
              handleSelectOption={() => handleSelectOption(data.option)}
            />
          ))}
        </Cards>
        {crntOptionIdx < setData.length - 1 && (
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
  overflow-x: clip;
`;
export default OptionPopup;
