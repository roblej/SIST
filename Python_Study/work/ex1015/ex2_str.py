str = 'go fot it!'
print("str=%s" %str)

test = str*3 # str이 기억하는 문자열을 3번 반복해서 변수 test에 저장
print("test={}".format(test))

test2 = test.replace("it","1000")
print("test2={}".format(test2))
print("test2: %s" %test2)

v1 = str[3]
print("str[3]: %s" %v1)
#자바의 substring(3,6)와 동일한 기능을 하는 메소드
v2 = str[3:6]
print("str[3:6]: %s" %v2)

#자바의 indexOf("it")와 동일한 기능을 하는 메소드
idx = str.find("it")
print("str.find(\'it\'): {}".format(idx))

