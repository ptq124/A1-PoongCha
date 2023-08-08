import React from "react";
import { Outlet } from "react-router";
import { styled } from "styled-components";

const CustomPage = () => {
  return (
    <Wrapper>
      <Outlet />
    </Wrapper>
  );
};

const Wrapper = styled.div``;
export default CustomPage;
