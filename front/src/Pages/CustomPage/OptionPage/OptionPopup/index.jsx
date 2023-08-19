import React, { useState } from "react";
import { styled } from "styled-components";
import Card from "./Card";
import ArrowLeftIcon from "@assets/icons/arrow-left-32-white.svg";
import ArrowRightIcon from "@assets/icons/arrow-right-32-white.svg";

const OptionPopup = ({
  popupRef,
  closePopup,
  data,
  handleSelectOption,
  selected,
}) => {
  const [crntCardIdx, setCrntCardIdx] = useState(0);
  const { id, options } = data;

  return (
    <Wrapper ref={popupRef}>
      <Window>
        {crntCardIdx > 0 && (
          <LeftArrow onClick={() => setCrntCardIdx((prev) => prev - 1)}>
            <img src={ArrowLeftIcon} />
          </LeftArrow>
        )}

        <Cards $crntCardIdx={crntCardIdx}>
          {options.map((option, index) => (
            <Card
              key={index}
              data={data}
              cardData={option}
              selected={selected}
              closePopup={closePopup}
              handleNavClick={setCrntCardIdx}
              handleSelectOption={() => handleSelectOption(id)}
            />
          ))}
        </Cards>
        {crntCardIdx < data.options.length - 1 && (
          <RightArrow onClick={() => setCrntCardIdx((prev) => prev + 1)}>
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
  margin-left: -${({ $crntCardIdx }) => $crntCardIdx * 924}px;

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
