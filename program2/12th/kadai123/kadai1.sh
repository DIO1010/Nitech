#!/bin/sh
# ‰Û‘è‚P‚Ì“à—e‚ð‹Lq‚¹‚æ
n=1
while test $n -le 30; do
    if test $n -lt 10; then
	java GraphTester graph/graph00$n.txt > out00$n.txt
	echo diff graph/graph00$n.txt out00$n.txt
	diff graph/graph00$n.txt out00$n.txt
	n=`expr $n + 1`
    else
	java GraphTester graph/graph0$n.txt > out0$n.txt
	echo diff graph/graph0$n.txt out0$n.txt
	diff graph/graph0$n.txt out0$n.txt
	n=`expr $n + 1`
    fi
done
