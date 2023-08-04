import { styled } from "styled-components";

export const SurveyOptions = styled.div`
  display: flex;
  flex-wrap: wrap;
  gap: 12px;
  margin-top: 20px;
`;
export const SurveyTitle = styled.span`
  ${({ theme }) => theme.font.Extra1}

  strong {
    font-weight: bold;
  }
`;
export const SurveyHeader = styled.div`
  display: flex;
  align-items: center;
  justify-content: space-between;
`;
export const SurveyContent = styled.div`
  width: 608px;
  height: 100%;

  margin-top: 44px;
`;
