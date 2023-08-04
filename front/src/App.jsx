import { theme } from "./styles/theme";
import { ThemeProvider, styled } from "styled-components";
import { GlobalStyle } from "./styles/global-style";
import { Outlet } from "react-router-dom";
import Header from "./Components/Header";

function App() {
  return (
    <ThemeProvider theme={theme}>
      <GlobalStyle />
      <Wrapper>
        <Header />
        <Outlet />
      </Wrapper>
    </ThemeProvider>
  );
}

const Wrapper = styled.div`
  position: relative;

  width: 100vw;
  height: 100vh;
`;

export default App;
