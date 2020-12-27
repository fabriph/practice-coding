#!/usr/bin/bash
echo " - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - "
echo "compiling"
g++ foo-copyable.cc foo-copyable-and-movable.cc foo-movable.cc main.cc -o copy_and_move.bin

if [ $? -ne 0 ]; then
    exit
fi

echo " - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - "
echo "running"
echo
./copy_and_move.bin
