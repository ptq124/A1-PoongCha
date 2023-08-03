import { createGlobalStyle } from "styled-components";
import { reset } from "styled-reset";

export const GlobalStyle = createGlobalStyle`
  ${reset}
  
  @font-face {
    font-family: "HyundaiSansHeadBoldKR";
    src: url('src/assets/font/HyundaiSansHead-Bold.otf') format('opentype');
  }
  @font-face {
    font-family: "HyundaiSansHeadMediumKR";
    src: url('src/assets/font/HyundaiSansHead-Medium.otf') format('opentype');
  }
  @font-face {
    font-family: "HyundaiSansTextBoldKR";
    src: url('src/assets/font/HyundaiSansText-Bold.otf') format('opentype');
  }
  @font-face {
    font-family: "HyundaiSansTextMediumKR";
    src: url('src/assets/font/HyundaiSansText-Medium.otf') format('opentype');
  }
  @font-face {
    font-family: "HyundaiSansTextRegularKR";
    src: url('src/assets/font/HyundaiSansText-Regular.otf') format('opentype');
  }
`;
