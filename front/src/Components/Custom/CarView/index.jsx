import React, { useState } from "react";
import { styled, css } from "styled-components";
import { useLocation } from "react-router";
import CarRotateViewer from "./CarRotateViewer";
import Button from "@Components/Common/Button/Button";
import rotate from "@assets/icons/rotate.svg";
import external from "@assets/icons/외장.svg";
import internal from "@assets/icons/내장.svg";
import degree360 from "@assets/icons/360.svg";
import PopupProvider from "@Components/Common/PopupProvider";
import BackToSurveyPopup from "@Pages/CustomPage/TrimPage/BackToSurveyPopup";

const CarView = ({ data }) => {
  const { pathname } = useLocation();
  const CarMode = () => {
    if (pathname === "/custom/trim")
      return (
        <CarSideViewer
          src={`https://my-car-store-resource.s3.ap-northeast-2.amazonaws.com/rotation/abyss_exterior/image_011.webp`}
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
              $isCarViewer={isCarViewer}
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

  return (
    <>
      <Wrapper>
        <BackgrondTop />
        <BackgrondBottom />
        {CarMode()}
      </Wrapper>
      <PopupProvider label={<BackToSurveyPopup />}>
        <Button
          style={BackToSurveyBtnStyle}
          text="다시 추천받기"
          img={<img src={rotate} />}
        />
      </PopupProvider>
    </>
  );
};
const InternalImg = styled.img`
  position: absolute;
  width: 100%;
  height: 100%;
  object-fit: cover;
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

  ${({ $isCarViewer }) =>
    $isCarViewer &&
    css`
      background-color: #d8f3ff;
    `}
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

const BackToSurveyBtnStyle = css`
  position: fixed;

  width: 124px;
  height: 36px;
  flex-shrink: 0;

  gap: 4px;
  border-radius: 20px;
  border: 1px solid;
  border-color: ${({ theme }) => theme.color.grey1000};
  background: rgba(255, 255, 255, 0.8);
  backdrop-filter: blur(2px);

  top: 145px;
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
