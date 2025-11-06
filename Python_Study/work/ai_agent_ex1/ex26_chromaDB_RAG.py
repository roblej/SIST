"""
간한단 RAG 시스템을 구현한 예제!
즉, 저장된 문서에서 관련 내용을 찾아(LangChain의 벡터DB역할)
-> claude에게 질문을 전달하여 답변을 생성하는 구조
"""
import chromadb
import anthropic
import os
from dotenv import load_dotenv

os.environ["TOKENIZERS_PARALLELISM"] = "false"
load_dotenv()

class ChromaRAG:
    def __init__(self,claude_api_key):
        self.claude= anthropic.Anthropic(api_key=claude_api_key)
        self.client= chromadb.Client()
        self.collection= self.client.create_collection("knowledge") #문서저장소 생성

    def add_docs(self,texts): # 문서들을 doc_0,doc_1,... 형식으로 추가
        ids= [f"doc_{i}" for i in range(len(texts))]
        self.collection.add(documents=texts, ids=ids)

    def ask(self,question): # 질문을 받고 아래 형식으로 답변을 생성
        # 1. 벡터 검색
        results = self.collection.query(
            query_texts=[question],
            n_results=3
        )

        # 2. context구성(검색된 문서내용들을 합쳐서 클로드에 보낼 문맥)
        context = "\n".join(results["documents"][0])

        # 3. 클로드에 질문
        response = self.claude.messages.create(
            model = "claude-3-5-haiku-latest",
            max_tokens=200,
            messages=[{
                "role":"user",
                "content":f"컨텍스트:{context}\n\n질문:{question}"
            }]
        )
        return response.content[0].text

#사용
reg = ChromaRAG(os.getenv("ANTHROPIC_API_KEY"))
reg.add_docs(["파이썬은 프로그래밍 언어","AI는 미래기술","AI-Agent는 두뇌가 있어"])

# answer = reg.ask("파이썬이 뭐야?")
msg = input("질문:")
answer= reg.ask(msg)
print(answer)