import React from "react";
import { styled, css } from "styled-components";
import OptionTagLabel from "../OptionTagLabel";

const OptionTagGroup = ({ tags, selectedTag, handleSelectTag }) => {
  return (
    <Wrapper>
      {tags?.map((tag, index) => (
        <OptionTagLabel
          key={index}
          tag={tag}
          selectedTag={selectedTag}
          handleSelectTag={handleSelectTag}
        />
      ))}
    </Wrapper>
  );
};

const Separator = styled.div`
  width: 100%;
  height: 1.5px;
  background-color: ${({ theme }) => theme.color.grey700};
`;
const Wrapper = styled.div`
  display: flex;
  gap: 8px;
  /* width: 100%; */

  padding-bottom: 18px;
  margin: 15px 128px;

  border-bottom: 1.5px solid;
  border-bottom-color: ${({ theme }) => theme.color.grey700};
`;
export default OptionTagGroup;
