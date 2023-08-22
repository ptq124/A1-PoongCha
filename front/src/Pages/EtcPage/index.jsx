import React from "react";
import { css, styled } from "styled-components";
import QNASummary from "./QNASummary";
import Summary from "@Components/Common/Summary";
import Button from "@Components/Common/Button/Button";
import useButtonNavigation from "@hooks/useButtonNavigation";
import { useUserData } from "context/UserDataContext";

const EtcPage = () => {
  const move = useButtonNavigation();
  const totalData = {
    엔진: {
      id: 2,
      name: "가솔린 3.8",
      descriptionImageUrl:
        "https://my-car-store-resource.s3.ap-northeast-2.amazonaws.com/car_components/engine_gasoline.jpg",
      additionalPrice: 0,
    },
    바디: {
      id: 3,
      name: "7인승",
      descriptionImageUrl:
        "https://my-car-store-resource.s3.ap-northeast-2.amazonaws.com/car_components/bodytype_7seats.jpg",
      additionalPrice: 0,
    },
    구동방식: {
      id: 5,
      name: "2WD",
      descriptionImageUrl:
        "https://my-car-store-resource.s3.ap-northeast-2.amazonaws.com/car_components/drivetrain_2wd.jpg",
      additionalPrice: 0,
    },
    외장: {
      id: 2,
      name: "아비스블랙펄",
      imageUrl:
        "https://www.hyundai.com/contents/vr360/LX06/exterior/A2B/colorchip-exterior.png",
      type: "EXTERIOR",
      trimExteriorImageUrl:
        "https://www.hyundai.com/contents/vr360/LX06/exterior/A2B/010.png",
      trimRotationImageBaseUrl:
        "https://www.hyundai.com/contents/vr360/LX06/exterior/A2B/0",
      incompatibleColorIds: [6, 7],
    },
    내장: {
      id: 6,
      name: "퀼팅천연(블랙)",
      imageUrl:
        "https://www.hyundai.com/contents/vr360/LX06/interior/I49/colorchip-interior.png",
      type: "INTERIOR",
      trimInteriorImageUrl:
        "https://www.hyundai.com/contents/vr360/LX06/interior/I49/img-interior.png",
      incompatibleColorIds: [2, 3],
    },
    옵션: [
      {
        options: [
          {
            detailDescription: "-",
            id: 110,
            imageUrl:
              "https://my-car-store-resource.s3.ap-northeast-2.amazonaws.com/car_options/20_darkwheel.jpg",
            installationLocation: "WHEEL2",
            name: "20인치 다크 스퍼터링 휠",
          },
        ],
      },
      {
        options: [
          {
            detailDescription:
              "기존 8인승 시트(1열 2인, 2열 3인, 3열 3인)에서 2열 가운데 착좌부를 없애 2열 탑승객의 편의는 물론, 3열 탑승객의 승하차를 편하도록 돕습니다.",
            id: 55,
            imageUrl:
              "https://my-car-store-resource.s3.ap-northeast-2.amazonaws.com/car_options/7_seat_m.jpg",
            installationLocation: "DEFAULT",
            name: "7인승 시트",
          },
        ],
      },
    ],
  };
  const estimated = 48000000;
  return (
    <Wrapper>
      <QNASummary />
      <Summary data={totalData} estimated={estimated} />
      <ButtonContainer>
        <Button
          text="커스텀하기"
          style={CustomBtnStyle}
          onClick={() => move("/custom/trim")}
        />
        <Button text="빠른 견적내기" style={CompleteEstimateBtnStyle} />
      </ButtonContainer>
    </Wrapper>
  );
};

const CompleteEstimateBtnStyle = css`
  width: 298px;
  height: 52px;

  color: ${({ theme }) => theme.color.grey1000};
  background-color: ${({ theme }) => theme.color.primary_default};
  ${({ theme }) => theme.font.Body3_Medium};

  border: 1px solid ${({ theme }) => theme.color.primary_default};
  border-radius: 6px;
`;
const CustomBtnStyle = css`
  width: 298px;
  height: 52px;

  color: ${({ theme }) => theme.color.grey50};
  background-color: ${({ theme }) => theme.color.grey1000};
  ${({ theme }) => theme.font.Body3_Medium};

  border: 1px solid ${({ theme }) => theme.color.grey600};
  border-radius: 6px;
`;
const ButtonContainer = styled.div`
  display: flex;
  gap: 12px;

  width: 608px;

  margin-bottom: 36px;
`;
const Wrapper = styled.div`
  width: 100%;
  display: flex;
  flex-direction: column;
  align-items: center;
`;
export default EtcPage;
