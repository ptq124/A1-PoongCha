import React, { useEffect } from "react";
import { styled, css } from "styled-components";
import useRadio from "../../../hooks/useRadio";
import Label from "./Label";

const RadioGroup = ({
  title,
  trigger,
  label,
  options,
  newStateHandler,
  initialState,
  style,
}) => {
  const { selectedItem, handleSelectItem } = useRadio(initialState);

  useEffect(() => {
    newStateHandler(selectedItem);
  }, [selectedItem]);

  return (
    <Form $style={style.wrapper}>
      <Title $style={style.title} trigger={trigger}>
        {title}
      </Title>
      <Radio $style={style.options}>
        {options?.map((option) => (
          <Label
            key={option.id}
            component={label}
            value={option}
            checked={option.id === selectedItem.id}
            handleSelectItem={handleSelectItem}
          />
        ))}
      </Radio>
    </Form>
  );
};

const Title = styled.div`
  ${({ $style }) => $style}
  ${({ trigger }) =>
    trigger &&
    css`
      display: none;
    `}
`;
const Radio = styled.div`
  ${({ $style }) => $style}
`;
const Form = styled.div`
  ${({ $style }) => $style}
`;

export default RadioGroup;
