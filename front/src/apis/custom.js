import { GET, POST } from "@utils/fetch";

// GET car-type/1/trim 트림 정보 가져오기
export const getAllTrim = () => GET("car-type/1/trim");

export const getDefaultOption = (id) => GET(`option-group/${id}/tooltip`);

// GET car-type/1/color 색상 정보 가져오기
export const getColor = () => GET("car-type/1/color");

// GET car-type/1/component-group 엔진,바디,구동방식 가져오기
export const getComponent = () => GET("car-type/1/component-group");

// GET option-group 전체 옵션 가져오기
export const getOption = () => GET("option-group");

// POST /estimate 선택한 컴포넌트, 트림, 색상, 옵션 정보 보내기
export const postUserData = (data) => POST("estimate", data);

// GET estimate/resultId 최종 견적 페이지 데이터 가져오기
export const getEstimate = (id) => GET(`estimate/${id}`);

// GET Trim/id 트림정보 가져오기
export const getTrim = (id) => GET(`trim/${id}`);

