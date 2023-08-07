import React from "react";
import { styled } from "styled-components";
import life from "../../../../../assets/lifestyle/lifestyle1.svg";
import trimSideImg from "../../../../../assets/trimsideimg/trimSideNavy.svg";
import option1 from "../../../../../assets/extraoption/fca-2-s-jpg.svg";
import option2 from "../../../../../assets/extraoption/roa-s-jpg.svg";

const Detail = () => {
  return (
    <Wrapper>
      <Profile>
        <LifeImg src={life} />
        <ProfileContent>
          <span>김현대</span>
          <span>두아이의 엄마</span>
        </ProfileContent>
        <Phrase>
          "우리 아이들과 함께 타는 차는 항상
          <br />
          안전해야 한다고 생각해요."
        </Phrase>
      </Profile>
      <Recommendation>
        <Title>For You</Title>
        <Option>
          <OptionBanner>
            <div>
              <span>Le Blanc(르블랑)</span>
              <span>가솔린 8인승 2WD</span>
            </div>
            <div></div>
            <img src={trimSideImg} />
          </OptionBanner>
          <OptionItem>
            <img src={option2} />
            <span>컴포트 II</span>
          </OptionItem>
          <OptionItem>
            <img src={option1} />
            <span>현대 스마트 센스 I</span>
          </OptionItem>
        </Option>
      </Recommendation>
      <Interview>
        <Title>Interniew</Title>
        <InterviewBox>
          <InterviewItem>
            <Question>
              <span>Q.</span>
              <span>어떤 용도로 차를 사용하세요?</span>
            </Question>
            <Answer>
              저는 차를 타고 출퇴근도 하지만 주중에 아이들 픽업하거나 마트 갈
              때도 자주 타곤 합니다.
            </Answer>
          </InterviewItem>
          <InterviewItem>
            <Question>
              <span>Q.</span>
              <span>차를 살 때 가장 중요하게 생각하는 부분이 뭔가요?</span>
            </Question>
            <Answer>
              저는 차를 살 때 안전을 중요하게 생각해요. 가족들이 같이 타는 차라
              항상 사고에 경각심을 갖고 있죠. 펠리세이드는 그 점에서 뒷좌석
              에어백도 터지는 모델이라 안심이 되는 편이에요.
            </Answer>
          </InterviewItem>
        </InterviewBox>
      </Interview>
    </Wrapper>
  );
};
const InterviewBox = styled.div`
  height: 210px;
  width: 608px;

  display: flex;
  flex-direction: column;
  justify-content: space-between;
`;
const Answer = styled.div`
  display: flex;
  align-items: center;

  color: ${({ theme }) => theme.color.secondary};
  ${({ theme }) => theme.font.Body4_Medium};
  background: rgba(33, 151, 201, 0.1);

  border-radius: 4px;
  margin-top: 8px;
  padding: 12px;
`;

const Question = styled.div`
  ${({ theme }) => theme.font.Body3_Medium};
  span:nth-child(1) {
    color: ${({ theme }) => theme.color.primary_default};
  }
  span:nth-child(2) {
    color: ${({ theme }) => theme.color.grey50};
  }
`;
const InterviewItem = styled.div``;

const Interview = styled.div`
  height: 256px;
  width: 608px;

  margin-top: 32px;
`;

const OptionItem = styled.div`
  height: 234px;
  width: 304px;

  display: flex;
  flex-direction: column;
  justify-content: space-between;

  img {
    width: 304px;
    height: 202px;
  }
  span {
    ${({ theme }) => theme.font.Body4_Regular};
    color: ${({ theme }) => theme.color.grey200};
  }
`;

const OptionBanner = styled.div`
  width: 609px;
  height: 160px;
  display: flex;
  flex-direction: column;
  position: relative;
  div:nth-child(1) {
    width: 608px;
    height: 80px;

    display: flex;
    flex-direction: column;
    background: var(--grey-scale-grey-100, #303030);

    span:nth-child(1) {
      ${({ theme }) => theme.font.Body4_Medium};
      color: ${({ theme }) => theme.color.grey1000};
      margin-top: 20px;
      margin-left: 16px;
    }
    span:nth-child(2) {
      ${({ theme }) => theme.font.Caption1_Regular};
      color: ${({ theme }) => theme.color.grey500};
      margin-left: 16px;
    }
  }
  div:nth-child(2) {
    width: 608px;
    height: 80px;
    background: var(--grey-scale-grey-500, #a4a4a4);
  }

  img {
    position: absolute;
    right: 0px;
  }
`;

const Option = styled.div`
  height: 362px;
  width: 609px;

  display: flex;
  flex-wrap: wrap;
`;

const Title = styled.div`
  ${({ theme }) => theme.font.Extra8};
  color: ${({ theme }) => theme.color.grey0};

  margin-bottom: 16px;
`;
const Recommendation = styled.div`
  width: 608px;
  height: 474px;

  border-bottom: 1px solid;
  border-bottom-color: ${({ theme }) => theme.color.grey700};
`;
const Wrapper = styled.div`
  padding: 40px;
  height: 1062px;
  width: 688px;

  display: flex;
  flex-direction: column;
`;

const Profile = styled.div`
  display: flex;
  align-items: center;
  justify-content: flex-start;
  flex-wrap: wrap;

  gap: 11.32px;
  margin-bottom: 32px;
`;

const LifeImg = styled.img`
  width: 48px;
  height: 48px;

  border-radius: 50%;
  object-fit: cover;
`;

const ProfileContent = styled.div`
  display: flex;
  flex-direction: column;

  span:nth-child(1) {
    ${({ theme }) => theme.font.Extra2};
  }
  span:nth-child(2) {
    ${({ theme }) => theme.font.Caption1_Regular};
    color: ${({ theme }) => theme.color.grey400};
  }
`;

const Phrase = styled.div`
  width: 607px;
  height: 80px;
  flex-shrink: 0;

  display: flex;
  align-items: center;
  justify-content: center;

  color: ${({ theme }) => theme.color.secondary};
  ${({ theme }) => theme.font.Body2_Medium};
  background: rgba(33, 151, 201, 0.1);

  border-radius: 4px;
  text-align: center;
`;

export default Detail;
