const HttpStatus = {
  OK: 200,
  BAD_REQUEST: 400,
  UNAUTHORIZED: 401,
  PAYMENT_REQUIRED: 402,
  FORBIDDEN: 403,
  NOT_FOUND: 404,
  NOT_ACCEPTABLE: 406,
  PROXY_AUTHENTICATION_REQUIRED: 407,
  PRECONDITION_FAILED: 412,
};
Object.freeze(HttpStatus);

export const handleHttpError = (error) => {
  switch (error) {
    case HttpStatus.UNAUTHORIZED:
      //alert("인증오류");
      break;
    case HttpStatus.BAD_REQUEST:
      //alert("전달 값 문제");
      break;
    case HttpStatus.NOT_FOUND:
      //alert("404");
      break;
    default:
      break;
  }
  throw Error(error.response.data || error.message);
};
