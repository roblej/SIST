"""
pip install -U langgraph langsmith grandalf

랭그래프는 랭체인에서 개발한 Agent오케스트레잇녀 프레임워크다.
즉, 그래프 이론(Graph Theory)기반의 워크플로우(흐름 제어 구조)를 의미함!
- 랭그래프의 핵심 개념
1) 상태 : 실행과정에서 지속적으로 유지되는 데이터로 각 노드(함수)가 실행될 때 마다 읽기/쓰기가 가능한 (데이터 저장소)
2) 노드 : 기본 실행단위(함수나 Agent)
3) 에지 : 노드간의 연결 정의, 실행 흐름제어
    - 일반 에지 : 항상 같은 경로로 진행
    - 조건부 에지 : 상태에 따라 다른 노드로 분기

간단한 랭그래프 예제
start --> greeting --> processing --> end
"""

from typing import Dict, Any
from langgraph.graph import StateGraph, START, END
from pydantic import BaseModel, Field

#워크플로우 단계정의
class WorkflowSetup:
    GREETING = "Greeting"
    PROCESSING = "Processing"

#그래프의 상태 스키마 정의
class WorkflowState(BaseModel):
    name: str = Field(default="",description="사용자 이름")
    greeting: str = Field(default="",description="인사말")
    processed_message: str = Field(default="",description="최종 메세지")
    
#첫번째 노드함수 - 인자인 state는 워크플로우 전체에 공유되는 현재 상태값
#  (데이터 저장소) 이곳에서 name을 읽어 - 인사문장을 만들고  다음 노드가 사용할 수 있도록 반환!
def generate_greeting(state:WorkflowState) -> Dict[str, Any]:
    name = state.name or "Guest"
    greeting = f"안녕하세요, {name}님! Welcome to Langgraph."
    print(f"[generate_greeting] 인사말 생성: {greeting}")
    return {"greeting":greeting} # state에 greeting으로 저장툄

# 두번째 노드함수 : 인사말을 처리하고 최종 메시지 생성
def process_greeting(state: WorkflowState) -> Dict[str, Any]:
    greeting = state.greeting
    processed_message = f"{greeting} LangGraph에 오신것을 환영합니다."
    print(f"[process_greeting] 최종 메시지 생성: {processed_message}")
    return {"processed_message":processed_message}

# 랭그래프를 생성
def create_hello_graph():
    workflow = StateGraph(WorkflowState) # 상태

    # 노드 추가
    workflow.add_node(WorkflowSetup.GREETING, generate_greeting)
    workflow.add_node(WorkflowSetup.PROCESSING, process_greeting)

    #에지로 시작노드 추가
    workflow.add_edge(START,WorkflowSetup.GREETING)

    #에지로 노드들 연결
    workflow.add_edge(WorkflowSetup.GREETING,WorkflowSetup.PROCESSING)

    #에지로 종료노드 추가
    workflow.add_edge(WorkflowSetup.PROCESSING,END)

    #랭그래프 컴파일러생성
    app = workflow.compile()
    return app

def main():
    print("=== LangGraph ===\n")
    app = create_hello_graph()

    initial_state = WorkflowState(name ="마루치",greeting="",processed_message="")
    print(f"초기상태: {initial_state.model_dump()}\n")

    print("=== LangGraph start===\n")
    # 실행
    final_state= app.invoke(initial_state)

    print("\n=== 랭그래프 종료 ===")
    print(f"\n최종상태: {final_state}")
    print(f"\n최종메시지: {final_state['processed_message']}")

if __name__ == "__main__":
    main()

