dan = input("단: ")
dan = int(dan)
for i in range(1,10):
    print("{}*{}={}".format(dan,i,i*dan), end=" ")
print("----------------------")
for i in range(1,10):
    for j in range(2,10):
        print("{}*{}={}\t".format(j,i,i*j), end=" ")
    print()