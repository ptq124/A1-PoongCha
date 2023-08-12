import React, { useState } from "react";
import { styled } from "styled-components";
import OptionTag from "../../../../Components/Custom/OptionTag";
import { tags, tagSelectIcons, tagsNotSelectIcons } from "../tagIcon";

const AdditionalOption = () => {
  const tagsOption = [
    tags.slice(1),
    tagSelectIcons.slice(1),
    tagsNotSelectIcons.slice(1),
  ];

  const [selectTag, setSelectTag] = useState("전체");
  const handleSelectTag = (tag) => setSelectTag(tag);

  return (
    <Wrapper>
      <OptionTag
        selectTag={selectTag}
        tagsOption={tagsOption}
        handleSelectTag={handleSelectTag}
      ></OptionTag>
    </Wrapper>
  );
};

const Wrapper = styled.div`
  padding: 0px 128px;
`;
export default AdditionalOption;
