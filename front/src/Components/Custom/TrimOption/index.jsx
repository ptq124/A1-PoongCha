import React from "react";
import { css, styled } from "styled-components";
import Check28BlueIcon from "../../../assets/checkcircle/check-28-blue.svg";
import Check28GreyIcon from "../../../assets/checkcircle/check-28-grey.svg";
import Button from "../../Common/Button/Button";

const TrimOption = ({ data, radioGroup, selected, handleOptionSelect }) => {
  return (
    <Wrapper>
      <TrimOptionUpper>
        <TrimInfo>
          <NameAndModelItem>
            <span className="trimName">{data.title}</span>
            <span className="modelItemSummary">디젤 2.2 • 7인승 • 2WD</span>
          </NameAndModelItem>
          <span className="comment">합리적인 당신을 위한</span>
          <span className="price">43,460,000원</span>
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
          <Button
            text="12인치 내비게이션"
            style={DefaultOptionBtnStyle}
          ></Button>
          <Button
            text="내비 기반 크루즈"
            style={DefaultOptionBtnStyle}
          ></Button>
          <Button
            text="세이프티 파워 윈도우"
            style={DefaultOptionBtnStyle}
          ></Button>
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
const DefaultOptionBtnStyle = css`
  flex-shrink: 0;

  color: ${({ theme }) => theme.color.secondary};
  background-color: ${({ theme }) => theme.color.grey1000};

  border: none;
  ${({ theme }) => theme.font.Body4_Regular};
  background: none;
  padding: 0;
  outline: 0;
  text-decoration: underline;
  text-underline-offset: 3px;

  margin-right: 12px;
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
