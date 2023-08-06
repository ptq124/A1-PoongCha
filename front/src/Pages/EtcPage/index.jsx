import React from "react";
import { styled } from "styled-components";
import QNASummary from "./QNASummary";

const EtcPage = () => {
  return (
    <Wrapper>
      <QNASummary />
    </Wrapper>
  );
};

const Wrapper = styled.div`
  width: 100%;
  display: flex;
  flex-direction: column;
  align-items: center;
`;
export default EtcPage;
