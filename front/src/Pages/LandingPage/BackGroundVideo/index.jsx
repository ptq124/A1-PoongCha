import React from "react";
import { styled } from "styled-components";
import video from "../../../assets/video/Home_mp4.mp4";

const BackGroundVideo = () => {
  return (
    <Wrapepr>
      <VideoTag autoPlay loop muted playsInline>
        <source src={video} type="video/mp4" />
      </VideoTag>
    </Wrapepr>
  );
};

const Wrapepr = styled.div`
  position: absolute;

  width: 100%;
  height: 100%;

  top: 0;
  left: 0;

  z-index: -1;
`;

const VideoTag = styled.video`
  width: 100%;
  height: 100%;

  object-fit: fill;
`;

export default BackGroundVideo;
