import React from "react";
import { styled, css } from "styled-components";

const OptionTag = ({ selectedTag, tagsOption, handleSelectTag }) => {
  const [tags, tagSelectIcons, tagsNotSelectIcons] = tagsOption;

  const isTagIcons = (select, index) => {
    return select ? tagSelectIcons[index] : tagsNotSelectIcons[index];
  };
  return (
    <Wrapper>
      {tags?.map((tag, index) => (
        <Tag
          key={index}
          onClick={() => handleSelectTag(tag)}
          selected={selectedTag === tag}
        >
          <TagImg src={isTagIcons(selectedTag === tag, index)} />
          {tag}
        </Tag>
      ))}
    </Wrapper>
  );
};

const TagImg = styled.img`
  height: 22px;
`;

const Tag = styled.div`
  display: flex;
  align-items: center;

  border-radius: 4px;
  ${({ theme }) => theme.font.Body4_Regular};

  gap: 8px;
  padding: 7px 10px;
  cursor: pointer;
  box-sizing: border-box;

  ${({ selected }) =>
    selected
      ? css`
          color: ${({ theme }) => theme.color.primary_default};
          background: ${({ theme }) => theme.color.grey1000};
          border: 1.5px solid;
          border-color: ${({ theme }) => theme.color.primary_default};
        `
      : css`
          color: ${({ theme }) => theme.color.grey400};
          background: ${({ theme }) => theme.color.grey800};
          border: 1.5px solid;
          border-color: ${({ theme }) => theme.color.grey800};
        `};
`;

const Wrapper = styled.div`
  display: flex;
  gap: 8px;
  width: 100%;

  padding: 15px 0;

  border-bottom: 1.5px solid;
  border-bottom-color: ${({ theme }) => theme.color.grey700};
`;
export default OptionTag;
