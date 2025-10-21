"""
파이썬에 파일을 읽기/쓰기 하는 방법
- 파일을 열기(open)했으면 반드시 닫기(close) 해야함
    (파일을 열기 할 때는 반드시 읽기를 위함인지? 쓰기를 하기 위함인지?를 명시해야함)
- mode는 다음과 같이 구분된다
    w : 쓰기
    r : 읽기
    a : 추가
    rb : 바이너리로 읽기
"""

fs = open("ex1_test.txt","r") # 파일 연경
content = fs.read() # 파일로부터 데이터를 모두 읽어서
                    # 변수 ㅊontent에 저장
fs.close() # 파일과 연결된 객체를 닫기
print(content)
# print("-----------------------------------")
# fs = open("ex2_test2.txt","r")
# content = fs.read()
# fs.close
# print(content)