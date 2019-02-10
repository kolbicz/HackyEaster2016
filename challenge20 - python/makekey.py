import hashlib

count = 1
p_tmp="kee.snakeoil.kee"
while (count <= 10000):
	p_tmp=hashlib.sha1(p_tmp).hexdigest()
	count = count + 1
print p_tmp

#SELECT AES_DECRYPT(UNHEX(kee), '1b7b21c2204fcfdb18006c8b4b2bf6437e7850a3') from kee where id=2332;
#jpP8HeoEC5OCCBqdf9N3
#SELECT AES_DECRYPT(blahb,'jpP8HeoEC5OCCBqdf9N3') FROM fyle WHERE id=3492 INTO DUMPFILE 'C:\\Users\\administrator\\Desktop\\hacky16\\challenge20\\solution.png';