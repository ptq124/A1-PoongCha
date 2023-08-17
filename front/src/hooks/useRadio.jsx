import { useState } from "react";

const useRadio = (value = "") => {
  const [selected, setSelected] = useState(value);
  const handleSelected = (select) => {
    setSelected(select);
  };

  return { selected, handleSelected };
};

export default useRadio;
