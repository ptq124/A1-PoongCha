import React from "react";
import { css, styled } from "styled-components";

import SampleImg from "../../../../assets/images/option-popup-sample.svg";
import CloseIcon from "../../../../assets/icons/close.svg";
import Button from "../../../../Components/Common/Button/Button";
import checkBlue from "../../../../assets/checkcircle/check-16-blue.svg";
import checkGrey from "../../../../assets/checkcircle/check-16-grey.svg";

const Card = ({
  closePopup,
  index,
  popupData,
  handleNavClick,
  selected,
  handleSelectOption,
}) => {
  return (
    <CardContainer>
      <ImgContainer>
        <TagContainer>
          <Tag>#사용편의</Tag>
          <Tag>#주행안전</Tag>
          <Tag>#추위/더위</Tag>
        </TagContainer>
        <img src={SampleImg} />
      </ImgContainer>
      <DetailContainer>
        <img src={CloseIcon} onClick={closePopup} />
        <Header>
          <OptionInfo>
            <span className="setName">컴포트 2</span>
            <span className="optionName">후석 승객 알림</span>
            <span className="price">1,090,000 원</span>
          </OptionInfo>
          <Button
            text="선택"
            style={BtnStyle}
            selected={selected}
            onClick={handleSelectOption}
            img={<img src={selected ? checkGrey : checkBlue} />}
          />
        </Header>
        <Description>
          초음파 센서를 통해 뒷좌석에 남아있는 승객의 움직임을 감지하여
          운전자에게 경고함으로써 부주의에 의한 유아 또는 반려 동물 등의 방치
          사고를 예방하는 신기술입니다.
        </Description>
        {popupData.length !== 1 && (
          <>
            <SetOptionNavigation>
              {popupData.map((data, idx) => (
                <Nav
                  key={idx}
                  $selected={idx === index}
                  onClick={() => handleNavClick(idx)}
                >
                  {data}
                </Nav>
              ))}
            </SetOptionNavigation>
            <NavBullets>
              {popupData.map((data, idx) => (
                <Bullet key={idx} $selected={idx === index}></Bullet>
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
  display: flex;
  gap: 10px;
  margin-top: 14px;
`;
const Nav = styled.div`
  width: 50%;
  ${({ theme }) => theme.font.Body4_Regular};
  color: ${({ theme }) => theme.color.grey400};
  margin-bottom: 14px;
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
  display: flex;
  flex-wrap: wrap;
  width: 226px;
  margin-top: 44px;
`;
const Description = styled.div`
  ${({ theme }) => theme.font.Body4_Regular};
  color: ${({ theme }) => theme.color.grey200};
  margin-top: 20px;
`;
const SelectButton = styled.div`
  width: 69px;
  height: 28px;
  background-color: beige;
`;
const OptionInfo = styled.div`
  display: flex;
  flex-direction: column;
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
  gap: 56px;

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
