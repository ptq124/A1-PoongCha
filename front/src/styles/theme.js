import { css } from "styled-components";

const color = {
  primary_default: "#00428E",
  primary_light: "#E5ECF4",
  secondary: "#2197C9",
  black: "#111111",
  grey1000: "#FFF",
  grey900: "#FBFBFB",
  grey800: "#F0F0F0",
  grey700: "#EBEBEB",
  grey600: "#BEBEBE",
  grey500: "#A4A4A4",
  grey400: "#777",
  grey300: "#696969",
  grey200: "#404040",
  grey100: "#303030",
  grey50: "#1A1A1A",

  extra1: "#EDF0F4", // QNASummary > Wrapper
};

const font = {
  Head1: css`
    font-family: "HyundaiSansHeadBoldKR";
    font-size: 22px;
    font-style: normal;
    font-weight: 500;
    line-height: 28px;
    letter-spacing: -0.3px;
  `,
  Head2: css`
    font-family: "HyundaiSansHeadMediumKR";
    font-size: 20px;
    font-style: normal;
    font-weight: 500;
    line-height: 26px;
    letter-spacing: -0.3px;
  `,
  Head3: css`
    font-family: "HyundaiSansHeadMediumKR";
    font-size: 18px;
    font-style: normal;
    font-weight: 500;
    line-height: 24px;
    letter-spacing: -0.3px;
  `,
  Head4: css`
    font-family: "HyundaiSansHeadMediumKR";
    font-size: 16px;
    font-style: normal;
    font-weight: 500;
    line-height: 22px;
    letter-spacing: -0.3px;
  `,
  Body1_Bold: css`
    font-family: "HyundaiSansTextBoldKR";
    font-size: 20px;
    font-style: normal;
    font-weight: 700;
    line-height: 28px;
    letter-spacing: -0.2px;
  `,
  Body1_Medium: css`
    font-family: "HyundaiSansTextMediumKR";
    font-size: 20px;
    font-style: normal;
    font-weight: 500;
    line-height: 28px;
    letter-spacing: -0.2px;
  `,
  Body2_Bold: css`
    font-family: "HyundaiSansTextBoldKR";
    font-size: 18px;
    font-style: normal;
    font-weight: 700;
    line-height: 26px;
    letter-spacing: -0.2px;
  `,
  Body2_Medium: css`
    font-family: "HyundaiSansTextMediumKR";
    font-size: 18px;
    font-style: normal;
    font-weight: 500;
    line-height: 26px;
    letter-spacing: -0.2px;
  `,
  Body2_Regular: css`
    font-family: "HyundaiSansTextRegularKR";
    font-size: 16px;
    font-style: normal;
    font-weight: 400;
    line-height: 26px;
    letter-spacing: -0.2px;
  `,
  Body3_Medium: css`
    font-family: "HyundaiSansTextMediumKR";
    font-size: 16px;
    font-style: normal;
    font-weight: 500;
    line-height: 24px;
    letter-spacing: -0.2px;
  `,
  Body3_Regular: css`
    font-family: "HyundaiSansTextRegularKR";
    font-size: 16px;
    font-style: normal;
    font-weight: 400;
    line-height: 24px;
    letter-spacing: -0.2px;
  `,
  Body4_Medium: css`
    font-family: "HyundaiSansTextMediumKR";
    font-size: 14px;
    font-style: normal;
    font-weight: 500;
    line-height: 22px;
    letter-spacing: -0.2px;
  `,
  Body4_Regular: css`
    font-family: "HyundaiSansTextRegularKR";
    font-size: 14px;
    font-style: normal;
    font-weight: 400;
    line-height: 22px;
    letter-spacing: -0.2px;
  `,
  Caption1_Medium: css`
    font-family: "HyundaiSansTextMediumKR";
    font-size: 12px;
    font-style: normal;
    font-weight: 500;
    line-height: 18px;
  `,
  Caption1_Regular: css`
    font-family: "HyundaiSansTextRegularKR";
    font-size: 12px;
    font-style: normal;
    font-weight: 400;
    line-height: 18px;
  `,

  // 추가한 폰트
  // Extra1 : SurveyHeader > Title
  Extra1: css`
    font-family: "HyundaiSansHeadRegularKR";
    font-size: 22px;
    font-style: normal;
    font-weight: 400;
    line-height: 28px;
    letter-spacing: -0.3px;
  `,
  // Extra2 : SurveyPage > PageIndicator
  Extra2: css`
    font-family: "HyundaiSansHeadMediumKR";
    font-size: 16px;
    font-style: normal;
    font-weight: 500;
    line-height: 24px;
    letter-spacing: -0.2px;
  `,
  // Extra3 : LandingPage > Text
  Extra3: css`
    font-family: "HyundaiSansHeadRegularKR";
    font-size: 28px;
    font-style: normal;
    font-weight: 400;
    line-height: 42px;
    letter-spacing: -0.3px;
  `,
  // Extra4 : LifestyleSurvey > "원하는 라이프스타일이 없다면?" 버튼
  Extra4: css`
    font-family: "HyundaiSansTextRegularKR";
    font-size: 14px;
    font-style: normal;
    font-weight: 500;
    line-height: 16px;
    letter-spacing: -0.07px;
  `,
  // Extra5 : SurveyOption > unselected된 버튼
  Extra5: css`
  font-family: "HyundaiSansTextRegularKR";
  font-size: 18px;
  font-style: normal;
  font-weight: 400;
  line-height: 22px;
  letter-spacing: -0.2px;
`,
// Extra6: SurveyOption > selected 버튼
Extra6: css`
  font-family: "HyundaiSansTextRegularKR";
  font-size: 18px;
  font-style: normal;
  font-weight: 700;
  line-height: 22px;
  letter-spacing: -0.2px;
`,
// Extra7: ExtraSurvey > BudgetSlider > BudgetRange
Extra7: css`
  font-family: "HyundaiSansHeadRegularKR";
  font-size: 24px;
  font-style: normal;
  font-weight: 400;
  line-height: 26px;
  letter-spacing: -0.2px;
`,
Extra8: css`
  font-family: "HyundaiSansHeadBoldKR";
  font-size: 24px;
  font-style: normal;
  font-weight: 400;
  line-height: 26px;
  letter-spacing: -0.2px;
`,
// QNASummary > AnswerTag
Extra9: css`
  font-family: "HyundaiSansTextRegularKR";
  font-size: 12px;
  font-style: normal;
  font-weight: 600;
  line-height: 16px;
  letter-spacing: -0.06px;
`,
// QNASummary > Title
Extra10: css`
  font-family: "HyundaiSansHeadMediumKR";
  font-size: 26px;
  font-style: normal;
  font-weight: 500;
  line-height: 32px; 
  letter-spacing: -0.3px;
`,
// LifestyleSurvey > Popup > Cover
Extra11: css`
  font-family: "HyundaiSansHeadMediumKR";
  font-size: 32px;
  font-style: normal;
  font-weight: 500;
  line-height: 140%; /* 44.8px */
  letter-spacing: -0.3px;
`,
};

export const theme = {
  color,
  font,
};
