const initialState = {
    drivingRecord: "1년 이하",
    familySize: "1인",
    purpose: "",
    viewpoint: "",
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

  export {initialState, reducer}