fs = open("ex1_test.txt","r") # 파일과 연결

while True:
    content = fs.readline() # 파일로부터 데이터를 한줄만 받아옴
    if(content != ""):
        print(content, end=" ")
    else:
        break
fs.close()
print("파일 읽기 끝")