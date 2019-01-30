#!/bin/sh

n=0
while test $n -le 9;do
    echo java EdgeSortTester wug$n.txt
    java EdgeSortTester wugraph/wug$n.txt
    n=`expr $n + 1`
done
