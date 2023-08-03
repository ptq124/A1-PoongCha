import React, { useState } from "react";
import { styled } from "styled-components";

const Checkbox = ({ checkedImage, uncheckedImage, ...rest }) => {
  const [isChecked, setIsChecked] = useState(false);

  const handleCheckboxChange = () => {
    setIsChecked((prev) => !prev);
  };

  return (
    <CheckboxLabel>
      <CheckboxInput
        {...rest}
        checked={isChecked}
        onChange={handleCheckboxChange}
      />
      <CheckboxImg src={isChecked ? checkedImage : uncheckedImage} />
    </CheckboxLabel>
  );
};

const CheckboxInput = styled.input.attrs({ type: "checkbox" })`
  position: absolute;
  opacity: 0;
  cursor: pointer;
`;

const CheckboxLabel = styled.label`
  display: flex;
  align-items: center;
  user-select: none;
  cursor: pointer;
`;

const CheckboxImg = styled.img`
  cursor: pointer;
`;

export default Checkbox;
