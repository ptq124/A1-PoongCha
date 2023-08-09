import React from "react";
import { css, styled } from "styled-components";
import Button from "../../Common/Button/Button";
import TrimOption from "../TrimOption";

const TrimOptionGroup = () => {
  return (
    <Wrapper>
      <Title>
        <span>트림</span>
        <Button text="비교하기" style={TrimComparisonBtnStyle} />
      </Title>

      <TrimOption />
      <TrimOption />
      <TrimOption />
      <TrimOption />
    </Wrapper>
  );
};

const TrimComparisonBtnStyle = css`
  background-color: ${({ theme }) => theme.color.grey1000};
  ${({ theme }) => theme.font.Extra17};

  border: 1px solid ${({ theme }) => theme.color.grey700};
  border-radius: 20px;

  padding: 4px 12px;
`;

const Title = styled.div`
  display: flex;
  justify-content: space-between;

  margin-top: 34px;

  span {
    ${({ theme }) => theme.font.Head2};
  }
`;
const Wrapper = styled.div``;
export default TrimOptionGroup;
