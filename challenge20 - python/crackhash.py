import hashlib

with open(r"D:\Dictionaries\inside3.txt") as f:
    for line in f:
    	line=line.rstrip('\n').upper()
	if hashlib.sha1("efgh."+line+".efgh").hexdigest()=="de2278f5bcafcbb097ecc1fb54e5ab8a9e912c55":
		print line, hashlib.sha1("efgh."+line+".efgh").hexdigest()
	if hashlib.sha1("abcd."+line+".abcd").hexdigest()=="943f9ecbbd91306a561d0e3c15e18ee700007083":
		print line, hashlib.sha1("abcd."+line+".abcd").hexdigest()
	if hashlib.sha1("zyxw."+line+".zyxw").hexdigest()=="0cf32f8f418659f23f8968d4f63ea5c98b39f833":
		print line, hashlib.sha1("zyxw."+line+".zyxw").hexdigest()
	if hashlib.sha1("jklm."+line+".jklm").hexdigest()=="1742ae4507fc480958e2437104e677e70aa5e857":
		print line, hashlib.sha1("jklm."+line+".jklm").hexdigest()
	if hashlib.sha1("nmlk."+line+".nmlk").hexdigest()=="915d253cb5ba6f0a220bca83e2d6d3258af15e68":
		print line, hashlib.sha1("nmlk."+line+".nmlk").hexdigest()
