"""
[메세지]->[ChatPropmtTemplate]->[ChatModel]->[StroutputParser]->[결과]

"""
from langchain_core.prompts import ChatPromptTemplate
from langchain_core.output_parsers import StrOutputParser
from langchain_anthropic import ChatAnthropic
from langchain_core.prompts import HumanMessagePromptTemplate
from langchain_core.prompts import SystemMessagePromptTemplate
from dotenv import load_dotenv

load_dotenv()

#채팅모델 지정
chat_model = ChatAnthropic(model_name="claude-3-5-haiku-latest")

#프롬프트 정의 - 시스템 메세지와 사용자 메세지를 한번에 정의
chat_prompt_tmp = ChatPromptTemplate.from_messages(
    [
        SystemMessagePromptTemplate.from_template("당신은 착실한 ai도우미 입니다. 사용자의 질문에 최대 3줄로 답하세요"),
        HumanMessagePromptTemplate.from_template("{question}")
    ]
)

#출력파서
string_out_parser = StrOutputParser()

#체인 연결
chain = chat_prompt_tmp|chat_model|string_out_parser

#체인에 딕셔너리 입력
result = chain.invoke({"question":"파이썬에서 리스트를 정렬하는 방법은?"})
print(result)
