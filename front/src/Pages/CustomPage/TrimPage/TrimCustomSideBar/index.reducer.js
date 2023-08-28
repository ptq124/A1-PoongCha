const initialState = {
    "엔진": {
      "id": 1,
      "name": "디젤 2.2",
      "descriptionImageUrl": "https://my-car-store-resource.s3.ap-northeast-2.amazonaws.com/car_components/engine_diesel.jpg",
      "additionalPrice": 1480000
    },
    "바디": {
      "id": 3,
      "name": "7인승",
      "descriptionImageUrl": "https://my-car-store-resource.s3.ap-northeast-2.amazonaws.com/car_components/bodytype_7seats.jpg",
      "additionalPrice": 0
    },
    "구동방식": {
      "id": 5,
      "name": "2WD",
      "descriptionImageUrl": "https://my-car-store-resource.s3.ap-northeast-2.amazonaws.com/car_components/drivetrain_2wd.jpg",
      "additionalPrice": 0
    },
    trim:"Le Blanc",
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