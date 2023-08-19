import React from "react";
import { css, styled } from "styled-components";
import ColorOptionGroup from "@Components/Custom/ColorOptionGroup";
import Button from "@Components/Common/Button/Button";
import useButtonNavigation from "@hooks/useButtonNavigation";

const ColorCustomSideBar = ({ handleColorOption, data, curData }) => {
  const move = useButtonNavigation();

  const datas = data.filter((d) => d.id === 1);
  const [{ colors }] = datas;
  const exterData = colors.filter((data) => data.type === "EXTERIOR");
  const interData = colors.filter((data) => data.type === "INTERIOR");

  const datas2 = data.filter((d) => d.id !== 1);

  let exceptExter = [];
  let exceptInter = [];
  datas2.forEach((data) => {
    const { colors } = data;
    exceptExter.push(colors.filter((data) => data.type === "EXTERIOR"));
    exceptInter.push(colors.filter((data) => data.type === "INTERIOR"));
  });

  const { exterior, interior } = curData;

  return (
    <Wrapper>
      <CustomBarContent>
        <ColorOptionGroup
          option="외장"
          handleColorOption={handleColorOption}
          data={exterData}
          curData={exterior}
        />
        <Separator></Separator>
        <ColorOptionGroup
          option="내장"
          handleColorOption={handleColorOption}
          data={interData}
          curData={interior}
        />
        <BtnContainer>
          <Button
            text="트림 선택"
            style={TrimBtnStyle}
            onClick={() => move("/custom/trim")}
          />
          <Button
            text="옵션 선택"
            style={OptionBtnStyle}
            onClick={() => move("/custom/option")}
          />
        </BtnContainer>
      </CustomBarContent>
    </Wrapper>
  );
};

const BtnStyle = css`
  width: 150px;
  height: 52px;

  border-radius: 6px;
  ${({ theme }) => theme.font.Body3_Medium};
`;
const TrimBtnStyle = css`
  ${BtnStyle}
  color:${({ theme }) => theme.color.grey50};
  background-color: ${({ theme }) => theme.color.grey1000};
  border: 1px solid ${({ theme }) => theme.color.grey600};
`;
const OptionBtnStyle = css`
  ${BtnStyle}
  color:${({ theme }) => theme.color.grey1000};
  background-color: ${({ theme }) => theme.color.primary_default};
  border: 1px solid ${({ theme }) => theme.color.primary_default};
`;
const BtnContainer = styled.div`
  display: flex;
  gap: 8px;
  width: 100%;
  padding-bottom: 36px;
`;
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
  height: 100%;

  padding-top: 24px;
`;
export default ColorCustomSideBar;
