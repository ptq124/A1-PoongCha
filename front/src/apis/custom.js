import { GET } from "@utils/fetch";

// GET car-type/1/color 색상 정보 가져오기
export const getColor = () => GET("car-type/1/color");

// GET car-type/1/component-group 엔진,바디,구동방식 가져오기
export const getTrim = () => GET("car-type/1/component-group");

// GET option-group 전체 옵션 가져오기
export const getOption = () => GET("option-group");
