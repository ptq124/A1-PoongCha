import { useEffect, useState } from "react";

const useRadio = (value = "") => {
  const [selectedItem, setSelectedItem] = useState(value);

  useEffect(() => {
    setSelectedItem(value);
  }, [value]);

  const handleSelectItem = (value) => {
    setSelectedItem(value);
  };

  return { selectedItem, handleSelectItem };
};

export default useRadio;
