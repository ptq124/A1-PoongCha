import React from "react";
import { css, styled } from "styled-components";
import Button from "../../Common/Button/Button";

const Navigation = () => {
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
        <Button text="요금 상세" style={amoutDetailBtnStyle} />
        <Button text="견적내기" style={estimateBtnStyle} />
      </BtnsContainer>
    </Wrapper>
  );
};

const amoutDetailBtnStyle = css`
  height: 40px;

  background-color: ${({ theme }) => theme.color.grey1000};
  color: ${({ theme }) => theme.color.grey400};
  ${({ theme }) => theme.font.Body4_Medium};

  border-radius: 4px;
  border: 1px solid #d9d9d9;

  padding: 14px 20px;
`;

const estimateBtnStyle = css`
  width: 166px;
  height: 40px;

  background-color: ${({ theme }) => theme.color.primary_default};
  color: ${({ theme }) => theme.color.grey1000};
  ${({ theme }) => theme.font.Body4_Medium};

  border-radius: 4px;
  border: 1px solid ${({ theme }) => theme.color.primary_default};
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
  align-items: flex-end;

  gap: 25px;
`;

const Wrapper = styled.div`
  display: flex;
  justify-content: space-between;

  padding: 10px 128px 16px;
`;

const BtnsContainer = styled.div`
  display: flex;

  gap: 8px;
`;

export default Navigation;
