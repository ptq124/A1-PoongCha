import ActiveMain from "@assets/optionTag/Select/main.svg";
import ActiveAll from "@assets/optionTag/Select/all.svg";
import ActiveSafety from "@assets/optionTag/Select/safety.svg";
import ActiveConvenience from "@assets/optionTag/Select/convenience.svg";
import ActiveTemperature from "@assets/optionTag/Select/temperature.svg";
import ActiveParking from "@assets/optionTag/Select/parking.svg";
import ActivePerformance from "@assets/optionTag/Select/performance.svg";
import ActiveStyle from "@assets/optionTag/Select/style.svg";
import InactiveMain from "@assets/optionTag/notSelect/main.svg";
import InactiveAll from "@assets/optionTag/notSelect/all.svg";
import InactiveSafety from "@assets/optionTag/notSelect/safety.svg";
import InactiveConvenience from "@assets/optionTag/notSelect/convenience.svg";
import InactiveTemperature from "@assets/optionTag/notSelect/temperature.svg";
import InactiveParking from "@assets/optionTag/notSelect/parking.svg";
import InactivePerformance from "@assets/optionTag/notSelect/performance.svg";
import InactiveStyle from "@assets/optionTag/notSelect/style.svg";

// tags는 api가 나오면 뺄거
const tagData = [
  {
    id:1,
    name:"대표",
    activeIcon:ActiveMain,
    inactiveIcon:InactiveMain,
    situationImageUrl:""
  },
  {
    id:2,
    name:"전체",
    activeIcon:ActiveAll,
    inactiveIcon:InactiveAll,
    situationImageUrl:""
  },
  {
    id:3,
    name:"주행안전",
    activeIcon:ActiveSafety,
    inactiveIcon:InactiveSafety,
    situationImageUrl:"https://my-car-store-resource.s3.ap-northeast-2.amazonaws.com/car_option_tags/safety_situation.jpg"
  },
  {
    id:4,
    name:"사용편의",
    activeIcon:ActiveConvenience,
    inactiveIcon:InactiveConvenience,
    situationImageUrl:"https://my-car-store-resource.s3.ap-northeast-2.amazonaws.com/car_option_tags/convenience_situation.jpg"
  },
  {
    id:5,
    name:"추위/더위",
    activeIcon:ActiveTemperature,
    inactiveIcon:InactiveTemperature,
    situationImageUrl:"https://my-car-store-resource.s3.ap-northeast-2.amazonaws.com/car_option_tags/temperature_situation.jpg"
  },
  {
    id:6,
    name:"주차/출차",
    activeIcon:ActiveParking,
    inactiveIcon:InactiveParking,
    situationImageUrl:"https://my-car-store-resource.s3.ap-northeast-2.amazonaws.com/car_option_tags/parking_situation.jpg"
  },
  {
    id:7,
    name:"퍼포먼스",
    activeIcon:ActivePerformance,
    inactiveIcon:InactivePerformance,
    situationImageUrl:"https://my-car-store-resource.s3.ap-northeast-2.amazonaws.com/car_option_tags/performance_situation.jpg"
  },
  {
    id:8,
    name:"스타일",
    activeIcon:ActiveStyle,
    inactiveIcon:InactiveStyle,
    situationImageUrl:"https://my-car-store-resource.s3.ap-northeast-2.amazonaws.com/car_option_tags/style_situation.jpg"
  },
];
export { tagData };
