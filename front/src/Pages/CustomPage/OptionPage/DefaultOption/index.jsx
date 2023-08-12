import React, { useState } from "react";
import { styled } from "styled-components";
import OptionTag from "../../../../Components/Custom/OptionTag";
import { tags, tagSelectIcons, tagsNotSelectIcons } from "../tagIcon";

const DefaultOption = () => {
  const tagsOption = [tags, tagSelectIcons, tagsNotSelectIcons];
  const [selectTag, setSelectTag] = useState("대표");
  const handleSelectTag = (tag) => setSelectTag(tag);

  return (
    <Wrapper>
      <OptionTag
        selectTag={selectTag}
        tagsOption={tagsOption}
        handleSelectTag={handleSelectTag}
      />
    </Wrapper>
  );
};

const Wrapper = styled.div`
  padding: 0px 128px;
`;

export default DefaultOption;
