import React from "react";
import ReactDOM from "react-dom/client";
import App from "./App.jsx";
import { createBrowserRouter, RouterProvider } from "react-router-dom";
import LandingPage from "./Pages/LandingPage/index.jsx";

const router = createBrowserRouter([
  {
    path: "/",
    element: <App />,
    children: [
      { index: true, path: "/", element: <LandingPage /> },
      // { path: "/survey", element: <SurveyPage /> },
      // {
      //   path: "/etc_end",
      //   element: <EtcPage />,
      // },
      // { path: "/survey_end", element: <EndPage /> },
      // {
      //   path: "/custom",
      //   element: <CustomPage />,
      // },
      // {
      //   path: "/result",
      //   element: <ResultPage />,
      // },
    ],
  },
]);

ReactDOM.createRoot(document.getElementById("root")).render(
  <React.StrictMode>
    <RouterProvider router={router} />
  </React.StrictMode>
);
