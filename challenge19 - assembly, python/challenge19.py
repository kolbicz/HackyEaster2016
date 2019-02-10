#87 06 48 16 94 F0 42 0E 4E 1E F6 05 29 DD 30 29 87 17

import socket

s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
host = "hackyeaster.hacking-lab.com"
port = 1234
s.connect((host,port))
s.send("\x87\x06\x48\x16\x94\xF0\x42\x0E\x4E\x1E\xF6\x05\x29\xDD\x30\x29\x87\x17") 
s.send("\x0a")
data = s.recv(1024)
print data
s.close ()


