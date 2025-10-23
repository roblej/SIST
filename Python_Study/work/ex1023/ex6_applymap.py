from pandas import Series, DataFrame
import numpy as np

df = DataFrame([
    {'name':'홍길동', 'job':'개발1'},
    {'name':'마루치', 'job':'개발3'},
    {'name':'아라치', 'job':'개발2'},
    {'name':'일지매', 'job':'개발1'}
])

print(df)
print('-------------------------')
"""
머신러닝을 하다보면 특정 컬럼의 문자열 값을 숫자로 변경해야하는 경우가 생긴다.
"""
df.job = df.job.map({'개발1':1,'개발2':2,'개발3':3})
print(df)

df2 = DataFrame([
    {'x':3.2, 'y':-2.8, 'z':-2.1},
    {'x':-3.9, 'y':3.8, 'z':-3.1},
    {'x':-1.2, 'y':-4.8, 'z':-3.3},
])

print(df2.applymap(np.around))