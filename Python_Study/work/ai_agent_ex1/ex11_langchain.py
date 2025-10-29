"""
    langchain은 LLM을 효과적으로 활용하기 위한 프레임워크
    언어로는 python과 js를 지원한다.
    - 파이썬 : https://github.com/langchain-ai/langchain
    - JS : https://github.com/langchain-ai/langchainjs

    랭체인의 핵심은
    프롬프트, 벡터스토어,아웃풋파서,메모리,LLM도구 등을
    체인형태로 연결하여 다양하고 복잡한 작업을 단순화시킨다

    랭체인 모델은 LLM종류에 따라 다르다.
    [openAPI] : pip install langchain[openapi]==0.3.27
    [antropic] : pip install langchain[antropic]==0.3.27
    [gemini] : pip install -q -u google-gemini
        -q : quite모드(설치 과정을 간략하게 표시)
        -U : upgrade(이미 설치된 경우 최신 버전으로 업그레이드)
    [google langchain모듈] : pip install langchain-google-genai
"""

from dotenv import load_dotenv
from langchain.chat_models import init_chat_model
import random

load_dotenv()

if(random.random() < 0.5):
   print("Using other AI model")
else:
   model = init_chat_model("claude-3-5-haiku-latest",model_provider="anthropic")
   result = model.invoke("RAG가 뭐야?")
print(result)