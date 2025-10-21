"""
초기(생성)자 : def __init__(self) -> 클래스의 인스턴스를 만드는 코드가 실행되는 시점에 __init__ 메서드가 자동으로 호출되어 객체의 초기화를 진행
소멸자 : def __del__(self) -> 메모리에서 해당 객체를 참조하는 변수가 하나도 없을 때 호출

위는 생략되어 있어서 보이진 않지만 자동으로 정의된다.
"""
class MyClass: # 클래스 정의 시작
    def setName(self,n): # 멤버메서드(기능,동작)
        self.name = n # 현재객체가 가지고있는 name이라는 변수에  인자 n의 값을 대입
        
    def getName(self): # 멤버메서드
        return self.name