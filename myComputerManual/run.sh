#!/bin/sh

# --------------------------------------------------------------------


if [ -z "$JAVA_HOME" ] ; then
  JAVA=`/usr/bin/which java`
  if [ -z "$JAVA" ] ; then
    echo "Cannot find JAVA. Please set your PATH."
    exit 1
  fi
  JAVA_BIN=`dirname $JAVA`
  JAVA_HOME=$JAVA_BIN/..
else
  JAVA=$JAVA_HOME/bin/java
fi


#---------------------------------------------------------------------#
TOP=.

CP=`echo lib/*/*.jar | tr ' ' ':'`:$CP
CP=${TOP}/build/classes:$CP

if [ -z "$1" ] ; then
   echo Please specify test name.
   exit 1
fi

NAME=$1
shift


if [ "$NAME" = "manual" ] ; then
    CMD="$JAVA $JAVA_OPTS -cp $CP myComputerManual.driver.Driver $2"
fi

## Note that $@ is for the arguments
echo $CMD "$@"
$CMD "$@"