import main from "@assets/optionTag/Select/main.svg";
import all from "@assets/optionTag/Select/all.svg";
import safety from "@assets/optionTag/Select/safety.svg";
import convenience from "@assets/optionTag/Select/convenience.svg";
import temperature from "@assets/optionTag/Select/temperature.svg";
import parking from "@assets/optionTag/Select/parking.svg";
import performance from "@assets/optionTag/Select/performance.svg";
import style from "@assets/optionTag/Select/style.svg";
import Notmain from "@assets/optionTag/notSelect/main.svg";
import Notall from "@assets/optionTag/notSelect/all.svg";
import Notsafety from "@assets/optionTag/notSelect/safety.svg";
import Notconvenience from "@assets/optionTag/notSelect/convenience.svg";
import Nottemperature from "@assets/optionTag/notSelect/temperature.svg";
import Notparking from "@assets/optionTag/notSelect/parking.svg";
import Notperformance from "@assets/optionTag/notSelect/performance.svg";
import Notstyle from "@assets/optionTag/notSelect/style.svg";

// tags는 api가 나오면 뺄거
const tags = [
  "대표",
  "전체",
  "주행안전",
  "사용편의",
  "추위/더위",
  "주차/출차",
  "퍼포먼스",
  "스타일",
];
const tagSelectIcons = [
  main,
  all,
  safety,
  convenience,
  temperature,
  parking,
  performance,
  style,
];
const tagsNotSelectIcons = [
  Notmain,
  Notall,
  Notsafety,
  Notconvenience,
  Nottemperature,
  Notparking,
  Notperformance,
  Notstyle,
];

export { tags, tagSelectIcons, tagsNotSelectIcons };
