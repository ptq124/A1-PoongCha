import { theme } from "./styles/theme";
import { ThemeProvider } from "styled-components";
import { GlobalStyle } from "./styles/global-style";
import { Outlet } from "react-router-dom";
import Header from "./Components/Header";

function App() {
  return (
    <ThemeProvider theme={theme}>
      <GlobalStyle />
      <Header />
      <Outlet />
    </ThemeProvider>
  );
}

export default App;
