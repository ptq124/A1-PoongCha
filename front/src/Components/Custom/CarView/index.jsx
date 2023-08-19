import React, { useRef, useState } from "react";
import { styled, css } from "styled-components";
import { useLocation } from "react-router";
import CarRotateViewer from "./CarRotateViewer";
import Button from "@Components/Common/Button/Button";
import rotate from "@assets/icons/rotate.svg";
import external from "@assets/icons/외장.svg";
import internal from "@assets/icons/내장.svg";
import degree360 from "@assets/icons/360.svg";
import useOnClickPopUp from "@hooks/useOnClickPopUp";
import OverlaidPopup from "@Components/Common/OverlaidPopup";
import close from "@assets/icons/close.svg";
import useButtonNavigation from "@hooks/useButtonNavigation";
import internal001 from "@assets/images/internal001.svg";

const CarView = ({ data }) => {
  const { pathname } = useLocation();
  const CarMode = () => {
    if (pathname === "/custom/trim")
      return (
        <CarSideViewer
          src={`https://www.hyundai.com/contents/vr360/LX06/exterior/A2B/011.png`}
        />
      );
    else {
      const { exterior, interior } = data;
      return (
        <>
          {isExternalImg &&
            (!isCarViewer ? (
              <CarSideViewer src={[exterior].flat()[0].trimExteriorImageUrl} />
            ) : (
              <CarRotateViewer
                rotateImg={[exterior].flat()[0].trimRotationImageBaseUrl}
              />
            ))}
          {isInternalImg && (
            <InternalImg src={[interior].flat()[0].trimInteriorImageUrl} />
          )}

          <Button
            style={ExternalBtn}
            text={isExternal && "외장"}
            img={<img src={external} />}
            $isHovered={isExternal}
            onMouseEnter={() => setExternalHover(true)}
            onMouseLeave={() => setExternalHover(false)}
            onClick={handleExternalImg}
          />
          <Button
            style={InternalBtn}
            text={isInternal && "내장"}
            img={<img src={internal} />}
            $isHovered={isInternal}
            onMouseEnter={() => setInternalHover(true)}
            onMouseLeave={() => setInternalHover(false)}
            onClick={handleInternalImg}
          />
          {!isInternalImg && (
            <Button
              style={RotateBtn}
              img={<img src={degree360} onClick={() => setIsCarViewer(true)} />}
            />
          )}
        </>
      );
    }
  };

  const [isExternalImg, setIsExternalImg] = useState(true);
  const [isInternalImg, setIsInternalImg] = useState(false);
  const handleInternalImg = () => {
    setIsExternalImg(false);
    setIsInternalImg(true);
    setIsCarViewer(false);
  };
  const handleExternalImg = () => {
    setIsInternalImg(false);
    setIsExternalImg(true);
    setIsCarViewer(false);
  };
  const [isCarViewer, setIsCarViewer] = useState(false);

  const [isExternal, setExternalHover] = useState(false);
  const [isInternal, setInternalHover] = useState(false);

  const popupRef = useRef();
  const { isPopupOpen, openPopup, closePopup } = useOnClickPopUp(popupRef);

  const move = useButtonNavigation();
  return (
    <>
      <Wrapper>
        <BackgrondTop />
        <BackgrondBottom />
        <Button
          style={RecommendBtn}
          text="다시 추천받기"
          img={<img src={rotate} />}
          onClick={openPopup}
        />

        {CarMode()}
      </Wrapper>
      {isPopupOpen && (
        <OverlaidPopup
          component={
            <PopUp ref={popupRef}>
              <Container>
                <Title>추천페이지로 돌아가시겠어요?</Title>
                <SubTitle>선택한 옵션들은 모두 초기화돼요.</SubTitle>
              </Container>
              <BtnContainer>
                <Button text="아니요" style={LeftBtn} onClick={closePopup} />
                <Button
                  text="추천받기"
                  style={RightBtn}
                  onClick={() => {
                    closePopup();
                    move("/");
                  }}
                />
              </BtnContainer>
              <img src={close} onClick={closePopup} />
            </PopUp>
          }
        />
      )}
    </>
  );
};
const InternalImg = styled.img`
  position: absolute;
  width: 100%;
`;
const LeftBtn = css`
  width: 178px;
  height: 46px;
  background-color: ${({ theme }) => theme.color.grey1000};
  border: 1px solid;
  border-color: ${({ theme }) => theme.color.grey600};
  border-radius: 4px;
  color: ${({ theme }) => theme.color.grey50};
  ${({ theme }) => theme.font.Body3_Medium};
`;

