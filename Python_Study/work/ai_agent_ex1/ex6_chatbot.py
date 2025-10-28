import anthropic
import os
from dotenv import load_dotenv

load_dotenv()
api_key = os.getenv("ANTHROPIC_API_KEY")

client = anthropic.Anthropic(api_key=api_key)

def chatbot_response(msg:str):
    respnonse = client.messages.create(
        model="claude-3-5-haiku-latest",
        max_tokens=1024,
        messages=[
            {"role":"user","content":msg}
        ]
    )
    return respnonse.content[0].text

if __name__=="__main__":
    while True:
        user_message = input("메시지:")
        # 위 user_message가 "exit"이면 종료하자!
        if user_message.lower() == "exit":
            print("대화를 종료합니다.")
            break
        #exit가 아니면 사용자가 입력한 문자열을
        #chat_response함수를 호출하면서 인자로 전달한다.
        result = chatbot_response(user_message)
        print("챗봇: "+result)