from pandas import Series,DataFrame

emp_list = [{ "empno":100,"ename":"마루치","job":"DEV"},
    { "empno":110,"ename":"마루","job":"DEV"},
    { "empno":120,"ename":"마루마","job":"DEV"}]
df = DataFrame(emp_list)
print(df)
print("------------행 삭제------------------")
print(df.drop([0,2]))
print(df) # 실제 값에는 영향끼치지 않ㅇ므
print("------------job이 ceo인 삭제------------------")
print(df[df.job != "CEO"])
# 진짜 삭제 -> df = df[df.job != "CEO"]
 