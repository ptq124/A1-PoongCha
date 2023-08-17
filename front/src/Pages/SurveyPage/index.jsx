import React, { useReducer } from "react";
import { styled } from "styled-components";
import { Outlet } from "react-router-dom";
import { initialState, reducer } from "./index.reducer";

const SurveyPage = () => {
  const [state, dispatch] = useReducer(reducer, initialState);
  const handleOptionSelect = (questionKey, option) => {
    dispatch({
      type: "SELECT_OPTION",
      questionKey,
      option,
    });
  };

  return (
    <Wrapper>
      <Outlet context={[handleOptionSelect, state]} />
    </Wrapper>
  );
};

const Wrapper = styled.div`
  width: 100%;
  display: flex;
  flex-direction: column;
  align-items: center;
`;
export default SurveyPage;
