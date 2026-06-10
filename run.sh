#!/bin/bash
# Compile and run the Java Logistics Route Simulator

SRC_DIR="src"
OUT_DIR="out"

echo "Compiling Java Logistics Route Simulator..."
mkdir -p $OUT_DIR

javac -sourcepath $SRC_DIR -d $OUT_DIR \
    $SRC_DIR/graph/Graph.java \
    $SRC_DIR/algorithm/Dijkstra.java \
    $SRC_DIR/Main.java

if [ $? -eq 0 ]; then
    echo "Compilation successful. Launching simulator..."
    java -cp $OUT_DIR Main
else
    echo "Compilation failed."
    exit 1
fi
