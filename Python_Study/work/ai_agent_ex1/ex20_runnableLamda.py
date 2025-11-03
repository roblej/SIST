from langchain_core.prompts import ChatPromptTemplate
from langchain_core.output_parsers import StrOutputParser
from langchain_core.runnables import RunnablePassthrough,RunnableParallel,RunnableLambda
from langchain_anthropic import ChatAnthropic
import anthropic
import os
from dotenv import load_dotenv

load_dotenv()
api_key = os.getenv("ANTHROPIC_API_KEY")

prompt = ChatPromptTemplate.from_messages([
    ("human","주어지는 '{word}'와 유사한 단어를 3개를 나열해줘. 단어만 부탁해!")
])

#모델정의
model = ChatAnthropic(model="claude-3-5-haiku-latest")
parser = StrOutputParser()

#병렬처리
chain = RunnableParallel(
    sysnonyms=prompt | model | parser, # 유사단어 분석
    word_count=RunnableLambda(lambda x:len(x["word"])), # 단어 수 계산
    uppercase=RunnableLambda(lambda x:x["word"].upper())
)
result = chain.invoke({"word":"spring"})
print(result)