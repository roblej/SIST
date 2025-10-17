#파이썬의 자료구조
"""
파이썬의 자료구조
    1. 리스트 List :  배열과 같고 순서를 가짐 : [값1, 값2, 값3, ...]
    2. 튜플 Tuple :  List와 같음, 수정이 불가능 : (값1, 값2, 값3, ...)
    4. 셋 Set :  중복을 허용하지 않는 집합 : {값1, 값2, 값3, ...}
    3. 딕셔너리 Dictionary :  키와 값의 쌍을 가짐 : {키1: 값1, 키2: 값2, 키3: 값3, ...}/(키1=값1, 키2=값2, 키3=값3, ...)
"""

ar1 = [10,3.1,"TEST"]
print("ar1: {}".format(ar1))

ar2 = [10,20,30,"Ten",3.1]
var1 = ar2[3]
print("var1: {}".format(var1))
print("ar2의 길이: {}".format(len(ar2)))
#리스트구조가 있지만 길이가 얼마인지 모른다. 이떄 마지막 요소의 값 출력
print("ar2의 마지막 요소: {}".format(ar2[-1]))

#기억 : len(리스트) 는 리스트의 길이를 반환하는 함수,정수
tuple1 = (100,"tuple",3.14,200)
print("tuple1: {}".format(tuple1))

ar2[4] = "KOREA"
ar2.append(1000)
print("ar2: {}".format(ar2))

#하지만 튜플은 수정/추가/삭제가 불가능
# tuple1[0] = 1000 오류남!
print("tuple1: {}".format(tuple1))

ar3=ar2[:]

print("ar2: {}".format(ar2))
print("ar3: {}".format(ar3))

chk = ar2 is ar3
print("ar2 is ar3: {}".format(chk))

tuple2 = tuple1[:]
print("tuple1: {}".format(tuple1))
print("tuple2: {}".format(tuple2))

chk = tuple1 is tuple2
print("tuple1 is tuple2: {}".format(chk))


###Set 구조
icecream = {"누가바", "비비빅", "죠스바", "월드콘"}
print(f"icecream의 길이:{len(icecream)},icecream")

#icecream 안에 "누가바"라는 정보가 있는지?
res = "누가바" in icecream
print("\"누가바\" in icecream:", res)

res = "누가바" not in icecream
print("\"누가바\" not in icecream:", res)

#Set 구조의 집합연산을 학습
t1 = set('1234567')
t2 = set('4567890')
print("t1: {}".format(t1))
print("t2: {}".format(t2))

#교집합
res = t1 & t2
print("t1 & t2: {}".format(res))

#합집합
res = t1 | t2
print("t1 | t2: {}".format(res))

d1 = {"name":"홍길동", "age":20, "email":"hong@gmail.com"}
#Dictionary의 키들을 list구조로 얻어내는 법
key_list = list(d1.keys())
print("list(d1.keys()):",key_list)

"""
변경 가능 :(mutable):list, dictionary,set
변경 불가능 :(immutable):tuple,int,float,string,bool
"""

var1 = 100
var2= 200
print("id(var1):",id(var1))
print("id(var2):",id(var2))
print("================================")
var2 = var1
print("id(var1):",id(var1))
print("id(var2):",id(var2))

res = var1 is var2
print("var1 is var2:",res)