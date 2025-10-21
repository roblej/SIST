import pandas as pd
from pandas import Series, DataFrame
ko = pd.Series([1232,2314,4213412,51254])
print(ko)
print("index값 변경")
ko = Series([1232,2314,4213412,51254],index=['10-02','10-03','10-04','10-05'])
print(ko)
print("index값 출력")
for day in ko.index:
    print(day) # index만 출력
print("value값 출력")
for day in ko.values:
    print(day) # index만 출력