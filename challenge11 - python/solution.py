import collections

ring1 = "llepeop"
ring2 = "fflaohlskakos"
ring3 = "jqninxmpelxjqsimpel"
ring4 = "dopoefussycrlhuviddlyrvchefp"
ring5 = "muffyiolyumsschajdett cpidephjklonka"
ring6 = "wreezymklcfdtvqhvsnrzxubuwxhappysdfbkcooltq"
ring7 = "oowqfdhilfrmgpsrtvkbeanstzkcdauueiyzybmvxgpjlcxnjqw"
r1 = "".join(sorted(ring1))
r2 = "".join(sorted(ring2))
r3 = "".join(sorted(ring3))
r4 = "".join(sorted(ring4))
r5 = "".join(sorted(ring5))
r6 = "".join(sorted(ring6))
r7 = "".join(sorted(ring7))
print collections.Counter(r7).most_common()[:-3-1:-1]
print collections.Counter(r6).most_common()[:-3-1:-1]
print collections.Counter(r5).most_common()[:-3-1:-1]
print collections.Counter(r4).most_common()[:-3-1:-1]
print collections.Counter(r3).most_common()[:-3-1:-1]
print collections.Counter(r2).most_common()[:-3-1:-1]
print collections.Counter(r1).most_common()[:-3-1:-1]

