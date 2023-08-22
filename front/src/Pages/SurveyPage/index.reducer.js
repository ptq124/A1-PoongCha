const initialState = {
  1: "",
  lifestyle: "",
  2: "",
  3: "",
  4: "",
  5: "",
  maxBudget: 5100,
};

const reducer = (state, action) => {
  switch (action.type) {
    case "SELECT_OPTION":
      return { ...state, [action.questionKey]: action.option };
    default:
      return state;
  }
};

export { initialState, reducer };
