import React from "react";
import { css, styled } from "styled-components";
import Check28BlueIcon from "../../../assets/checkcircle/check-28-blue.svg";
import Check28GreyIcon from "../../../assets/checkcircle/check-28-grey.svg";
import Button from "../../Common/Button/Button";
import DefaultOption from "../DefaultOption";

const TrimOption = ({ data, radioGroup, selected, handleOptionSelect }) => {
  return (
    <Wrapper>
      <TrimOptionUpper>
        <TrimInfo>
          <NameAndModelItem>
            <span className="trimName">{data.name}</span>
            <span className="modelItemSummary">디젤 2.2 • 7인승 • 2WD</span>
          </NameAndModelItem>
          <span className="comment">{data.information}</span>
          <span className="price">{data.minPrice.toLocaleString()}원</span>
        </TrimInfo>
        <CheckBtn>
          {selected ? (
            <img src={Check28BlueIcon} alt="checked" />
          ) : (
            <img src={Check28GreyIcon} alt="checked" />
          )}
          <Radio
            type="radio"
            name={radioGroup}
            onChange={handleOptionSelect}
          ></Radio>
        </CheckBtn>
      </TrimOptionUpper>

      <TrimDefaultOptions>
        <span className="defaultOptionTitle">기본 옵션</span>
        <DefaultOptions>
          {data.defaultOptions.map((option, index) => (
            <DefaultOption key={index} option={option} />
          ))}
        </DefaultOptions>
      </TrimDefaultOptions>
    </Wrapper>
  );
};

const CheckBtn = styled.label`
  &:hover {
    cursor: pointer;
  }
`;
const Radio = styled.input`
  display: none;
`;

const DefaultOptions = styled.div`
  display: flex;
  flex-wrap: wrap;
`;
const NameAndModelItem = styled.div`
  display: flex;
  align-items: center;
  gap: 8px;

  .trimName {
    color: ${({ theme }) => theme.color.grey300};
    ${({ theme }) => theme.font.Body4_Medium};
  }
  .modelItemSummary {
    color: ${({ theme }) => theme.color.grey500};
    ${({ theme }) => theme.font.Caption1_Regular};
  }
`;
const TrimInfo = styled.div`
  display: flex;
  flex-direction: column;
  .comment {
    ${({ theme }) => theme.font.Body3_Regular};
    margin-top: 4px;
  }
  .price {
    ${({ theme }) => theme.font.Head2};
    margin-top: 8px;
  }
`;
const TrimOptionUpper = styled.div`
  display: flex;
  justify-content: space-between;
  align-items: flex-start;
  width: 100%;
`;
const TrimDefaultOptions = styled.div`
  display: flex;
  align-items: flex-start;
  gap: 12px;

  margin-top: 14px;
  .defaultOptionTitle {
    display: flex;
    flex-shrink: 0;

    color: ${({ theme }) => theme.color.grey300};
    ${({ theme }) => theme.font.Body4_Medium};
  }
`;
const Wrapper = styled.div`
  display: flex;
  flex-direction: column;
  margin-top: 24px;
  padding-bottom: 24px;

  border-bottom: 1px solid ${({ theme }) => theme.color.grey700};
  &:last-child {
    border-bottom: none;
  }
`;
export default TrimOption;
