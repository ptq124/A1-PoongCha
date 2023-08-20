const modelItemData = {
    engine: {
      title: "엔진",
      options: ["디젤 2.2", "가솔린 3.8"],
      tooltip:"디젤은 연비가 좋고 가솔린은 승차감이 더 부드럽고 조용해요."
    },
    body: {
      title: "바디",
      options: ["7인승", "8인승"],
      tooltip:"바디 설명 툴팁 내용입니다."
    },
    drivetrain: {
      title: "구동방식",
      options: ["2WD", "4WD"],
      tooltip:"구동방식 설명 툴팁 내용입니다."
    },
  };
  
  const TrimOptions = [
    {
      name: "Exclusive",
      defaultOptions: [
        "12인치 내비게이션",
        "내비 기반 크루즈",
        "세이프티 파워 윈도우",
      ],
      information: "합리적인 당신을 위한",
      minPrice: 43460000,
    },
    {
      name: "Le Blanc",
      defaultOptions: [
        "20인치 알로이 휠",
        "12인치 클러스터",
        "서라운드 뷰 모니터",
      ],
      information: "필수적인 옵션만 모은",
      minPrice: 43460000,
    },
    {
      name: "Prestige",
      defaultOptions: [
        "12인치 내비게이션",
        "내비 기반 크루즈",
        "세이프티 파워 윈도우",
      ],
      information: "합리적인 당신을 위한",
      minPrice: 43460000,
    },
    {
      name: "Caligraphy",
      defaultOptions: [
        "12인치 내비게이션",
        "내비 기반 크루즈",
        "세이프티 파워 윈도우",
      ],
      information: "합리적인 당신을 위한",
      minPrice: 43460000,
    },
  ];

  export{modelItemData, TrimOptions}