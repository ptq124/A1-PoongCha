import { theme } from "./styles/theme";
import { styled } from "styled-components";
import { ThemeProvider } from "styled-components";
import { GlobalStyle } from "./styles/global-style";
import Header from "./Components/Header/index";
import ProgressBar from "./Components/ProgressBar/index";
import SurveyOption from "./Components/SurveyOption";

function App() {
  return (
    <ThemeProvider theme={theme}>
      <GlobalStyle />
      <Header />
      <ProgressBar progress={0.5} />
      <SurveyOption label="20대" />
    </ThemeProvider>
  );
}

export default App;
