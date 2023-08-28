import React, { useState } from "react";
import { css, styled } from "styled-components";
import Button from "@Components/Common/Button/Button";
import useButtonNavigation from "@hooks/useButtonNavigation";
import RadioGroup from "@Components/Common/RadioGroup";
import ColorOption from "@Components/Custom/ColorOptionGroup/ColorOption";
import ArrowDownIcon from "@assets/icons/24-chevron-down.svg";
import ArrowUpIcon from "@assets/icons/24-chevron-up.svg";
import ExtraColorOption from "@Components/Custom/ColorOptionGroup/ExtraColorOption";

const ColorCustomSideBar = ({ handleColorOption, data, curData }) => {
  const move = useButtonNavigation();

  const datas = data.filter((d) => d.id === 2);
  const [{ colors }] = datas;
  const exterData = colors.filter((data) => data.type === "EXTERIOR");
  const interData = colors.filter((data) => data.type === "INTERIOR");

  const datas2 = data.filter((d) => d.id !== 2);

  let exceptExter = [];
  let exceptInter = [];

  datas2.forEach((data) => {
    const { colors } = data;
    exceptExter.push(...colors.filter((data) => data.type === "EXTERIOR"));
    exceptInter.push(...colors.filter((data) => data.type === "INTERIOR"));
  });

  const { exterior, interior } = curData;
  const ExteriorRadioGroupTitle = () => {
    return (
      <>
        <span className="title">외장 색상</span>
        <div className="subtitle">
          <span className="color">{exterior.name}</span>
          <span className="stat">
            <strong>75%</strong>의 구매자가 선택한
          </span>
        </div>
      </>
    );
  };
  const InteriorRadioGroupTitle = () => {
    return (
      <>
        <span className="title">내장 색상</span>
        <div className="subtitle">
          <span className="color">{interior.name}</span>
          <span className="stat">
            <strong>75%</strong>의 구매자가 선택한
          </span>
        </div>
      </>
    );
  };
  const [isDropdown1Open, setIsDropdown1Open] = useState(false);
  const [isDropdown2Open, setIsDropdown2Open] = useState(false);

  const handleDropdown1Click = () => {
    setIsDropdown1Open(!isDropdown1Open);
  };
  const handleDropdown2Click = () => {
    setIsDropdown2Open(!isDropdown2Open);
  };
  return (
    <Wrapper>
      <CustomBarContent>
        <RadioGroup
          title={ExteriorRadioGroupTitle()}
          label={<ColorOption data={exterData} opt="외장" />}
          options={exterData}
          newStateHandler={(option) => handleColorOption(option, "외장")}
          initialState={exterior}
          style={ColorRadioGroupStyle}
        />
        <Dropdown>
          <DropdownTitle onClick={handleDropdown1Click}>
            <span>다른 외장 색상을 찾고 있나요?</span>
            {isDropdown1Open ? (
              <img src={ArrowUpIcon} />
            ) : (
              <img src={ArrowDownIcon} />
            )}
          </DropdownTitle>
          {isDropdown1Open && (
            <OptionsContainer>
              {exceptExter.map((item, index) => (
                <ExtraColorOption key={index} value={item} totalData={data} />
              ))}
            </OptionsContainer>
          )}
        </Dropdown>
        <Separator></Separator>
        <RadioGroup
          title={InteriorRadioGroupTitle()}
          label={<ColorOption data={interData} opt="내장" />}
          options={interData}
          newStateHandler={(option) => handleColorOption(option, "내장")}
          initialState={interior}
          style={ColorRadioGroupStyle}
        />
        <Dropdown>
          <DropdownTitle onClick={handleDropdown2Click}>
            <span>다른 내장 색상을 찾고 있나요?</span>
            {isDropdown2Open ? (
              <img src={ArrowUpIcon} />
            ) : (
              <img src={ArrowDownIcon} />
            )}
          </DropdownTitle>
          {isDropdown2Open && (
            <OptionsContainer>
              {exceptInter.map((item, index) => (
                <ExtraColorOption key={index} value={item} totalData={data} />
              ))}
            </OptionsContainer>
          )}
        </Dropdown>
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

const ColorRadioGroupStyle = {
  wrapper: css`
    display: flex;
    flex-direction: column;
  `,
  title: css`
    .title {
      ${({ theme }) => theme.font.Head2};
    }
    .subtitle {
      display: flex;
      justify-content: space-between;
      align-items: center;
      margin-top: 16px;
      margin-bottom: 12px;
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
    }
  `,
  options: css`
    display: flex;
    flex-wrap: wrap;
    gap: 12px;
  `,
};

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
  margin-top: 10px;
`;
const OptionsContainer = styled.div`
  display: flex;
  width: 100%;
  flex-wrap: wrap;
  margin-top: 12px;
  gap: 12px;
`;
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
  margin-top: 32px;
`;
const Separator = styled.div`
  height: 1px;
  width: 100%;
  background-color: ${({ theme }) => theme.color.grey700};
  margin-top: 32px;
  margin-bottom: 24px;
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
