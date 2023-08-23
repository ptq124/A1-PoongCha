import React, { useEffect, useState } from "react";
import { styled } from "styled-components";
import CarView from "@Components/Custom/CarView";
import ColorCustomSideBar from "./ColorCustomSIdeBar";
import { getColor } from "apis/custom";
import { useUserData } from "context/UserDataContext";

const ColorPage = () => {
  const [colorData, setColorData] = useState([]);
  const { totalData, 유저데이터저장 } = useUserData();
  const [exterior, setExterior] = useState(totalData["외장"]);
  const [interior, setInterior] = useState(totalData["내장"]);

  useEffect(() => {
    getColor().then((data) => {
      setColorData(data);
    });
  }, []);
  if (!colorData.length) return null;

  const data = colorData.filter((data) => data.id === 1);
  const [{ id, colors }] = data;

  const exterData = colors.filter((data) => data.type === "EXTERIOR");
  const interData = colors.filter((data) => data.type === "INTERIOR");

  const handleColorOption = (name, option) => {
    if (option === "외장") {
      const newExterior = exterData.find((data) => data.name === name);
      유저데이터저장(option, newExterior);
      setExterior(newExterior);
    } else {
      const newInterior = interData.find((data) => data.name === name);
      유저데이터저장(option, newInterior);
      setInterior(newInterior);
    }
  };

  return (
    <Wrapper>
      <CarView data={{ exterior, interior }} />
      <ColorCustomSideBar
        data={colorData}
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
