import { useEffect, useState } from "react";

// const useOnClickPopUp = (ref, handler) => {
//   useEffect(() => {
//     const listener = (event) => {
//       if (!ref.current || ref.current.contains(event.target)) {
//         return;
//       }
//       handler(event);
//     };
//     document.addEventListener("mousedown", listener);
//     return () => {
//       document.removeEventListener("mousedown", listener);
//     };
//   }, [ref, handler]);
// };
const useOnClickPopUp = (ref) => {
  const [isPopupOpen, setIsPopupOpen] = useState(false);
  const openPopup = () => {
    setIsPopupOpen(true);
  };
  const closePopup = () => {
    setIsPopupOpen(false);
  };
  const handleClickOutside = (event) => {
    if (!ref.current || ref.current.contains(event.target)) {
      return;
    }
    closePopup();
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
