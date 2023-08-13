import { useEffect, useState } from "react";

const useOnClickPopUp = (ref) => {
  const [isPopupOpen, setIsPopupOpen] = useState(false);
  const openPopup = () => {
    setIsPopupOpen(true);
    document.body.style.overflow = "hidden";
  };
  const closePopup = () => {
    setIsPopupOpen(false);
    document.body.style.overflow = "auto";
  };
  const handleClickOutside = (event) => {
    if (!ref.current || ref.current.contains(event.target)) {
      return;
    }
    closePopup();
    document.body.style.overflow = "auto";
  };

  useEffect(() => {
    document.addEventListener("mousedown", handleClickOutside);
    return () => {
      document.removeEventListener("mousedown", handleClickOutside);
    };
  }, [ref]);

  return { isPopupOpen, openPopup, closePopup };
};

export default useOnClickPopUp;
