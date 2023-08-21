import React from "react";
import { styled, css } from "styled-components";
import checkBlue from "@assets/checkcircle/check-16-blue.svg";
import checkGrey from "@assets/checkcircle/check-16-grey.svg";
import Button from "@Components/Common/Button/Button";
import SampleImg from "@assets/images/optionItem_sample.svg";
import OptionPopup from "@Pages/CustomPage/OptionPage/OptionPopup";
import PopupProvider from "@Components/Common/PopupProvider";

const OptionItem = ({ data, selected, handleSelectOption }) => {
  const { id, name, summaryDescription, additionalPrice, options } = data;
  const isAdditionalOption = additionalPrice !== 0;

  return (
    <Wrapper>
      <Thumbnail>
        <img src={options[0].imageUrl || SampleImg} />
      </Thumbnail>
      <Header>
        <div className="optionName">{name}</div>
        <PopupProvider
          label={
            <OptionPopup
              data={data}
              handleSelectOption={handleSelectOption}
              selected={selected}
            />
          }
        >
          <div className="popupBtn">더 알아보기</div>
        </PopupProvider>
      </Header>

      {isAdditionalOption && (
        <>
          <Desc>{summaryDescription}</Desc>
          <Price>{additionalPrice.toLocaleString()}원</Price>
          <Button
            text="선택"
            style={BtnStyle}
            selected={selected}
            img={<img src={selected ? checkGrey : checkBlue} />}
            onClick={() => handleSelectOption(id)}
          />
        </>
      )}
    </Wrapper>
  );
};

const BtnStyle = css`
  width: 69px;
  height: 28px;

  border-radius: 20px;
  border: 1px solid;
  gap: 6px;
  ${({ theme }) => theme.font.Caption1_Medium};

  ${({ selected }) =>
    selected
      ? css`
          border-color: ${({ theme }) => theme.color.grey1000};
          background: ${({ theme }) => theme.color.primary_default};
          color: ${({ theme }) => theme.color.grey1000};
        `
      : css`
          border-color: ${({ theme }) => theme.color.primary_default};
          background: ${({ theme }) => theme.color.grey1000};
          color: ${({ theme }) => theme.color.primary_default};
        `};

  img {
    width: 16px;
    height: 16px;
  }
`;

const Thumbnail = styled.div`
  width: 244px;
  height: 162px;
  border-radius: 4px;
  overflow: hidden;

  & > img {
    width: 100%;
    height: 100%;
    object-fit: cover;
    overflow: hidden;
  }
`;
const Price = styled.div`
  ${({ theme }) => theme.font.Body3_Medium};
  color: ${({ theme }) => theme.color.gery100};

  margin-bottom: 12px;
`;

const Desc = styled.div`
  ${({ theme }) => theme.font.Body4_Regular};
  color: ${({ theme }) => theme.color.grey300};
  margin-bottom: 26px;

  width: 244px;
  height: 44px;
  overflow: hidden;
  white-space: wrap;
`;

const Header = styled.div`
  display: flex;
  justify-content: space-between;

  .optionName {
    color: ${({ theme }) => theme.color.grey0};
    ${({ theme }) => theme.font.Head4};

    width: 166px;
    overflow: hidden;
    text-overflow: ellipsis;
    white-space: nowrap;
  }
  .popupBtn {
    color: ${({ theme }) => theme.color.secondary};
    ${({ theme }) => theme.font.Body4_Regular};
    &:hover {
      cursor: pointer;
    }
  }
  margin-top: 12px;
  margin-bottom: 6px;
`;

const Wrapper = styled.div`
  width: 244px;

  & > img {
    width: 100%;
  }

  margin-bottom: 40px;
`;

export default OptionItem;
