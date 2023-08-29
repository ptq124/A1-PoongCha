import React, { useRef, useState } from "react";
import { styled } from "styled-components";
import ColorOption from "./ColorOption";
import ArrowDownIcon from "@assets/icons/24-chevron-down.svg";
import ArrowUpIcon from "@assets/icons/24-chevron-up.svg";
import OverlaidPopup from "@Components/Common/PopupProvider/OverlaidPopup";
import ColorChangePopup from "@Pages/CustomPage/ColorPage/ColorChangePopup";
import useOnClickPopUp from "@hooks/useOnClickPopUp";

const ColorOptionGroup = ({
  option,
  handleColorOption,
  data,
  curData,
  exceptColor,
  totalData,
}) => {
  const [isDropdownOpen, setIsDropdownOpen] = useState(false);
  const popupRef = useRef();
  const { isPopupOpen, openPopup, closePopup } = useOnClickPopUp(popupRef);
  const [selectedColor, setSelectedColor] = useState(curData.name);
  // const mockRate = Array.from({ length: data.length }, () =>
  //   Math.floor(Math.random() * 80)
  // ).sort((a, b) => b - a);
  const mockRate = [74, 60, 40, 35, 20, 5];
  const [count, setCount] = useState(0);

  const handleColor = (name, option) => {
    setCount(data.findIndex((d) => d.name === name));
    setSelectedColor(data.filter((d) => d.name === name)[0].name);
    handleColorOption(name, option);
  };

  const handleDropdownClick = () => {
    setIsDropdownOpen(!isDropdownOpen);
  };

  const handleSelectExtraColor = (id) => {
    setTrimName(id);
    openPopup();
  };

  const [trimName, setTrimName] = useState();

  const hasTrim = (totalData, data) => {
    let answer = "";
    totalData.forEach((d) => {
      const { id, colors } = d;
      const list = colors.filter((d1) => d1.name === data.name);
      if (list.length) {
        answer = isTrim(id);
      }
    });
    return answer;
  };

  return (
    <Wrapper>
      {isPopupOpen && (
        <OverlaidPopup
          component={
            <ColorChangePopup
              popupRef={popupRef}
              closePopup={closePopup}
              name={trimName}
            />
          }
        />
      )}
      <Header>{option} 색상</Header>
      <Subtitle>
        <span className="color">{selectedColor}</span>
        <span className="stat">
          <strong>{mockRate[count]}% </strong>의 구매자가 선택한
        </span>
      </Subtitle>
      <OptionsContainer>
        {data.map((data, index) => (
          <ColorOption
            key={index}
            option={data}
            selected={selectedColor === data.name}
            onClick={() => handleColor(data.name, option)}
            index={index}
            opt={option}
          />
        ))}
      </OptionsContainer>
      <Dropdown>
        <DropdownTitle onClick={handleDropdownClick}>
          <span>다른 {option} 색상을 찾고 있나요?</span>
          {isDropdownOpen ? (
            <img src={ArrowUpIcon} />
          ) : (
            <img src={ArrowDownIcon} />
          )}
        </DropdownTitle>
        {isDropdownOpen && (
          <OptionsContainer>
            {exceptColor.map((data, index) => (
              <ExtraColorOption key={index}>
                <div className="trimName"> {hasTrim(totalData, data)}</div>
                <ColorOption
                  option={data}
                  onClick={() =>
                    handleSelectExtraColor(hasTrim(totalData, data))
                  }
                />
              </ExtraColorOption>
            ))}
          </OptionsContainer>
        )}
      </Dropdown>
    </Wrapper>
  );
};

const isTrim = (id) => {
  let answer = "";
  switch (id) {
    case 1:
      answer = "Exclusive";
      break;
    case 2:
      answer = "Le Blanc";
      break;
    case 3:
      answer = "Prestige";
      break;
    case 4:
      answer = "Caligraphy";
      break;
  }
  return answer;
};

const ExtraColorOption = styled.div`
  display: flex;
  flex-direction: column;
  gap: 4px;
  width: 68px;
  .trimName {
    ${({ theme }) => theme.font.Extra19};
    color: ${({ theme }) => theme.color.secondary};
  }
`;
const DropdownTitle = styled.div`
  display: flex;
  justify-content: space-between;
  &:hover {
    cursor: pointer;
  }
  span {
    color: ${({ theme }) => theme.color.primary_default};
    ${({ theme }) => theme.font.Body4_Medium};
  }
`;
const Dropdown = styled.div`
  width: 308px;
  border-radius: 4px;
  border: 1px solid ${({ theme }) => theme.color.primary_default};
  padding: 11px 16px;
  box-sizing: border-box;
`;
const OptionsContainer = styled.div`
  display: flex;
  width: 100%;
  flex-wrap: wrap;
  margin-top: 12px;
  gap: 12px;
`;
const Subtitle = styled.div`
  display: flex;
  justify-content: space-between;
  align-items: center;

  .color {
    color: ${({ theme }) => theme.color.grey100};
    ${({ theme }) => theme.font.Body4_Medium};
  }
  .stat {
    color: ${({ theme }) => theme.color.grey300};
    ${({ theme }) => theme.font.Caption1_Medium};
    strong {
      color: ${({ theme }) => theme.color.secondary};
    }
  }
  margin-top: 16px;
`;
const Header = styled.div`
  ${({ theme }) => theme.font.Head2};
`;
const Wrapper = styled.div`
  display: flex;
  flex-direction: column;
  margin-top: 24px;
  margin-bottom: 32px;
`;
export default ColorOptionGroup;
