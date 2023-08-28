import React from "react";
import Button from "./Button";
import { fireEvent, render, screen } from "@testing-library/react";

describe("<Button />", () => {
  it("컴포넌트 렌더링 테스트", () => {
    render(<Button />);
    const button = screen.getByRole("button");
    expect(button).toBeInTheDocument();
  });

  it("클릭 테스트", () => {
    const onClickMock = jest.fn();

    render(<Button onClick={onClickMock} />);

    const button = screen.getByRole("button");
    fireEvent.click(button);

    expect(onClickMock).toHaveBeenCalledTimes(1);
  });
});
