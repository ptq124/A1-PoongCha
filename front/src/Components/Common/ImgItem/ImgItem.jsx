import React from "react";
import { styled } from "styled-components";

const ImgItem = () => {
  return <Wrapper></Wrapper>;
};

const Wrapper = styled.div`
  background-color: beige;

  width: 60px;
  height: 60px;
`;

// const Wrapper = styled.img.attrs({
//   src: `${img}`,
// })`
//   width: 60px;
//   height: 60px;
// `;

export default ImgItem;
