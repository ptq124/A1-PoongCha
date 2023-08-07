import React from "react";
import { styled } from "styled-components";
import Card from "./Card";

const EndPage = () => {
  return (
    <Wrapper>
      <Card />
    </Wrapper>
  );
};

const Wrapper = styled.div`
  width: 100%;
  height: 1238px;
`;

export default EndPage;
