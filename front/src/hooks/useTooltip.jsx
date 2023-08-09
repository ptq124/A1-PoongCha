import { useState } from "react";

const useTooltip = () => {
  const [isTooltipOpen, setIsTooltipOpen] = useState(false);

  const openTooltip = () => {
    setIsTooltipOpen(true);
  };

  const closeTooltip = () => {
    setIsTooltipOpen(false);
  };

  return {
    isTooltipOpen,
    openTooltip,
    closeTooltip,
  };
};

export default useTooltip;
