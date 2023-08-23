import {GET} from "@utils/fetch";

// GET question/id 설문 질문지, 선택지 가져오기
export const getSurvey = (id) => GET("question/"+ id);