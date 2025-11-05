"""
벡터스토어를 활용한 간단한 예제
pip install chromadb
"""

import chromadb

#클라이언트
client = chromadb.Client()
collection = client.create_collection("my_db") # DB(스키마)생성

#문서 추가 - 문서의 내용을 text로 변환해서 저장해야함
collection.add(
    documents=["파이썬은 프로그램이 언어","머신러닝은 인공지능 기술"],
    ids=["doc1","doc2"]
)

#검색
results = collection.query(query_texts=["프로그래밍"],n_results=1)
print(results["documents"])