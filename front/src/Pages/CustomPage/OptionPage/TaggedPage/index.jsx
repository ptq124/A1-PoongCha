import React from "react";
import { styled } from "styled-components";
import TaggedPageSampleImg from "../../../../assets/images/tagged-page-sample.svg";
import PlusIcon from "../../../../assets/icons/plus.svg";

const data = [
  {
    title: "option1",
    position: { x: 23, y: 35 },
  },
  {
    title: "option2",
    position: { x: 20, y: 80 },
  },
  {
    title: "option3",
    position: { x: 50, y: 3 },
  },
  {
    title: "option4",
    position: { x: 65, y: 85 },
  },
];
const TaggedPage = () => {
  return (
    <Wrapper>
      <SituationScreen>
        <img src={TaggedPageSampleImg} />
        {data.map((data, index) => (
          <PlusButton key={index} $position={data.position}>
            <img src={PlusIcon} />
          </PlusButton>
        ))}
      </SituationScreen>
      <OptionItemsContainer>
        {data.map((data, index) => (
          // 옵션 컴포넌트 들어갈 자리
          <div key={index}></div>
        ))}
      </OptionItemsContainer>
    </Wrapper>
  );
};

const PlusButton = styled.div`
  position: absolute;
  top: ${({ $position }) => $position.y}%;
  left: ${({ $position }) => $position.x}%;

  display: flex;
  align-items: center;
  justify-content: center;

  width: 28px;
  height: 28px;

  background-color: #acb8c8;

  border-radius: 55px;
  opacity: 0.8;

  &:hover {
    background-color: ${({ theme }) => theme.color.secondary};
    cursor: pointer;
  }
  img {
    width: 18px;
    height: 18px;
  }
`;
const SituationScreen = styled.div`
  position: relative;
`;
const OptionItemsContainer = styled.div`
  display: flex;
  gap: 16px;
  width: 100%;
  margin-top: 40px;
  div {
    width: 244px;
    height: 314px;
    background-color: beige;
  }
`;
const Wrapper = styled.div`
  display: flex;
  flex-direction: column;
  padding-top: 24px;
  width: 100%;
  img {
    width: 100%;
  }
`;
export default TaggedPage;
