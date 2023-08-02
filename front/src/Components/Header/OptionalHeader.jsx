import React from "react";
import { useLocation } from "react-router-dom";
import { styled } from "styled-components";

const OptionalHeader = () => {
  return (
    <OptionalHeaderWrapper>
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
        <Button>버튼1</Button>
        <Button>버튼2</Button>
      </BtnsContainer>
    </OptionalHeaderWrapper>
  );
};

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
const Button = styled.div`
  width: 100px;
  height: 50px;
  background-color: ${({ theme }) => theme.color.primary_default};
`;
export default OptionalHeader;
