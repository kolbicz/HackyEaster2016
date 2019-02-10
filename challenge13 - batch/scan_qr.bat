convert -crop 21x21 wallpaper.jpg tile%06d.jpg
forfiles /m *.jpg /c "cmd.exe /c convert @file -scale 200% -colorspace Gray @file & zbarimg.exe @file" | find "QR" >>codes.txt"
find /v "xx" codes.txt