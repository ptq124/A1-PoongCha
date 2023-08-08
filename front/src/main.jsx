import React from "react";
import ReactDOM from "react-dom/client";

import App from "./App.jsx";
import LandingPage from "./Pages/LandingPage/index.jsx";
import SurveyPage from "./Pages/SurveyPage/index.jsx";
import EtcPage from "./Pages/EtcPage/index.jsx";
import EndPage from "./Pages/EndPage/index.jsx";
import CustomPage from "./Pages/CustomPage/index.jsx";
import ResultPage from "./Pages/ResultPage/index.jsx";

import { createBrowserRouter, RouterProvider } from "react-router-dom";
import AgeSurvey from "./Pages/SurveyPage/AgeSurvey/index.jsx";
import LifestyleSurvey from "./Pages/SurveyPage/LifestyleSurvey/index.jsx";
import ExtraSurvey from "./Pages/SurveyPage/ExtraSurvey/index.jsx";
import ProgressBar from "./Components/Survey/ProgressBar/index.jsx";

const router = createBrowserRouter([
  {
    path: "/",
    element: <App />,
    children: [
      { index: true, path: "/", element: <LandingPage /> },
      {
        path: "/survey",
        element: <SurveyPage />,
        children: [
          {
            path: "age",
            element: (
              <>
                <ProgressBar />
                <AgeSurvey />
              </>
            ),
          },
          {
            path: "lifestyle",
            element: (
              <>
                <ProgressBar />
                <LifestyleSurvey />
              </>
            ),
          },
          {
            path: "extra",
            element: <ExtraSurvey />,
          },
          {
            path: "end",
            element: <EndPage />,
          },
          {
            path: "etc_end",
            element: <EtcPage />,
          },
        ],
      },
      // {
      //   path: "/etc_end",
      //   element: <EtcPage />,
      // },
      // { path: "/survey_end", element: <EndPage /> },
      {
        path: "/custom",
        element: <CustomPage />,
      },
      {
        path: "/result",
        element: <ResultPage />,
      },
    ],
  },
]);

ReactDOM.createRoot(document.getElementById("root")).render(
  <React.StrictMode>
    <RouterProvider router={router} />
  </React.StrictMode>
);
