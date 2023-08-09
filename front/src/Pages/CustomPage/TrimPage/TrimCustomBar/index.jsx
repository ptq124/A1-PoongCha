import React, { useReducer } from "react";
import { css, styled } from "styled-components";
import Button from "../../../../Components/Common/Button/Button";
import { initialState, reducer } from "./index.reducer";
import TrimOptionGroup from "../../../../Components/Custom/TrimOptionGroup";
import ModelItemOptionGroup from "../../../../Components/Custom/ModelItemOptionGroup";

const modelItemData = {
  engine: {
    title: "엔진",
    options: ["디젤 2.2", "가솔린 3.8"],
  },
  body: {
    title: "바디",
    options: ["7인승", "8인승"],
  },
  drivetrain: {
    title: "구동방식",
    options: ["2WD", "4WD"],
  },
};

const TrimCustomBar = () => {
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
      <Button text="고르기 어렵다면?" style={LinkBtnStyle}></Button>
      <ModelItems>
        {Object.entries(modelItemData).map(([questionKey, data]) => (
          <ModelItemOptionGroup
            key={questionKey}
            data={data}
            handleOptionSelect={(newValue) => {
              handleOptionSelect(questionKey, newValue);
            }}
            radioGroup={questionKey}
            selectedOption={state[questionKey]}
          />
        ))}
      </ModelItems>

      <TrimOptionGroup />
    </Wrapper>
  );
};

const ModelItems = styled.div`
  display: flex;
  flex-direction: column;
  gap: 12px;

  border: 1px solid ${({ theme }) => theme.color.grey700};
  border-radius: 8px;

  padding: 12px;
  margin-top: 16px;
`;
const LinkBtnStyle = css`
  color: ${({ theme }) => theme.color.secondary};
  background-color: ${({ theme }) => theme.color.grey1000};

  border: none;
  ${({ theme }) => theme.font.Extra4};
  background: none;
  padding: 0;
  outline: 0;
  text-decoration: underline;
  text-underline-offset: 3px;

  margin-top: 56px;
`;

const Wrapper = styled.div`
  width: 473px;

  padding-left: 36px;
  padding-right: 128px;

  box-sizing: border-box;
`;
export default TrimCustomBar;
