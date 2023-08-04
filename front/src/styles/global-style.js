import { createGlobalStyle } from "styled-components";
import { reset } from "styled-reset";

export const GlobalStyle = createGlobalStyle`
  ${reset}
  
  @font-face {
    font-family: "HyundaiSansHeadBoldKR";
    src: url('src/assets/font/HyundaiSansHeadKRBold.ttf') format('truetype');
  }
  @font-face {
    font-family: "HyundaiSansHeadMediumKR";
    src: url('src/assets/font/HyundaiSansHeadKRMedium.ttf') format('truetype');
  }
  @font-face {
    font-family: "HyundaiSansHeadRegularKR";
    src: url('src/assets/font/HyundaiSansHeadKRRegular.ttf') format('truetype');
  }
  @font-face {
    font-family: "HyundaiSansTextBoldKR";
    src: url('src/assets/font/HyundaiSansTextKRBold.ttf') format('truetype');
  }
  @font-face {
    font-family: "HyundaiSansTextMediumKR";
    src: url('src/assets/font/HyundaiSansTextKRMedium.ttf') format('truetype');
  }
  @font-face {
    font-family: "HyundaiSansTextRegularKR";
    src: url('src/assets/font/HyundaiSansTextKRRegular.ttf') format('truetype');
  }
`;
