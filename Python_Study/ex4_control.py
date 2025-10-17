"""
파이썬은 {}가 없이 들여쓰기로 구분한다.
if(조건식):
    조건식에 만족할 때 수행하는 문장
    조건식에 만족할 때 수행하는 문장
    조건식에 만족할 때 수행하는 문장
if문과 상관없이 수행하는 문장

if(조건식):
    조건식에 만족할 때 수행하는 문장
else:
    조건에 불만족 시 수행하는 문장
    조건에 불만족 시 수행하는 문장
"""

# str = input("나이 입력:")
# print("type(str):",type(str))
# msg = ""
# su=int(str)
# if su>=10 & su<20:
#     msg="10대"
# else:
#     msg="10대가 아님"
# print(msg)

"""
나이를 입력바다 10대 20대 30대를 구분하고 그 외는 잘못 입력하셨습니다를 출력
"""

# str = input("나이 입력")
# su=int(str)
# if su>=10 and su<20:
#     msg="10대"
# elif su>=20 and su<30:
#     msg="20대"
# elif su>=30 and su<40:
#     msg="30대"
# else:
#     msg="잘못 입력하셨습니다"
# print(msg)
# print("================================")

"""
for문의 구성                     while문의 구성
---------------------------------------------------
for 변수 in 배열구조:             while 조건식:
    수행문장                        수행문장
수행문장                         수행문장
"""
ar1 = [10,20,30,40,50]
str = "ABCDEF"
# for i in ar1:
#     print(i)

for i in str:
    print(i)