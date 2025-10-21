import pandas as pd
df = pd.read_csv("data/test_data.tsv", sep="\s+") # 각 열이 탭으로 구분되었다
print(df)
print(df.head(2))
print(df.tail(2))
print(df['year'])
