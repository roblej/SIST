"""
클로드는 임베딩을 지원하지 않아 Hugging Face임베딩을 연결하여 무료로 만들 수 있다. 먼저 라이브러리를 설치
pip install protobuf==3.20.3
pip install tesorflow==2.12.0
"""

import os
os.environ['PROTOCOL_BUFFERS_PYTHON_IMPLEMENTATION'] = 'python'
#환경변수 지정~!
#허깅페이스 관련 라이브러리를 사용할 때 호환성 문제를 피하기 위해 설정함
#허깅페이스는 내부적으로 Google의 Protocol Bufferse(protobuf)를 C++로
#기본 설정 되어있는것을 순수 python버전을 사용한다고 지정함

from langchain_core.prompts import ChatPromptTemplate
from langchain_anthropic import ChatAnthropic

import numpy as np
from dotenv import load_dotenv

load_dotenv()

#간단한 임베딩 대안 : 단어 기반 유사도 계산
def simple_word_similarity(query,words):
    """간단한 단어 기반 유사도 계산"""
    similarities = []

    #한국어 동물 관련 키워드
    animal_keywords = ["동물","강아지","고양이","개","펫","애완동물","생물"]
    vehicle_keywords = ["차","자동차","비행기","교통","운송","기계","바이크"]

    for word in words:
        if any(keyword in word for keyword in animal_keywords):
            if "강아지" in word or "고양이" in word:
                score = 0.9 # 직접적인 동물
            else:
                scord = 0.7
        elif any(keyword in word for keyword in vehicle_keywords):
            score = 0.2 # 동물과 관련없음
        else:
            score = 0.1

        similarities.append((word,score))

    return similarities

words = ["강아지","자동차","비행기","고양이","바둑이"]
query = "동물"

similarities = simple_word_similarity(query,words)

print(f"'{query}'의 유사도는 :")
for word,similarity in similarities:
    print(f"{word}: {similarity:.3f}")

print("----클로드에게 분석해달라고하면?----")
claude = ChatAnthropic(
    model = "claude-sonnet-4-20250514",
    # anthropic_api_key=os.getenv("ANTHROPIC_API_KEY")
)

#claude 결과 분석
prompt = ChatPromptTemplate.from_messages([
    ("human","""
     다음은 간단한 규칙 기반으로 계산한 '{query}'단어와 각 단어들 간의 유사도입니다.

     {results}
     
     이 결과에 대해 분석하고,실제 의미적 유사도와 비교해서 설명해주세요.
     더 정확한 유사도를 위해서는 어떤 방법들이 있는지도 설명해주세요.
     """)
])

results_str ="\n".join([f"{word}:{sim: .3f}" for word, sim in similarities])

chain = prompt | claude
response = chain.invoke({
    "query":query,
    "results": results_str
})
print("\n----- 클로드 분석 끝 -----")
print(response.content)