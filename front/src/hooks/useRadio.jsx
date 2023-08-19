import { useState } from "react";

const useRadio = (value = "") => {
  const [selectedItem, setSelectedItem] = useState(value);
  const handleSelectItem = (value) => {
    setSelectedItem(value);
  };

  return { selectedItem, handleSelectItem };
};

export default useRadio;
