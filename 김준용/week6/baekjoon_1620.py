
import sys
filed = sys.stdin.read().splitlines()
codec = dict([(filed[j],j) for j in range(1,int(filed[0].split()[0])+1)])
codec_pos = dict([(str(j), filed[j]) for j in range(1,int(filed[0].split()[0])+1)])

for i in filed[int(filed[0].split()[0])+1:]:
    print(codec.get(i,codec_pos.get(i)))

