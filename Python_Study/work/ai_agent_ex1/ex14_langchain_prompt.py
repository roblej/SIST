from langchain_core.prompts import ChatPromptTemplate
from langchain_core.output_parsers import StrOutputParser
from langchain_anthropic import ChatAnthropic
from dotenv import load_dotenv

load_dotenv()

chat_model = ChatAnthropic(model="claude-3-5-haiku-latest")

#프롬프트 정의 - 시스템 메세지와 사용자 메세지를 한번에 정의
chat_prompt_tmp = ChatPromptTemplate.from_messages(
    [
        ("system","당신은 착실한 ai도우미 입니다. 사용자의 질문에 최대 3줄로 답하세요"),
        ("human","{question}")
    ]
)
#출력파서 정의
string_output_parser = StrOutputParser()

#체인으로 연결
chain = chat_prompt_tmp|chat_model|string_output_parser

msg = input("질문:")
#체인에 딕셔너리 입력
result = chain.invoke({"question":msg})
print(result)