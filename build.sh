#!/usr/bin/env bash
set -euo pipefail

echo "Cleaning and compiling..."
rm -rf out MANIFEST.MF Crazy8s.jar
mkdir -p out

javac -d out *.java

echo "Main-Class: CrazyEightsTournament" > MANIFEST.MF
echo "" >> MANIFEST.MF

jar cfm Crazy8s.jar MANIFEST.MF -C out .

echo "Built Crazy8s.jar"
