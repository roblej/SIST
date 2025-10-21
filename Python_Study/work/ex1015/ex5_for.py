"""
특정 범위를 지정할 때 ㄱange를 사용한다
range(시작값,종료값+1,step값)
- 예)1~10까지 범위를 가지고 싶다면
range (1,11,1)
"""

for i in range(1,11 ):
    print(i ,end=" ")
print()
# 배열을 반복할 때 index값과 value를 같이 출력하고자 한다면
# 이 때 enumerate를 사용함
ar = ["python","Script","Tenser","Pandas"]
for v in ar:
    print(v)
print("-------------------")
for v in enumerate(ar):
    print(v)
print("-------------------")
for i,v in enumerate(ar):
    print("index: {}, value: {}".format(i,v))