from pandas import Series,DataFrame
df = DataFrame([
    {'b_day':'1999-10-23'},
    {'b_day':'2009-10-28'},
    {'b_day':'1998-1-13'},
    {'b_day':'1992-10-2'}
])
print(df)
print("--------------")
def clip_year(col):
    return col.split('-')[0]

df['year'] = df['b_day'].apply(clip_year) #clip_year(df['d_day])
#즉 apply함수를 붙이면 앞의 컬럼 값이 우선 인자로 전달된다
print(df)
print("--------------")

def get_age(year,c_year):
    return c_year - int(year) # 현재 년도에서 생년을 뺀 나이

df['age'] = df['year'].apply(get_age, c_year = 2025)
            #첫번째 인자                   #두번째 인자
print(df)
print("------함수 호출시 인자를 행 전체를 전달--------")
def get_age2(row):
    return str(row.year)+"년생은"+str(row.age)+"세"
df['etc'] = df.apply(get_age2,axis=1)
print(df)