const RightBtn = css`
  width: 178px;
  height: 46px;
  background-color: ${({ theme }) => theme.color.primary_default};
  border: 1px solid;
  border-color: ${({ theme }) => theme.color.primary_default};
  border-radius: 4px;
  color: ${({ theme }) => theme.color.grey1000};
  ${({ theme }) => theme.font.Body3_Medium};
`;

const BtnContainer = styled.div`
  display: flex;
  margin-top: 32px;
  margin-left: 32px;
  gap: 10px;
`;

const Container = styled.div`
  display: flex;
  flex-direction: column;
  margin-top: 24px;
  margin-left: 32px;
`;
const Title = styled.div`
  ${({ theme }) => theme.font.Head1};
`;
const SubTitle = styled.div`
  color: ${({ theme }) => theme.color.grey400};
  ${({ theme }) => theme.font.Body4_Regular};
  margin-top: 8px;
`;
const PopUp = styled.div`
  position: relative;

  width: 427px;
  height: 192px;

  border-radius: 12px;

  z-index: 999;
  background-color: ${({ theme }) => theme.color.grey1000};

  img {
    position: absolute;
    top: 24px;
    right: 24px;
  }
`;

const RotateBtn = css`
  position: absolute;

  height: 52px;
  width: 52px;

  top: 216px;
  left: 128px;

  border: 1px solid;
  border-color: ${({ theme }) => theme.color.grey1000};
  background: rgba(255, 255, 255, 0.8);
  backdrop-filter: blur(2px);
`;

const InternalBtn = css`
  position: absolute;

  height: 52px;
  width: ${({ $isHovered }) => ($isHovered ? "92px" : "52px")};
  color: ${({ $isHovered }) => ($isHovered ? "" : "transparent;")};

  transition: width 0.6s ease;
  transition: color 0.6s ease;

  gap: 16px;

  border: 1px solid;
  border-color: ${({ theme }) => theme.color.grey1000};
  background: rgba(255, 255, 255, 0.8);
  backdrop-filter: blur(2px);

  top: 156px;
  left: 128px;

  ${({ theme }) => theme.font.Caption1_Medium};

  img {
    width: 32px;
    height: 32px;
  }
`;

const ExternalBtn = css`
  position: absolute;

  height: 52px;
  width: ${({ $isHovered }) => ($isHovered ? "92px" : "52px")};
  color: ${({ $isHovered }) => ($isHovered ? "" : "transparent;")};

  transition: width 0.6s ease;
  transition: color 0.6s ease;

  gap: 16px;

  border: 1px solid;
  border-color: ${({ theme }) => theme.color.grey1000};
  background: rgba(255, 255, 255, 0.8);
  backdrop-filter: blur(2px);

  top: 96px;
  left: 128px;

  ${({ theme }) => theme.font.Caption1_Medium};

  img {
    width: 32px;
    height: 32px;
  }
`;

const RecommendBtn = css`
  position: absolute;

  width: 124px;
  height: 36px;
  flex-shrink: 0;

  gap: 4px;
  border-radius: 20px;
  border: 1px solid;
  border-color: ${({ theme }) => theme.color.grey1000};
  background: rgba(255, 255, 255, 0.8);
  backdrop-filter: blur(2px);

  top: 24px;
  left: 128px;

  color: ${({ theme }) => theme.color.secondary};
  ${({ theme }) => theme.font.Extra18};
  text-align: center;

  img {
    width: 16px;
    height: 16px;
  }
`;

const CarSideViewer = styled.img`
  position: absolute;
  top: 40%;
  left: 50%;
  transform: translate(-50%, -50%);
  width: 95%;
  margin-top: 20px;
`;

const BackgrondTop = styled.div`
  height: 50%;
  width: 100%;
  background: rgba(0, 66, 142, 0.1);
`;

const BackgrondBottom = styled.div`
  height: 50%;
  width: 100%;
  background: linear-gradient(
    180deg,
    rgba(0, 66, 142, 0.3) 0%,
    rgba(255, 255, 255, 0) 100%
  );
`;

const Wrapper = styled.div`
  flex: 0 0 auto;
  width: calc(100% - 473px);
  position: fixed;
  display: flex;
  flex-direction: column;

  height: 100%;

  left: 0;
`;

export default CarView;
