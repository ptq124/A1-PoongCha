import { useNavigate } from "react-router-dom";

const useButtonNavigation = () => {
  const navigate = useNavigate();
  const handleButtonClick = (path, state) => {
    navigate(path, { state });
  };

  return handleButtonClick;
};

export default useButtonNavigation;
