import React from "react";
import { styled } from "styled-components";

const ColorOption = () => {
  let isLabeled = true;
  return (
    <Wrapper>
      <Preview>{isLabeled && <Label>Top 1</Label>}</Preview>
      <Name>어비스 블랙펄</Name>
    </Wrapper>
  );
};

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
  width: 68px;
  height: 112px;
  display: flex;
  flex-direction: column;
  gap: 8px;
  margin-bottom: 12px;
`;
export default ColorOption;
