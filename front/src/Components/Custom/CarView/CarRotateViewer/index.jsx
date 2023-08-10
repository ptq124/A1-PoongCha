import React, { useEffect, useState } from "react";
import { styled, css } from "styled-components";
import { convertToTwoDigits } from "../../../../utils";

const CarRotateViewer = () => {
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
      if (event.screenX % 3 === 0) {
        setCurrentImage((prev) => (prev === 60 ? 1 : prev + 1));
        setXPosition(event.screenX);
      }
    } else {
      if (event.screenX % 3 === 0) {
        setCurrentImage((prev) => (prev === 1 ? 60 : prev - 1));
        setXPosition(event.screenX);
      }
    }
  };
  const handleMouseLeave = () => setIsClicked(false);

  // 첫 렌더링시 애니메이션 로직 구현
  const [isAnimate, setIsAnimate] = useState(true);
  useEffect(() => {
    if (currentImage <= 10 && isAnimate) {
      const interval = setInterval(() => {
        setCurrentImage((prev) => prev + 1);
      }, 50);
      return () => clearInterval(interval);
    }
    if (currentImage > 10) setIsAnimate(false);
  }, [currentImage, isAnimate]);

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
          src={`https://www.hyundai.com/contents/vr360/LX06/exterior/A2B/0${convertToTwoDigits(
            index
          )}.png`}
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
`;
const CarImage = styled.img`
  ${({ $isDisplay }) => {
    return css`
      display: ${$isDisplay ? "block" : "none"};
    `;
  }}
`;

export default CarRotateViewer;
