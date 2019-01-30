#!/bin/sh

n=0
while test $n -le 9;do
    echo java LoadPrintTester wug$n.txt
    java LoadPrintTester wugraph/wug$n.txt > wug$n.txt
    echo diff wugraph/wug$n.txt wug$n.txt
    diff wugraph/wug$n.txt wug$n.txt
    n=`expr $n + 1`
done
