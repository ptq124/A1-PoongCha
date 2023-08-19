import React, { useEffect, useState } from "react";
import { styled } from "styled-components";
import CarView from "@Components/Custom/CarView";
import ColorCustomSideBar from "./ColorCustomSIdeBar";
import { mockColordData } from "./mockColorData";
import { GET } from "@utils/fetch";

const ColorPage = () => {
  const [colorData, setColorData] = useState([]);

  // GET("http://3.34.166.253:8080/api/car-type/1/color").then((data) => {
  //   console.log("api: ", data);
  // });
  const data = mockColordData.filter((data) => data.id === 1);
  const [{ id, colors }] = data;
  const exterData = colors.filter((data) => data.type === "EXTERIOR");
  const interData = colors.filter((data) => data.type === "INTERIOR");

  const [exterior, setExterior] = useState(exterData[0]);
  const [interior, setInterior] = useState(interData[0]);

  const handleColorOption = (name, option) => {
    if (option === "외장") {
      const newExterior = exterData.filter((data) => data.name === name);
      setExterior(newExterior);
    } else {
      const newInterior = interData.filter((data) => data.name === name);
      setInterior(newInterior);
    }
  };

  useEffect(() => {
    setColorData(colors);
  }, []);

  if (colorData.length === 0) return;

  return (
    <Wrapper>
      <CarView data={{ exterior, interior }} />
      <ColorCustomSideBar
        data={mockColordData}
        curData={{ exterior, interior }}
        handleColorOption={handleColorOption}
      />
    </Wrapper>
  );
};
const Wrapper = styled.div`
  display: flex;
  width: 100%;
  height: 100%;
  justify-content: flex-end;

  padding-top: 121px;

  box-sizing: border-box;
`;

export default ColorPage;
