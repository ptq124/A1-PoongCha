import React from "react";
import { styled } from "styled-components";
import Check24Icon from "@assets/checkcircle/check-24-white.svg";

// const ColorOption = ({ option, selected, onClick, index, opt }) => {
//   let isLabeled = true;

//   const hasLabel = () => {
//     if (opt === "내장" && index === 0) return <Label>Best</Label>;
//     else if (opt === "외장" && index < 3) {
//       return <Label>Top {index + 1}</Label>;
//     }
//   };

//   return (
//     <Wrapper onClick={onClick}>
//       <Preview>
//         {isLabeled && hasLabel()}
//         <ColorImg src={option.imageUrl} />
//         {selected && (
//           <Cover>
//             <div></div>
//             <img src={Check24Icon} />
//           </Cover>
//         )}
//       </Preview>
//       <Name>{option.name}</Name>
//     </Wrapper>
//   );
// };
const ColorOption = ({ value, checked, handleSelectItem, index, opt }) => {
  let isLabeled = true;

  const hasLabel = () => {
    if (opt === "내장" && index === 0) return <Label>Best</Label>;
    else if (opt === "외장" && index < 3) {
      return <Label>Top {index + 1}</Label>;
    }
  };

  return (
    <Wrapper onClick={() => handleSelectItem(value)}>
      <Preview>
        {isLabeled && hasLabel()}
        <ColorImg src={value?.imageUrl} />
        {checked && (
          <Cover>
            <div></div>
            <img src={Check24Icon} />
          </Cover>
        )}
      </Preview>
      <Name>{value?.name}</Name>
    </Wrapper>
  );
};

const ColorImg = styled.img`
  width: 68px;
  height: 68px;
`;

const Cover = styled.div`
  position: absolute;
  display: flex;
  align-items: center;
  justify-content: center;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  div {
    background-color: ${({ theme }) => theme.color.primary_default};
    width: 100%;
    height: 100%;
    opacity: 0.4;
  }
  img {
    position: absolute;
  }
`;
const Label = styled.div`
  position: absolute;
  top: 0;
  left: 0;
  display: flex;
  justify-content: center;
  align-items: center;

  width: 40px;
  height: 20px;

  color: ${({ theme }) => theme.color.grey1000};
  background-color: ${({ theme }) => theme.color.grey300};
  ${({ theme }) => theme.font.Caption1_Medium};

  border-radius: 4px 0px;
`;
const Name = styled.div`
  color: ${({ theme }) => theme.color.grey100};
  ${({ theme }) => theme.font.Caption1_Regular};
`;
const Preview = styled.div`
  position: relative;
  width: 68px;
  height: 68px;

  background-color: beige;

  border-radius: 6px;

  overflow: hidden;
`;
const Wrapper = styled.div`
  position: relative;
  width: 68px;
  height: 112px;
  display: flex;
  flex-direction: column;
  gap: 8px;
  margin-bottom: 12px;
  overflow: hidden;
  &:hover {
    cursor: pointer;
  }
`;
export default ColorOption;
