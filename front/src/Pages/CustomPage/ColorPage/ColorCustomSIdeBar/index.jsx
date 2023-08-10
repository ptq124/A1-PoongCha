import React from "react";
import ColorOption from "../../../../Components/Custom/ColorOption";
import { styled } from "styled-components";

const ColorCustomSideBar = () => {
  return (
    <Wrapper>
      <CustomBarContent></CustomBarContent>
    </Wrapper>
  );
};
const CustomBarContent = styled.div`
  width: 309px;
  margin-right: 128px;

  box-sizing: border-box;
`;

const Wrapper = styled.div`
  display: flex;
  justify-content: flex-end;
  flex: 0 0 auto;
  width: 473px;
  height: 1292px;
`;
export default ColorCustomSideBar;
