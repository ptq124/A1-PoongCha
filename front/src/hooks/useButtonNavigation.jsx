import { useNavigate } from "react-router-dom";

const useButtonNavigation = () => {
  const navigate = useNavigate();

  const handleButtonClick = (path) => {
    navigate(path);
  };

  return handleButtonClick;
};

export default useButtonNavigation;
