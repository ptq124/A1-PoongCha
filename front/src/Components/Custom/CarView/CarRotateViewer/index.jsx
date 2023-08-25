import React, { useEffect, useState } from "react";
import { styled, css } from "styled-components";
import { convertToTwoDigits } from "@utils/index";

const CarRotateViewer = ({ rotateImg }) => {
  const imageArray = Array.from({ length: 60 }, (_, index) => ++index);

  const [isClicked, setIsClicked] = useState(false);
  const [xPosition, setXPosition] = useState(0);
  const [currentImage, setCurrentImage] = useState(1);

  const handleMouseDown = (event) => {
    event.preventDefault();
    setIsClicked(true);
    setXPosition(event.screenX);
  };
  const handleMouseOver = () => {
    setIsClicked(false);
    setXPosition(0);
  };
  const handleMouseMove = (event) => {
    if (!isClicked) return;

    event.preventDefault();

    if (xPosition > event.screenX) {
      if (event.screenX % 1 === 0) {
        setCurrentImage((prev) => (prev === 60 ? 1 : prev + 1));
        setXPosition(event.screenX);
      }
    } else {
      if (event.screenX % 1 === 0) {
        setCurrentImage((prev) => (prev === 1 ? 60 : prev - 1));
        setXPosition(event.screenX);
      }
    }
  };
  const handleMouseLeave = () => setIsClicked(false);

  // // 첫 렌더링시 애니메이션 로직 구현
  // const [isAnimate, setIsAnimate] = useState(true);
  // useEffect(() => {
  //   //11번시작 ~ 2번끝
  //   if (currentImage <= 5 && isAnimate) {
  //     const interval = setInterval(() => {
  //       setCurrentImage((prev) => prev + 1);
  //     }, 50);
  //     return () => clearInterval(interval);
  //   }
  //   if (currentImage > 5) setIsAnimate(false);
  // }, [currentImage, isAnimate]);

  return (
    <Wrapper
      onMouseDown={handleMouseDown}
      onMouseUp={handleMouseOver}
      onMouseMove={handleMouseMove}
      onMouseLeave={handleMouseLeave}
    >
      {imageArray.map((index) => (
        <CarImage
          key={index}
          $isDisplay={index === currentImage}
          src={`${rotateImg}` + `image_0${convertToTwoDigits(index)}.webp`}
          alt="360 VR"
        />
      ))}
    </Wrapper>
  );
};

const Wrapper = styled.div`
  position: absolute;
  top: 40%;
  left: 50%;
  transform: translate(-50%, -50%);
  width: 95%;
  margin-top: 20px;
`;
const CarImage = styled.img`
  ${({ $isDisplay }) => {
    return css`
      display: ${$isDisplay ? "block" : "none"};
    `;
  }}
  width:100%;
`;

export default CarRotateViewer;
