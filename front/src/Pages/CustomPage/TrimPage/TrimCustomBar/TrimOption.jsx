import React from "react";
import { css, styled } from "styled-components";
import Check24BlueIcon from "../../../../assets/checkcircle/check-24-blue.svg";
import Button from "../../../../Components/Common/Button/Button";

const TrimOption = () => {
  return (
    <Wrapper>
      <TrimOptionUpper>
        <TrimInfo>
          <NameAndModelItem>
            <span className="trimName">Exclusive</span>
            <span className="modelItemSummary">디젤 2.2 • 7인승 • 2WD</span>
          </NameAndModelItem>
          <span className="comment">합리적인 당신을 위한</span>
          <span className="price">43,460,000원</span>
        </TrimInfo>
        <img src={Check24BlueIcon} alt="check" />
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
      <Separator></Separator>
    </Wrapper>
  );
};

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
const Separator = styled.div`
  width: 100%;
  height: 1px;
  background-color: ${({ theme }) => theme.color.grey700};
  margin-top: 24px;
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
`;
export default TrimOption;
