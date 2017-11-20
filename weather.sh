#!/bin/bash

export LANG="zh_CN.UTF-8"
export WEATHER_HOME="/home/gm/weather"
export JAVA_HOME="/usr/lib/jvm/java-8-oracle"
export PATH=$JAVA_HOME/bin:$PATH
export CLASSPATH=.:$WEATHER_HOME:$JAVA_HOME/lib/dt.jar:$JAVA_HOME/lib/tools.jar:$CLASSPATH

echo "begin aa"
cd $WEAHTER_HOME
$JAVA_HOME/bin/java -cp $CLASSPATH -jar /home/gm/weather/weather.jar
echo "end aa"
