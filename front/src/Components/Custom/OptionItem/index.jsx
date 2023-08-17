import React from "react";
import { styled, css } from "styled-components";
import checkBlue from "@assets/checkcircle/check-16-blue.svg";
import checkGrey from "@assets/checkcircle/check-16-grey.svg";
import Button from "@Components/Common/Button/Button";

const OptionItem = ({
  data,
  selected,
  handleSelectOption,
  handleOpenPopup,
}) => {
  const { id, option, description, price, img, tag } = data;
  return (
    <Wrapper>
      <img src={img} />
      <Header>
        <div>{option}</div>
        <div onClick={() => handleOpenPopup(data.option)}>더 알아보기</div>
      </Header>
      <Desc>{description}</Desc>
      <Price>{price}</Price>
      <Button
        text="선택"
        style={BtnStyle}
        selected={selected}
        img={<img src={selected ? checkGrey : checkBlue} />}
        onClick={() => handleSelectOption(id)}
      />
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

const Price = styled.div`
  ${({ theme }) => theme.font.Body3_Medium};
  color: ${({ theme }) => theme.color.gery100};

  margin-bottom: 12px;
`;

const Desc = styled.div`
  ${({ theme }) => theme.font.Body4_Regular};
  color: ${({ theme }) => theme.color.gery300};
  margin-bottom: 26px;

  width: 244px;
  overflow: hidden;
  text-overflow: ellipsis;
  white-space: nowrap;
`;

const Header = styled.div`
  display: flex;
  justify-content: space-between;

  div:nth-child(1) {
    color: ${({ theme }) => theme.color.gery0};
    ${({ theme }) => theme.font.Head4};

    width: 166px;
    overflow: hidden;
    text-overflow: ellipsis;
    white-space: nowrap;
  }
  div:nth-child(2) {
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
  height: 314px;

  > img {
    width: 100%;
  }

  margin-bottom: 40px;
`;

export default OptionItem;
