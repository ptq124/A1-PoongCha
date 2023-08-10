import React, { useState } from "react";
import { styled, css } from "styled-components";
import { useLocation } from "react-router";
import CarRotateViewer from "./CarRotateViewer";
import Button from "../../Common/Button/Button";

import rotate from "../../../assets/icons/rotate.svg";
import external from "../../../assets/icons/외장.svg";
import internal from "../../../assets/icons/내장.svg";
import degree360 from "../../../assets/icons/360.svg";

const CarView = () => {
  const { pathname } = useLocation();

  const CarMode = () => {
    if (pathname === "/custom/trim")
      return (
        <CarSideViewer
          src={`https://www.hyundai.com/contents/vr360/LX06/exterior/A2B/011.png`}
        />
      );
    else
      return (
        <>
          <CarRotateViewer />
          <Button
            style={ExternalBtn}
            text={isExternal && "외장"}
            img={<img src={external} />}
            $isHovered={isExternal}
            onMouseEnter={() => setExternalHover(true)}
            onMouseLeave={() => setExternalHover(false)}
          />
          <Button
            style={InternalBtn}
            text={isInternal && "내장"}
            img={<img src={internal} />}
            $isHovered={isInternal}
            onMouseEnter={() => setInternalHover(true)}
            onMouseLeave={() => setInternalHover(false)}
          />
          <Button style={RotateBtn} img={<img src={degree360} />} />
        </>
      );
  };

  const [isExternal, setExternalHover] = useState(false);
  const [isInternal, setInternalHover] = useState(false);

  return (
    <Wrapper>
      <BackgrondTop />
      <BackgrondBottom />
      <Button
        style={RecommendBtn}
        text="다시 추천받기"
        img={<img src={rotate} />}
      />
      {CarMode()}
    </Wrapper>
  );
};

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
