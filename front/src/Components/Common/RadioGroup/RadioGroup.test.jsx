import React, { useState } from "react";
import RadioGroup from ".";
import { fireEvent, render, screen } from "@testing-library/react";

describe("<RadioGroup />", () => {
  const options = [
    { id: 1, value: "Option 1" },
    { id: 2, value: "Option 2" },
    { id: 3, value: "Option 3" },
  ];
  const Component = ({ option }) => {
    return <pre>{option.value}</pre>;
  };

  it("렌더링 테스트", () => {
    const newStateHandler = jest.fn();

    const { container } = render(
      <RadioGroup
        title="age"
        label={<Component />}
        options={options}
        newStateHandler={newStateHandler}
      />
    );

    expect(container).toBeInTheDocument();
    expect(screen.queryByText("age")).toBeInTheDocument();
    options.forEach((option) => {
      expect(screen.queryByText(option.value)).toBeInTheDocument();
    });
  });

  it("아이템 선택 테스트", () => {
    const newStateHandler = jest.fn();

    render(
      <RadioGroup
        title="age"
        label={<Component />}
        options={options}
        newStateHandler={newStateHandler}
      />
    );
    fireEvent.click(screen.getByText(options[0].value));

    expect(newStateHandler).toHaveBeenCalledTimes(1);
  });
});
