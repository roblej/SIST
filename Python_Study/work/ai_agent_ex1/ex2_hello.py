"""
먼저 Anthropic패키지를 설치하자!
pip install anthropic==0.49.0
"""
import anthropic
import os
from dotenv import load_dotenv

#.env파일 로드
load_dotenv()
client = anthropic.Anthropic(api_key=os.getenv("ANTHROPIC_API_KEY"))

conversation = [] #대화기록을 저장할 곳

#사용자의 입력값(프롬프트)추가
conversation.append({"role":"user","content":"안녕 나는 초보개발자 ten이야"})

response = client.messages.create(
    model="claude-3-5-haiku-latest",
    max_tokens=1000,
    messages=conversation
)

assistant_message = response.content[0].text
print(assistant_message)

#사용자 입력값 추가
conversation.append({"role":"user","content":"내가 누구라고 했지?"})
response = client.messages.create(
    model="claude-3-5-haiku-latest",
    max_tokens=1000,
    messages=conversation
)
print(response.content[0].text)