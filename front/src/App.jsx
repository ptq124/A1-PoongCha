import { theme } from "./styles/theme";
import { styled } from "styled-components";
import { ThemeProvider } from "styled-components";
import { GlobalStyle } from "./styles/global-style";
function App() {
<<<<<<< HEAD
      console.log("hello");
  return <>s</>;
=======
  return (
    <ThemeProvider theme={theme}>
      <GlobalStyle />
    </ThemeProvider>
  );
>>>>>>> 148a4faf34d507d252e065c839bb7585e3f4a708
}

export default App;
