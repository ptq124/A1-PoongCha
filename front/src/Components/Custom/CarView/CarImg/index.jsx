import React, { useState } from "react";
import { styled, css } from "styled-components";
import { convertToTwoDigits } from "../../../../utils";

const CarImg = () => {
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
export default CarImg;

// https://www.hyundai.com/contents/vr360/LX06/exterior/A2B/002.png
