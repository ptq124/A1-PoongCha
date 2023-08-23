import React from "react";

const Label = ({
  component,
  value,
  selectedItem,
  handleSelectItem,
  checked,
}) => {
  return (
    <>
      {React.cloneElement(component, {
        value,
        selectedItem,
        handleSelectItem,
        checked,
      })}
    </>
  );
};

export default Label;
