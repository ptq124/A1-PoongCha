const initialState = {
    engine: "디젤 2.2",
    body: "7인승",
    drivetrain: "2WD",
    trim:"Exclusive",
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