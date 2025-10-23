from pandas import Series,DataFrame

ar = [
    {"id":1010,"name":"마루치","java":100,"Python":82,"fast":80},
    {"id":4010,"name":"마치","java":70,"Python":89,"fast":50},
    {"id":2010,"name":"마루치","java":50,"Python":62,"fast":90},
    {"id":6010,"name":"마루치","java":80,"Python":68,"fast":80},
]
df = DataFrame(ar)
print(df)
print("총점[Total]컬럼 추가")
df["Total"] = df["java"]+df["Python"]+df["fast"]
print(df)
print("---------평균[Ave]컬럼 추가------------")
df["Ave"]  =(df["Total"]/3).round(2)
print(df)
print("--------------------")
"""
다음의 조건으로 등급(grade)fㅡㄹ 지정하자
[조건]
    평균이 96점 이상이면 'A+'
    90~95 A
    86~89 B+
    80~85 B
    76~79 C+
    70~75 C
    66~69 D+
    60~65 D
      ~59 F
"""
grades = []

for var in df["Ave"]:
    if var>95:
        grades.append("A+")
    elif(var>89):
        grades.append("A")
    elif(var>85):
        grades.append("B+")
    elif(var>79):
        grades.append("B")
    elif(var>75):
        grades.append("C+")
    elif(var>69):
        grades.append("C")
    elif(var>65):
        grades.append("D+")
    elif(var>59):
        grades.append("D")
    else:
        grades.append("F")
df["grade"] = grades

print(df)