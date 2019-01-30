#!/bin/sh
## 課題２のスクリプト
n=10
while test $n -le 30; do
    echo graph0$n.txt
    java BFSTester graph/graph0$n.txt
    n=`expr $n + 10`
done
