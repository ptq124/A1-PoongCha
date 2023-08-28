export const mockData = [
  {
    트림: {
      id: 2,
      trimName: "Le Blanc",
      optionGroups: [
        "20인치 알로이 휠",
        "12인치 클러스터",
        "서라운드 뷰 모니터",
      ],
      information: "필수적인 옵션만 모은",
      minPrice: 43460000,
    },
    엔진: {
      id: 2,
      name: "가솔린 3.8",
      descriptionImageUrl:
        "https://my-car-store-resource.s3.ap-northeast-2.amazonaws.com/car_components/engine_gasoline.jpg",
      additionalPrice: 0,
    },
    바디: {
      id: 3,
      name: "7인승",
      descriptionImageUrl:
        "https://my-car-store-resource.s3.ap-northeast-2.amazonaws.com/car_components/bodytype_7seats.jpg",
      additionalPrice: 0,
    },
    구동방식: {
      id: 5,
      name: "2WD",
      descriptionImageUrl:
        "https://my-car-store-resource.s3.ap-northeast-2.amazonaws.com/car_components/drivetrain_2wd.jpg",
      additionalPrice: 0,
    },
    외장: {
      id: 2,
      name: "어비스블랙펄",
      imageUrl:
        "https://www.hyundai.com/contents/vr360/LX06/exterior/A2B/colorchip-exterior.png",
      type: "EXTERIOR",
      trimExteriorImageUrl:
        "https://my-car-store-resource.s3.ap-northeast-2.amazonaws.com/rotation/abyss_exterior/image_011.webp",
      trimRotationImageBaseUrl:
        "https://my-car-store-resource.s3.ap-northeast-2.amazonaws.com/rotation/abyss_exterior/",
      incompatibleColorIds: [],
    },
    내장: {
      id: 6,
      name: "퀄팅천연(블랙)",
      imageUrl:
        "https://www.hyundai.com/contents/vr360/LX06/interior/I49/colorchip-interior.png",
      type: "INTERIOR",
      trimInteriorImageUrl:
        "https://www.hyundai.com/contents/vr360/LX06/interior/I49/img-interior.png",
      incompatibleColorIds: [],
    },
    옵션: [
      {
        id: 84,
        name: "하이패스",
        additionalPrice: 0,
        summaryDescription:
          "유료 도로로 진출입시 통행료가 자동결제 되는 장치입니다. 하이패스 시스템은 시동이 걸려있는 상태에서만 작동합니다.",
        tagNames: ["사용편의"],
        incompatibleCarOptionGroupIds: [],
        options: [
          {
            id: 84,
            name: "하이패스",
            imageUrl:
              "https://my-car-store-resource.s3.ap-northeast-2.amazonaws.com/car_options/hipass.webp",
            detailDescription:
              "유료 도로로 진출입시 통행료가 자동결제 되는 장치입니다. 하이패스 시스템은 시동이 걸려있는 상태에서만 작동합니다.",
            installationLocation: "DEFAULT",
          },
        ],
      },
      {
        id: 94,
        name: "현대스마트센스 Ⅰ",
        additionalPrice: 790000,
        summaryDescription:
          "전방 충돌 감지 / 크루즈 컨트롤 / 차로 유지 등의 ADAS 세트 옵션",
        tagNames: ["주행안전", "주차/출차"],
        incompatibleCarOptionGroupIds: [],
        options: [
          {
            id: 100,
            name: "전방 충돌방지 보조(교차 차량/추월시 대향차/측방 접근차)",
            imageUrl:
              "https://my-car-store-resource.s3.ap-northeast-2.amazonaws.com/car_options/fca2.jpg",
            detailDescription:
              "선행 차량이 갑자기 속도를 줄이거나, 앞에 정지 차량 혹은 보행자가 나타나는 등 전방 충돌 위험이 감지되면 경고를 해줍니다. 경고 후에도 충돌 위험이 높아지면 자동으로 제동을 도와줍니다. 주행 중 전방의 자전거 탑승자 및 교차로에서 좌회전 시 맞은편에서 다가오는 차량과 충돌 위험이 있다면 자동으로 제동을 도와줍니다.",
            installationLocation: "FRONTSENSOR",
          },
          {
            id: 101,
            name: "내비게이션 기반 스마트 크루즈 컨트롤(진출입로)",
            imageUrl:
              "https://my-car-store-resource.s3.ap-northeast-2.amazonaws.com/car_options/ncss2.jpg",
            detailDescription:
              "스마트 크루즈 작동 중 고속도로/도시고속도로/자동차전용 도로 내 고속도로 진출입로 주행 시 차로를 판단하여 사전감속 또는 최적 속도에 맞추어 감속을 진행합니다.",
            installationLocation: "HANDLE",
          },
          {
            id: 102,
            name: "고속도로 주행 보조 2",
            imageUrl:
              "https://my-car-store-resource.s3.ap-northeast-2.amazonaws.com/car_options/hda2.jpg",
            detailDescription:
              "고속도로 / 자동차 전용도로에서 앞차와의 거리와 설정 속도를 유지하며 주행할 뿐 아니라, 곡선로에서도 차로의 중앙을 유지하며 주행할 수 있도록 도와줍니다. 일정 속도 이상으로 주행 시, 스티어링 휠을 잡은 상태에서 방향지시등 스위치를 변경하고자 하는 차로 방향으로 움직이면 자동으로 차로를 변경해 줍니다.\n",
            installationLocation: "DEFAULT",
          },
        ],
      },
    ],
  },
  {
    트림: {
      id: 2,
      trimName: "Le Blanc",
      optionGroups: [
        "20인치 알로이 휠",
        "12인치 클러스터",
        "서라운드 뷰 모니터",
      ],
      information: "필수적인 옵션만 모은",
      minPrice: 43460000,
    },
    엔진: {
      id: 2,
      name: "가솔린 3.8",
      descriptionImageUrl:
        "https://my-car-store-resource.s3.ap-northeast-2.amazonaws.com/car_components/engine_gasoline.jpg",
      additionalPrice: 0,
    },
    바디: {
      id: 3,
      name: "7인승",
      descriptionImageUrl:
        "https://my-car-store-resource.s3.ap-northeast-2.amazonaws.com/car_components/bodytype_7seats.jpg",
      additionalPrice: 0,
    },
    구동방식: {
      id: 5,
      name: "2WD",
      descriptionImageUrl:
        "https://my-car-store-resource.s3.ap-northeast-2.amazonaws.com/car_components/drivetrain_2wd.jpg",
      additionalPrice: 0,
    },
    외장: {
      id: 2,
      name: "쉬머링 실버 메탈릭",
      imageUrl:
        "https://my-car-store-resource.s3.ap-northeast-2.amazonaws.com/car_colors/exterior/silver_metallic.png",
      type: "EXTERIOR",
      trimExteriorImageUrl:
        "https://my-car-store-resource.s3.ap-northeast-2.amazonaws.com/rotation/silver_exterior/image_011.webp",
      trimRotationImageBaseUrl:
        "https://my-car-store-resource.s3.ap-northeast-2.amazonaws.com/rotation/silver_exterior/",
      incompatibleColorIds: [],
    },
    내장: {
      id: 9,
      name: "쿨그레이",
      imageUrl:
        "https://my-car-store-resource.s3.ap-northeast-2.amazonaws.com/car_colors/interior/cool_gray.png",
      type: "INTERIOR",
      trimInteriorImageUrl:
        "https://my-car-store-resource.s3.ap-northeast-2.amazonaws.com/car_colors/interior/cool_gray_view.webp",
      incompatibleColorIds: [],
    },
    옵션: [
      {
        id: 89,
        name: "컴포트 Ⅱ",
        additionalPrice: 1090000,
        summaryDescription: "편의성을 위해 구성된 세트 옵션",
        tagNames: [],
        incompatibleCarOptionGroupIds: [],
        options: [
          {
            id: 89,
            name: "후석 승객 알림",
            imageUrl:
              "https://my-car-store-resource.s3.ap-northeast-2.amazonaws.com/car_options/roa.jpg",
            detailDescription:
              "초음파 센서를 통해 뒷좌석에 남아있는 승객의 움직임을 감지하여 운전자에게 경고함으로써 부주의에 의한 유아 또는 반려 동물 등의 방치 사고를 예방하는 신기술입니다.",
            installationLocation: "REAR",
          },
          {
            id: 90,
            name: "메탈 리어범퍼스텝",
            imageUrl:
              "https://my-car-store-resource.s3.ap-northeast-2.amazonaws.com/car_options/metalrearbumper.jpg",
            detailDescription:
              "러기지 룸 앞쪽 하단부를 메탈로 만들어 물건을 싣고 내릴 때나 사람이 올라갈 때 차체를 보호해줍니다.",
            installationLocation: "DEFAULT",
          },
          {
            id: 91,
            name: "메탈 도어스커프",
            imageUrl:
              "https://my-car-store-resource.s3.ap-northeast-2.amazonaws.com/car_options/metaldoorscuff.jpg",
            detailDescription:
              "자동차를 타고 내리는 도어의 문틈 하부를 보호하는 도어스커프 부분을 메탈로 만들어 차체를 보호하고 메탈 디자인으로 고급스러운 감성을 전달합니다.",
            installationLocation: "DEFAULT",
          },
          {
            id: 92,
            name: "3열 파워폴딩시트",
            imageUrl:
              "https://my-car-store-resource.s3.ap-northeast-2.amazonaws.com/car_options/powerfolding.jpg",
            detailDescription:
              "러기지 사이드에 있는 버튼으로 3열 시트를 접었다 펼 수 있으며, 2열 시트도 조작할 수 있어 화물 적재시나 3열 이용시 사용자의 편의성을 높였습니다.",
            installationLocation: "BACKSEAT",
          },
          {
            id: 93,
            name: "3열 열선시트",
            imageUrl:
              "https://my-car-store-resource.s3.ap-northeast-2.amazonaws.com/car_options/3_heated.jpg",
            detailDescription:
              "시동이 걸린 상태에서 해당 좌석 히터 스위치를 누르면 강약조절 표시등이 켜져 사용 중임을 나타내고 해당 좌석이 따뜻해집니다.",
            installationLocation: "SEATHEAT",
          },
          {
            id: 94,
            name: "헤드업 디스플레이",
            imageUrl:
              "https://my-car-store-resource.s3.ap-northeast-2.amazonaws.com/car_options/headupdisplay.jpg",
            detailDescription:
              "주요 주행 정보를 전면 윈드실드에 표시하며, 밝기가 최적화되어 주간에도 시인성이 뛰어납니다.",
            installationLocation: "DEFAULT",
          },
        ],
      },
      {
        id: 94,
        name: "현대스마트센스 Ⅰ",
        additionalPrice: 790000,
        summaryDescription:
          "전방 충돌 감지 / 크루즈 컨트롤 / 차로 유지 등의 ADAS 세트 옵션",
        tagNames: ["주행안전", "주차/출차"],
        incompatibleCarOptionGroupIds: [],
        options: [
          {
            id: 100,
            name: "전방 충돌방지 보조(교차 차량/추월시 대향차/측방 접근차)",
            imageUrl:
              "https://my-car-store-resource.s3.ap-northeast-2.amazonaws.com/car_options/fca2.jpg",
            detailDescription:
              "선행 차량이 갑자기 속도를 줄이거나, 앞에 정지 차량 혹은 보행자가 나타나는 등 전방 충돌 위험이 감지되면 경고를 해줍니다. 경고 후에도 충돌 위험이 높아지면 자동으로 제동을 도와줍니다. 주행 중 전방의 자전거 탑승자 및 교차로에서 좌회전 시 맞은편에서 다가오는 차량과 충돌 위험이 있다면 자동으로 제동을 도와줍니다.",
            installationLocation: "FRONTSENSOR",
          },
          {
            id: 101,
            name: "내비게이션 기반 스마트 크루즈 컨트롤(진출입로)",
            imageUrl:
              "https://my-car-store-resource.s3.ap-northeast-2.amazonaws.com/car_options/ncss2.jpg",
            detailDescription:
              "스마트 크루즈 작동 중 고속도로/도시고속도로/자동차전용 도로 내 고속도로 진출입로 주행 시 차로를 판단하여 사전감속 또는 최적 속도에 맞추어 감속을 진행합니다.",
            installationLocation: "HANDLE",
          },
          {
            id: 102,
            name: "고속도로 주행 보조 2",
            imageUrl:
              "https://my-car-store-resource.s3.ap-northeast-2.amazonaws.com/car_options/hda2.jpg",
            detailDescription:
              "고속도로 / 자동차 전용도로에서 앞차와의 거리와 설정 속도를 유지하며 주행할 뿐 아니라, 곡선로에서도 차로의 중앙을 유지하며 주행할 수 있도록 도와줍니다. 일정 속도 이상으로 주행 시, 스티어링 휠을 잡은 상태에서 방향지시등 스위치를 변경하고자 하는 차로 방향으로 움직이면 자동으로 차로를 변경해 줍니다.\n",
            installationLocation: "DEFAULT",
          },
        ],
      },
    ],
  },
  {
    트림: {
      id: 2,
      trimName: "Le Blanc",
      optionGroups: [
        "20인치 알로이 휠",
        "12인치 클러스터",
        "서라운드 뷰 모니터",
      ],
      information: "필수적인 옵션만 모은",
      minPrice: 43460000,
    },
    엔진: {
      id: 2,
      name: "가솔린 3.8",
      descriptionImageUrl:
        "https://my-car-store-resource.s3.ap-northeast-2.amazonaws.com/car_components/engine_gasoline.jpg",
      additionalPrice: 0,
    },
    바디: {
      id: 3,
      name: "7인승",
      descriptionImageUrl:
        "https://my-car-store-resource.s3.ap-northeast-2.amazonaws.com/car_components/bodytype_7seats.jpg",
      additionalPrice: 0,
    },
    구동방식: {
      id: 5,
      name: "2WD",
      descriptionImageUrl:
        "https://my-car-store-resource.s3.ap-northeast-2.amazonaws.com/car_components/drivetrain_2wd.jpg",
      additionalPrice: 0,
    },
    외장: {
      id: 3,
      name: "문라이트 블루 펄",
      imageUrl:
        "https://my-car-store-resource.s3.ap-northeast-2.amazonaws.com/car_colors/exterior/moonlight_blue_pearl.png",
      type: "EXTERIOR",
      trimExteriorImageUrl:
        "https://my-car-store-resource.s3.ap-northeast-2.amazonaws.com/rotation/blue_exterior/image_011.webp",
      trimRotationImageBaseUrl:
        "https://my-car-store-resource.s3.ap-northeast-2.amazonaws.com/rotation/blue_exterior/",
      incompatibleColorIds: [],
    },
    내장: {
      id: 9,
      name: "쿨그레이",
      imageUrl:
        "https://my-car-store-resource.s3.ap-northeast-2.amazonaws.com/car_colors/interior/cool_gray.png",
      type: "INTERIOR",
      trimInteriorImageUrl:
        "https://my-car-store-resource.s3.ap-northeast-2.amazonaws.com/car_colors/interior/cool_gray_view.webp",
      incompatibleColorIds: [],
    },
    옵션: [
      {
        id: 89,
        name: "컴포트 Ⅱ",
        additionalPrice: 1090000,
        summaryDescription: "편의성을 위해 구성된 세트 옵션",
        tagNames: [],
        incompatibleCarOptionGroupIds: [],
        options: [
          {
            id: 89,
            name: "후석 승객 알림",
            imageUrl:
              "https://my-car-store-resource.s3.ap-northeast-2.amazonaws.com/car_options/roa.jpg",
            detailDescription:
              "초음파 센서를 통해 뒷좌석에 남아있는 승객의 움직임을 감지하여 운전자에게 경고함으로써 부주의에 의한 유아 또는 반려 동물 등의 방치 사고를 예방하는 신기술입니다.",
            installationLocation: "REAR",
          },
          {
            id: 90,
            name: "메탈 리어범퍼스텝",
            imageUrl:
              "https://my-car-store-resource.s3.ap-northeast-2.amazonaws.com/car_options/metalrearbumper.jpg",
            detailDescription:
              "러기지 룸 앞쪽 하단부를 메탈로 만들어 물건을 싣고 내릴 때나 사람이 올라갈 때 차체를 보호해줍니다.",
            installationLocation: "DEFAULT",
          },
          {
            id: 91,
            name: "메탈 도어스커프",
            imageUrl:
              "https://my-car-store-resource.s3.ap-northeast-2.amazonaws.com/car_options/metaldoorscuff.jpg",
            detailDescription:
              "자동차를 타고 내리는 도어의 문틈 하부를 보호하는 도어스커프 부분을 메탈로 만들어 차체를 보호하고 메탈 디자인으로 고급스러운 감성을 전달합니다.",
            installationLocation: "DEFAULT",
          },
          {
            id: 92,
            name: "3열 파워폴딩시트",
            imageUrl:
              "https://my-car-store-resource.s3.ap-northeast-2.amazonaws.com/car_options/powerfolding.jpg",
            detailDescription:
              "러기지 사이드에 있는 버튼으로 3열 시트를 접었다 펼 수 있으며, 2열 시트도 조작할 수 있어 화물 적재시나 3열 이용시 사용자의 편의성을 높였습니다.",
            installationLocation: "BACKSEAT",
          },
          {
            id: 93,
            name: "3열 열선시트",
            imageUrl:
              "https://my-car-store-resource.s3.ap-northeast-2.amazonaws.com/car_options/3_heated.jpg",
            detailDescription:
              "시동이 걸린 상태에서 해당 좌석 히터 스위치를 누르면 강약조절 표시등이 켜져 사용 중임을 나타내고 해당 좌석이 따뜻해집니다.",
            installationLocation: "SEATHEAT",
          },
          {
            id: 94,
            name: "헤드업 디스플레이",
            imageUrl:
              "https://my-car-store-resource.s3.ap-northeast-2.amazonaws.com/car_options/headupdisplay.jpg",
            detailDescription:
              "주요 주행 정보를 전면 윈드실드에 표시하며, 밝기가 최적화되어 주간에도 시인성이 뛰어납니다.",
            installationLocation: "DEFAULT",
          },
        ],
      },
      {
        id: 84,
        name: "하이패스",
        additionalPrice: 0,
        summaryDescription:
          "유료 도로로 진출입시 통행료가 자동결제 되는 장치입니다. 하이패스 시스템은 시동이 걸려있는 상태에서만 작동합니다.",
        tagNames: ["사용편의"],
        incompatibleCarOptionGroupIds: [],
        options: [
          {
            id: 84,
            name: "하이패스",
            imageUrl:
              "https://my-car-store-resource.s3.ap-northeast-2.amazonaws.com/car_options/hipass.webp",
            detailDescription:
              "유료 도로로 진출입시 통행료가 자동결제 되는 장치입니다. 하이패스 시스템은 시동이 걸려있는 상태에서만 작동합니다.",
            installationLocation: "DEFAULT",
          },
        ],
      },
    ],
  },
  {
    트림: {
      id: 2,
      trimName: "Le Blanc",
      optionGroups: [
        "20인치 알로이 휠",
        "12인치 클러스터",
        "서라운드 뷰 모니터",
      ],
      information: "필수적인 옵션만 모은",
      minPrice: 43460000,
    },
    엔진: {
      id: 2,
      name: "가솔린 3.8",
      descriptionImageUrl:
        "https://my-car-store-resource.s3.ap-northeast-2.amazonaws.com/car_components/engine_gasoline.jpg",
      additionalPrice: 0,
    },
    바디: {
      id: 3,
      name: "7인승",
      descriptionImageUrl:
        "https://my-car-store-resource.s3.ap-northeast-2.amazonaws.com/car_components/bodytype_7seats.jpg",
      additionalPrice: 0,
    },
    구동방식: {
      id: 5,
      name: "2WD",
      descriptionImageUrl:
        "https://my-car-store-resource.s3.ap-northeast-2.amazonaws.com/car_components/drivetrain_2wd.jpg",
      additionalPrice: 0,
    },
    외장: {
      id: 2,
      name: "어비스블랙펄",
      imageUrl:
        "https://www.hyundai.com/contents/vr360/LX06/exterior/A2B/colorchip-exterior.png",
      type: "EXTERIOR",
      trimExteriorImageUrl:
        "https://my-car-store-resource.s3.ap-northeast-2.amazonaws.com/rotation/abyss_exterior/image_011.webp",
      trimRotationImageBaseUrl:
        "https://my-car-store-resource.s3.ap-northeast-2.amazonaws.com/rotation/abyss_exterior/",
      incompatibleColorIds: [],
    },
    내장: {
      id: 6,
      name: "퀄팅천연(블랙)",
      imageUrl:
        "https://www.hyundai.com/contents/vr360/LX06/interior/I49/colorchip-interior.png",
      type: "INTERIOR",
      trimInteriorImageUrl:
        "https://www.hyundai.com/contents/vr360/LX06/interior/I49/img-interior.png",
      incompatibleColorIds: [],
    },
    옵션: [
      {
        id: 84,
        name: "하이패스",
        additionalPrice: 0,
        summaryDescription:
          "유료 도로로 진출입시 통행료가 자동결제 되는 장치입니다. 하이패스 시스템은 시동이 걸려있는 상태에서만 작동합니다.",
        tagNames: ["사용편의"],
        incompatibleCarOptionGroupIds: [],
        options: [
          {
            id: 84,
            name: "하이패스",
            imageUrl:
              "https://my-car-store-resource.s3.ap-northeast-2.amazonaws.com/car_options/hipass.webp",
            detailDescription:
              "유료 도로로 진출입시 통행료가 자동결제 되는 장치입니다. 하이패스 시스템은 시동이 걸려있는 상태에서만 작동합니다.",
            installationLocation: "DEFAULT",
          },
        ],
      },
      {
        id: 94,
        name: "현대스마트센스 Ⅰ",
        additionalPrice: 790000,
        summaryDescription:
          "전방 충돌 감지 / 크루즈 컨트롤 / 차로 유지 등의 ADAS 세트 옵션",
        tagNames: ["주행안전", "주차/출차"],
        incompatibleCarOptionGroupIds: [],
        options: [
          {
            id: 100,
            name: "전방 충돌방지 보조(교차 차량/추월시 대향차/측방 접근차)",
            imageUrl:
              "https://my-car-store-resource.s3.ap-northeast-2.amazonaws.com/car_options/fca2.jpg",
            detailDescription:
              "선행 차량이 갑자기 속도를 줄이거나, 앞에 정지 차량 혹은 보행자가 나타나는 등 전방 충돌 위험이 감지되면 경고를 해줍니다. 경고 후에도 충돌 위험이 높아지면 자동으로 제동을 도와줍니다. 주행 중 전방의 자전거 탑승자 및 교차로에서 좌회전 시 맞은편에서 다가오는 차량과 충돌 위험이 있다면 자동으로 제동을 도와줍니다.",
            installationLocation: "FRONTSENSOR",
          },
          {
            id: 101,
            name: "내비게이션 기반 스마트 크루즈 컨트롤(진출입로)",
            imageUrl:
              "https://my-car-store-resource.s3.ap-northeast-2.amazonaws.com/car_options/ncss2.jpg",
            detailDescription:
              "스마트 크루즈 작동 중 고속도로/도시고속도로/자동차전용 도로 내 고속도로 진출입로 주행 시 차로를 판단하여 사전감속 또는 최적 속도에 맞추어 감속을 진행합니다.",
            installationLocation: "HANDLE",
          },
          {
            id: 102,
            name: "고속도로 주행 보조 2",
            imageUrl:
              "https://my-car-store-resource.s3.ap-northeast-2.amazonaws.com/car_options/hda2.jpg",
            detailDescription:
              "고속도로 / 자동차 전용도로에서 앞차와의 거리와 설정 속도를 유지하며 주행할 뿐 아니라, 곡선로에서도 차로의 중앙을 유지하며 주행할 수 있도록 도와줍니다. 일정 속도 이상으로 주행 시, 스티어링 휠을 잡은 상태에서 방향지시등 스위치를 변경하고자 하는 차로 방향으로 움직이면 자동으로 차로를 변경해 줍니다.\n",
            installationLocation: "DEFAULT",
          },
        ],
      },
    ],
  },
];
