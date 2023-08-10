import React from "react";
import { styled } from "styled-components";
import ColorOptionGroup from "../../../../Components/Custom/ColorOptionGroup";

const ColorCustomSideBar = () => {
  return (
    <Wrapper>
      <CustomBarContent>
        <ColorOptionGroup />
        <Separator></Separator>
        <ColorOptionGroup />
      </CustomBarContent>
    </Wrapper>
  );
};
const Separator = styled.div`
  height: 1px;
  width: 100%;
  background-color: ${({ theme }) => theme.color.grey700};
`;
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

  padding-top: 24px;
`;
export default ColorCustomSideBar;
