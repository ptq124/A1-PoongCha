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

const Wrapper = styled.div`
  display: flex;
  gap: 8px;
  width: 100%;

  padding: 15px 0;

  border-bottom: 1.5px solid;
  border-bottom-color: ${({ theme }) => theme.color.grey700};
`;
export default OptionTagGroup;
