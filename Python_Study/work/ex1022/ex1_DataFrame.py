"""
딕셔너리를 가지고 한 사원의 정보를 만들어보자
"""

from pandas import Series,DataFrame

emp_list = [{ "empno":100,"ename":"마루치","job":"DEV"},
    { "empno":110,"ename":"마루","job":"DEV"},
    { "empno":120,"ename":"마루마","job":"DEV"}]
df = DataFrame(emp_list)
print(df)