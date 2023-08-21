import React from "react";
import { css, styled } from "styled-components";
import SampleImg from "@assets/images/option-popup-sample.svg";
import CloseIcon from "@assets/icons/close.svg";
import Button from "@Components/Common/Button/Button";
import checkBlue from "@assets/checkcircle/check-16-blue.svg";
import checkGrey from "@assets/checkcircle/check-16-grey.svg";

const Card = ({
  data,
  cardData,
  selected,
  closePopup,
  handleNavClick,
  handleSelectOption,
}) => {
  const isSetOption = data.options.length > 1;
  const isAdditionalOption = data.additionalPrice !== 0;

  return (
    <CardContainer>
      <ImgContainer>
        <TagContainer>
          {data.tagNames.map((tag, index) => (
            <Tag key={index}>{tag}</Tag>
          ))}
        </TagContainer>
        <img src={cardData.imageUrl || SampleImg} />
      </ImgContainer>
      <DetailContainer>
        <img src={CloseIcon} onClick={closePopup} />
        <Header>
          <OptionInfo>
            {isSetOption && <span className="setName">{data.name}</span>}
            <span className="optionName">{cardData.name}</span>
            {isAdditionalOption && (
              <span className="price">
                {data.additionalPrice.toLocaleString()}원
              </span>
            )}
          </OptionInfo>
          {isAdditionalOption && (
            <Button
              text="선택"
              style={BtnStyle}
              selected={selected}
              onClick={handleSelectOption}
              img={<img src={selected ? checkGrey : checkBlue} />}
            />
          )}
        </Header>
        <Description>{cardData.detailDescription}</Description>
        {isSetOption && (
          <>
            <SetOptionNavigation>
              {data.options.map((option, index) => (
                <Nav
                  key={index}
                  $selected={option.id === cardData.id}
                  onClick={() => handleNavClick(index)}
                >
                  {option.name}
                </Nav>
              ))}
            </SetOptionNavigation>
            <NavBullets>
              {data.options.map((option, index) => (
                <Bullet
                  key={index}
                  $selected={option.id === cardData.id}
                  onClick={() => handleNavClick(index)}
                ></Bullet>
              ))}
            </NavBullets>
          </>
        )}
      </DetailContainer>
    </CardContainer>
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
const Bullet = styled.div`
  width: 8px;
  height: 8px;
  border-radius: 55px;
  background-color: ${({ theme }) => theme.color.grey700};
  ${({ $selected }) =>
    $selected &&
    css`
      background-color: ${({ theme }) => theme.color.secondary};
    `}
`;
const NavBullets = styled.div`
  position: absolute;
  bottom: 32px;
  display: flex;
  gap: 10px;
  margin-top: 14px;
  &:hover {
    cursor: pointer;
  }
`;
const Nav = styled.div`
  width: 100px;
  white-space: nowrap;
  overflow: hidden;
  text-overflow: ellipsis;
  ${({ theme }) => theme.font.Body4_Regular};
  color: ${({ theme }) => theme.color.grey400};
  margin-bottom: 14px;
  margin-right: 10px;
  &:hover {
    cursor: pointer;
  }
  ${({ $selected }) =>
    $selected &&
    css`
      color: ${({ theme }) => theme.color.secondary};
      ${({ theme }) => theme.font.Body4_Medium};
    `}
`;
const SetOptionNavigation = styled.div`
  position: absolute;
  bottom: 68px;
  display: flex;
  flex-wrap: wrap;
  width: 250px;
  margin-top: 44px;
`;
const Description = styled.div`
  ${({ theme }) => theme.font.Body4_Regular};
  color: ${({ theme }) => theme.color.grey200};
  margin-top: 20px;
  width: 286px;
  height: 90px;
  white-space: wrap;
  overflow: hidden;
  text-overflow: ellipsis;
`;
const OptionInfo = styled.div`
  display: flex;
  flex-direction: column;
  width: 200px;
  gap: 4px;
  .setName {
    ${({ theme }) => theme.font.Caption1_Medium};
    color: ${({ theme }) => theme.color.grey400};
  }
  .optionName {
    ${({ theme }) => theme.font.Head2};
  }
  .price {
    ${({ theme }) => theme.font.Body3_Medium};
    color: ${({ theme }) => theme.color.grey200};
  }
`;
const Header = styled.div`
  display: flex;
  justify-content: space-between;
  align-items: flex-end;
  /* gap: 70px; */

  margin-top: 50px;
`;
const DetailContainer = styled.div`
  position: relative;
  width: 344px;
  padding: 0px 28px;
  box-sizing: border-box;
  & > img {
    position: absolute;
    top: 24px;
    right: 24px;
    &:hover {
      cursor: pointer;
    }
  }
`;
const Tag = styled.div`
  ${({ theme }) => theme.font.Caption1_Regular};
  color: ${({ theme }) => theme.color.grey1000};
  background-color: ${({ theme }) => theme.color.grey200};
  padding: 6px 10px;
  border-radius: 100px;
  box-sizing: border-box;
`;
const TagContainer = styled.div`
  position: absolute;
  top: 24px;
  left: 24px;

  display: flex;
  gap: 8px;
`;
const ImgContainer = styled.div`
  position: relative;
  width: 556px;
  height: 440px;
  img {
    height: 100%;
    width: 100%;
    object-fit: cover;
  }
`;
const CardContainer = styled.div`
  display: flex;
  flex-shrink: 0;
  width: 900px;
  height: 440px;
  background-color: ${({ theme }) => theme.color.grey1000};
  border-radius: 12px;
  overflow: hidden;
`;

export default Card;
