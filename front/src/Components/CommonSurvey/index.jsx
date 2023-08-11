import React from "react";
import { styled } from "styled-components";

const CommonSurvey = ({
  type,
  data,
  optionSelectHandler,
  labelComponent,
  buttonClickHandler,
}) => {
  return (
    <>
      <Header surveyType={type}></Header>
      <OptionGroup
        optionSelectHandler={optionSelectHandler}
        labelComponent={labelComponent}
        data={data}
      />
      <Button onClick={onClick} />
    </>
  );
};

const Header = styled.div``;
export default CommonSurvey;
