import { theme } from "./styles/theme";
import { styled } from "styled-components";
import { ThemeProvider } from "styled-components";
import { GlobalStyle } from "./styles/global-style";
function App() {
  return (
    <ThemeProvider theme={theme}>
      <GlobalStyle />
    </ThemeProvider>
  );
}

export default App;
