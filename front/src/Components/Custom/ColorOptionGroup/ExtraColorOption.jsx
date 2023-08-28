import React, { useState } from "react";
import { styled } from "styled-components";
import ColorOption from "./ColorOption";
import PopupProvider from "@Components/Common/PopupProvider";
import ColorChangePopup from "@Pages/CustomPage/ColorPage/ColorChangePopup";

const ExtraColorOption = ({ value, totalData }) => {
  const [trimName, setTrimName] = useState();
  const hasTrim = (totalData) => {
    let answer = "";
    totalData.forEach((d) => {
      const { id, colors } = d;
      const list = colors.filter((d1) => d1.name === value.name);
      if (list.length) {
        answer = isTrim(id);
      }
    });
    return answer;
  };

  const handleSelectExtraColor = (id) => {
    setTrimName(id);
  };

  return (
    <PopupProvider label={<ColorChangePopup name={trimName} />}>
      <Wrapper>
        <div className="trimName"> {hasTrim(totalData)}</div>
        <ColorOption
          value={value}
          handleSelectItem={() => handleSelectExtraColor(hasTrim(totalData))}
        />
      </Wrapper>
    </PopupProvider>
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
const Wrapper = styled.div`
  display: flex;
  flex-direction: column;
  gap: 4px;
  width: 68px;
  .trimName {
    ${({ theme }) => theme.font.Extra19};
    color: ${({ theme }) => theme.color.secondary};
  }
`;
export default ExtraColorOption;
