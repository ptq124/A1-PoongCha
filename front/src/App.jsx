import { theme } from "./styles/theme";
import { ThemeProvider } from "styled-components";
import { GlobalStyle } from "./styles/global-style";
import Header from "./Components/Header";
import ProgressBar from "./Components/ProgressBar";

function App() {
  return (
    <ThemeProvider theme={theme}>
      <GlobalStyle />
      <Header />
      <ProgressBar progress={0.5} />
    </ThemeProvider>
  );
}

export default App;
