import React, { createContext, useContext, useEffect, useState } from "react";

const UserDataContext = createContext();

export const UserDataProvider = ({ children }) => {
  const [totalData, setTotalData] = useState({
    엔진: {
      id: 2,
      name: "가솔린 3.8",
      descriptionImageUrl:
        "https://my-car-store-resource.s3.ap-northeast-2.amazonaws.com/car_components/engine_gasoline.jpg",
      additionalPrice: 0,
    },
    바디: {
      id: 3,
      name: "7인승",
      descriptionImageUrl:
        "https://my-car-store-resource.s3.ap-northeast-2.amazonaws.com/car_components/bodytype_7seats.jpg",
      additionalPrice: 0,
    },
    구동방식: {
      id: 5,
      name: "2WD",
      descriptionImageUrl:
        "https://my-car-store-resource.s3.ap-northeast-2.amazonaws.com/car_components/drivetrain_2wd.jpg",
      additionalPrice: 0,
    },
    외장: {
      id: 2,
      name: "어비스블랙펄",
      imageUrl:
        "https://www.hyundai.com/contents/vr360/LX06/exterior/A2B/colorchip-exterior.png",
      type: "EXTERIOR",
      trimExteriorImageUrl:
        "https://www.hyundai.com/contents/vr360/LX06/exterior/A2B/010.png",
      trimRotationImageBaseUrl:
        "https://www.hyundai.com/contents/vr360/LX06/exterior/A2B/0",
      incompatibleColorIds: [6, 7],
    },
    내장: {
      id: 6,
      name: "퀄팅천연(블랙)",
      imageUrl:
        "https://www.hyundai.com/contents/vr360/LX06/interior/I49/colorchip-interior.png",
      type: "INTERIOR",
      trimInteriorImageUrl:
        "https://www.hyundai.com/contents/vr360/LX06/interior/I49/img-interior.png",
      incompatibleColorIds: [2, 3],
    },
    옵션: [],
  });

  const 유저데이터저장 = (key, data) => {
    if (key !== "옵션") {
      setTotalData((prev) => ({
        ...prev,
        [key]: data[0],
      }));
    } else {
      setTotalData((prev) => ({
        ...prev,
        [key]: data,
      }));
    }
  };

  const [estimated, setEstimated] = useState(43360000);
  useEffect(() => {
    setEstimated(renderEstimatedPrice(totalData));
  }, [totalData]);

  return (
    <UserDataContext.Provider value={{ totalData, 유저데이터저장, estimated }}>
      {children}
    </UserDataContext.Provider>
  );
};

export const useUserData = () => useContext(UserDataContext);

const renderEstimatedPrice = (totalData) => {
  let estimatedPrice =
    totalData.엔진.additionalPrice +
    totalData.바디.additionalPrice +
    totalData.구동방식.additionalPrice;
  totalData.옵션.map((option) => {
    estimatedPrice += option.additionalPrice;
  });
  // 트림 가격도 추가하기
  return estimatedPrice + 43360000;
};
