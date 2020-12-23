#!/usr/bin/bash
echo " - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - "
echo "compiling"
g++ FooCopyable.cc main.cc -o copy_and_move

if [ $? -ne 0 ]; then
    exit
fi

echo " - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - "
echo "running"
echo
./copy_and_move
