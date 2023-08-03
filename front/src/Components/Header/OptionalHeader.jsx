import React from "react";
import { useLocation } from "react-router-dom";
import { css, styled } from "styled-components";
import Button from "../Button/Button";

const OptionalHeader = () => {
  return (
    <Wrapper>
      <NavContainer>
        <Nav>
          <NavTitle>1 트림</NavTitle>
          <NavDetail>Le Blanc(르블랑)</NavDetail>
        </Nav>
        <Nav>
          <NavTitle>2 색상</NavTitle>
          <NavDetail>어비스 블랙펄 / 퀄팅 천연(블랙)</NavDetail>
        </Nav>
        <Nav>
          <NavTitle>3 옵션</NavTitle>
          <NavDetail>컴포트2, 현대 스마트 센스 1, 주차보조</NavDetail>
        </Nav>
      </NavContainer>
      <BtnsContainer>
        <Button text="요금 상세" style={AmoutDetailBtnStyle} />
        <Button text="견적내기" style={EstimateBtnStyle} />
      </BtnsContainer>
    </Wrapper>
  );
};

const AmoutDetailBtnStyle = css`
  padding: 14px 20px;
  height: 40px;
  background-color: ${({ theme }) => theme.color.grey1000};
  border-radius: 4px;
  border: 1px solid #d9d9d9;
  color: ${({ theme }) => theme.color.grey400};
  ${({ theme }) => theme.font.Body4_Medium};
`;

const EstimateBtnStyle = css`
  width: 166px;
  height: 40px;
  background-color: ${({ theme }) => theme.color.primary_default};
  border-radius: 4px;
  border: 1px solid ${({ theme }) => theme.color.primary_default};
  color: ${({ theme }) => theme.color.grey1000};
  ${({ theme }) => theme.font.Body4_Medium}
`;

const NavDetail = styled.div`
  ${({ theme }) => theme.font.Body4_Regular};
  color: ${({ theme }) => theme.color.grey400};
`;
const NavTitle = styled.div`
  ${({ theme }) => theme.font.Body4_Medium};
  color: ${({ theme }) => theme.color.primary_default};
`;
const Nav = styled.div`
  display: flex;
  gap: 12px;
`;
const NavContainer = styled.div`
  display: flex;
  gap: 25px;
  align-items: flex-end;
`;
const OptionalHeaderWrapper = styled.div`
  display: flex;
  justify-content: space-between;
  padding: 10px 0px 16px;
`;
const BtnsContainer = styled.div`
  display: flex;
  gap: 8px;
`;
// const Button = styled.div`
//   width: 100px;
//   height: 50px;
//   background-color: ${({ theme }) => theme.color.primary_default};
// `;
export default OptionalHeader;
