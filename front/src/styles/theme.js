import { css } from "styled-components";

const color = {
  primary_default: "#00428E",
  primary_light: "#E5ECF4",
  secondary: "#2197C9",
  black: "#111111",
  grey1000: "#FFF",
  grey900: "#FBFBFB",
  grey00: "#F0F0F0",
  grey700: "#EBEBEB",
  grey600: "#BEBEBE",
  grey500: "#A4A4A4",
  grey400: "#777",
  grey300: "#696969",
  grey200: "#404040",
  grey100: "#303030",
  grey50: "#1A1A1A",
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
};

export const theme = {
  color,
  font,
};
