import React from "react";
import { styled } from "styled-components";
import TaggedPage from "../TaggedPage";

const AdditionalOption = () => {
  return (
    <Wrapper>
      <TaggedPage />
    </Wrapper>
  );
};

const Wrapper = styled.div`
  padding: 0px 128px;
`;
export default AdditionalOption;
