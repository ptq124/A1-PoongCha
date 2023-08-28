import React, { Children, isValidElement, useEffect } from "react";
import { styled, css } from "styled-components";
import useRadio from "../../../hooks/useRadio";
import Label from "./Label";

const RadioGroupTitle = ({ children, style }) => {
  return <Title $style={style}>{children}</Title>;
};
const RadioGroupSubtitle = ({ children, style }) => {
  return <Subtitle $style={style}>{children}</Subtitle>;
};

const RadioGroupMain = ({
  children,
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

  const childrenArray = Children.toArray(children);
  const radioGroupTitle = childrenArray.find(
    (child) =>
      isValidElement(child) && child.type === (<RadioGroupTitle />).type
  );
  const radioGroupSubtitle = childrenArray.find(
    (child) =>
      isValidElement(child) && child.type === (<RadioGroupSubtitle />).type
  );

  return (
    <>
      {radioGroupTitle}
      {radioGroupSubtitle}
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
    </>
  );
};

export const RadioGroupComposition = Object.assign(RadioGroupMain, {
  Title: RadioGroupTitle,
  Subtitle: RadioGroupSubtitle,
});

const Subtitle = styled.div``;
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

export default RadioGroupComposition;
