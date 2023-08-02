import { theme } from "./styles/theme";
import { styled } from "styled-components";
import { ThemeProvider } from "styled-components";
import { GlobalStyle } from "./styles/global-style";
import Header from "./Components/Header/index";
import ProgressBar from "./Components/ProgressBar/index";
import SurveyOption from "./Components/SurveyOption";
import { useState } from "react";

function App() {
  const [selectedOption, setSelectedOption] = useState(0);
  const handleOptionChange = (option) => {
    setSelectedOption(option);
  };
  return (
    <ThemeProvider theme={theme}>
      <GlobalStyle />
      <Header />
      <ProgressBar progress={0.5} />
      <form>
        <SurveyOption
          label="20대"
          index={0}
          name="age"
          selected={selectedOption === 0}
          onChange={() => handleOptionChange(0)}
        />
        <SurveyOption
          label="30대"
          index={1}
          name="age"
          selected={selectedOption === 1}
          onChange={() => handleOptionChange(1)}
        />
      </form>
    </ThemeProvider>
  );
}

export default App;
