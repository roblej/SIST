import os
cpath = os.getcwd()
print("현재 위치:",cpath)
print("----")
sub_list = os.listdir(cpath)
for s in sub_list:
    print(s)