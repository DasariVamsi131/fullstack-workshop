#!/bin/bash

# Exit immediately if a command fails
set -e



path="/d/fullstack-workshop/01-linux/Exercises/sample-log.txt"

# Check if the file exists
if [ -e "$path" ]; then
    echo "exist"
    echo "the file contains $(wc -l < "$path")lines"
    echo "Error count:$(grep -c -i 'Error' "$path")"
    echo "warning count:$(grep -c -i 'warning' "$path")"
    echo "info count:$(grep -c -i 'info' "$path")"
    IP_LIST=$(grep -oE '[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}' "$path" | sort | uniq)
    echo "$IP_LIST"

else
   echo "not exist"
fi


