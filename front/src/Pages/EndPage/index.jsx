import React, { useEffect } from "react";
import { css, styled } from "styled-components";
import Card from "./Card";
import Summary from "@Components/Common/Summary";
import Button from "@Components/Common/Button/Button";
import useButtonNavigation from "@hooks/useButtonNavigation";
import { useUserData } from "context/UserDataContext";
import { useOutletContext } from "react-router-dom";

const EndPage = () => {
  const move = useButtonNavigation();
  const { totalData, estimated, formatAndPost, 데이터초기화 } = useUserData();
  const [handleOptionSelect, state] = useOutletContext();

  useEffect(() => {
    데이터초기화(state.lifestyle.id);
  }, []);

  return (
    <Wrapper>
      <Card id={state.lifestyle.id} />
      <Summary data={totalData} estimated={estimated} />
      <ButtonContainer>
        <Button
          text="커스텀하기"
          style={CustomBtnStyle}
          onClick={() => move("/custom/trim")}
        />
        <Button
          text="빠른 견적내기"
          style={CompleteEstimateBtnStyle}
          onClick={() => formatAndPost()}
        />
      </ButtonContainer>
    </Wrapper>
  );
};

const CompleteEstimateBtnStyle = css`
  width: 298px;
  height: 52px;

  color: ${({ theme }) => theme.color.grey1000};
  background-color: ${({ theme }) => theme.color.primary_default};
  ${({ theme }) => theme.font.Body3_Medium};

  border: 1px solid ${({ theme }) => theme.color.primary_default};
  border-radius: 6px;
`;

const CustomBtnStyle = css`
  width: 298px;
  height: 52px;

  color: ${({ theme }) => theme.color.grey50};
  background-color: ${({ theme }) => theme.color.grey1000};
  ${({ theme }) => theme.font.Body3_Medium};

  border: 1px solid ${({ theme }) => theme.color.grey600};
  border-radius: 6px;
`;

const ButtonContainer = styled.div`
  display: flex;
  gap: 12px;

  width: 608px;

  margin-bottom: 36px;
`;

const Wrapper = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;

  width: 100%;
  height: 1238px;
`;

export default EndPage;
