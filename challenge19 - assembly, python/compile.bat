nasm.exe challenge19.asm -f win64 -o challenge19.obj
gcc.exe challenge19.obj -m64 -o challenge19.exe
golink.exe /console /entry main challenge19.obj
pause