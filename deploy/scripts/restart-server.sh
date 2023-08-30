#!/bin/bash

REPOSITORY=/home/ec2-user/jar
cd $REPOSITORY

APP_NAME=boot-loader
JAR_NAME=$(ls $REPOSITORY/backend/boot-loader/build/libs/ | grep '.jar' | tail -n 1)
JAR_PATH=$REPOSITORY/backend/boot-loader/build/libs/$JAR_NAME
CURRENT_PID=$(pgrep -f $APP_NAME)

if [ -z $CURRENT_PID ] #2
then
  echo "> Application is not running"
else
  echo "> kill -15 $CURRENT_PID"
  sudo kill -15 $CURRENT_PID
  sleep 5
fi

sudo nohup java -jar -Dspring.profiles.active=prod $JAR_PATH > /home/nohup.out &
