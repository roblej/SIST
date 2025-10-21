fs = open("ex1_test.txt","rb")
content = fs.read()
print(content)
print(content.decode("utf-8")) # 파일의 원래 형식대로 decode 시켜서 출력함