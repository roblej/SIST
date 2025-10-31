"""
LECL(LangChange Expression Language) : LangChain 표현 언어
Runnableeㅡㄹ을 조합하여 복잡한 로직을 만들게 하는 선언적 언어이다.
예)chain + content1|content2|content3

프롬프트->모델->파서로 이어지는 간단한 예제
"""

import langchain_core
from langchain_core.prompts import ChatPromptTemplate
from langchain_core.output_parsers import StrOutputParser
from langchain_anthropic import ChatAnthropic
import anthropic
import os
import dotenv

dotenv.load_dotenv()

api_key = os.getenv("ANTHROPIC_API_KEY")
prompt = ChatPromptTemplate.from_messages([
    ("human","주어지는 문구에 대하여 50자 안에 짧은 시를 한국어로 작성해줘 :{word}")
])

#모델준비
model = ChatAnthropic(model="claude-3-5-haiku-latest")
parser = StrOutputParser()

chain= prompt | model | parser

result = chain.invoke({"word":"부산"})
print(result)