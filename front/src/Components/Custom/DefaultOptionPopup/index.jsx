import React, { useEffect, useState } from "react";
import { styled } from "styled-components";
import CloseXIcon from "@assets/icons/close.svg";
import SampleImg from "@assets/images/default-option-popup-sample.svg";
import { getDefaultOption } from "apis/custom";

const DefaultOptionPopup = ({ popupRef, closePopup, option }) => {
  const [optionData, setOptionData] = useState();
  useEffect(() => {
    getDefaultOption(option.id).then((data) => {
      setOptionData(data);
    });
  }, []);
  return (
    <Wrapper ref={popupRef}>
      <Header>
        <span>{option.name}</span>
        <img src={CloseXIcon} onClick={closePopup} />
      </Header>
      <Img>
        <img src={optionData?.imageUrl} />
      </Img>
      <Description>{optionData?.tooltipDescription}</Description>
      <Caption>
        *사진과 설명은 참고용이며 실제 차량과는 상이할 수 있습니다.
      </Caption>
    </Wrapper>
  );
};
const Caption = styled.div`
  color: ${({ theme }) => theme.color.grey400};
  ${({ theme }) => theme.font.Caption1_Regular}
  margin-top: 5px;
`;
const Description = styled.div`
  color: ${({ theme }) => theme.color.grey200};
  ${({ theme }) => theme.font.Body4_Regular};
  margin-top: 12px;
`;
const Img = styled.div`
  width: 251px;
  height: 168px;
  border-radius: 4px;
  overflow: hidden;
  margin-top: 16px;

  img {
    width: 100%;
    height: 100%;
  }
`;
const Header = styled.div`
  display: flex;
  align-items: flex-start;
  justify-content: space-between;
  gap: 22px;

  span {
    ${({ theme }) => theme.font.Body2_Bold};
  }
  img:hover {
    cursor: pointer;
  }
`;
const Wrapper = styled.div`
  position: absolute;
  right: 12px;
  bottom: 30px;
  width: 300px;

  background-color: ${({ theme }) => theme.color.grey1000};

  border-radius: 12px;

  padding: 21px 24px;

  box-sizing: border-box;

  box-shadow: 0px 4px 30px 0px rgba(142, 152, 168, 0.4);

  z-index: 1;
`;
export default DefaultOptionPopup;
