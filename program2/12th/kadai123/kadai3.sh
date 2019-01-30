#!/bin/sh
## 課題３のスクリプト
n=5
while test $n -le 30; do
    if test $n -lt 10; then
	echo graph00$n.txt
	java DFSTester graph/graph00$n.txt
	n=`expr $n + 10`
    else
	echo graph0$n.txt
	java DFSTester graph/graph0$n.txt
	n=`expr $n + 10`
    fi
done
