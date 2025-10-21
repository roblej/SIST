import random

lotto = set()
while True:
    value = random.choice(range(1,45))
    lotto.add(value)
    if len(lotto) == 6:
        break # lotto의 길이가 6이 될 때 탈출
print("lotto",lotto)