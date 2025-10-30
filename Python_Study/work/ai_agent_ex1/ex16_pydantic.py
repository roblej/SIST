"""
Pydantic은 LLM에게 모델을 지정하여 해당 스키마를 기반으로 응답형식을 지정할 수 있다.
pip install pydantic
"""

from pydantic import BaseModel,Field
from langchain.chat_models import init_chat_model
from dotenv import load_dotenv

load_dotenv()

llm = init_chat_model("claude-3-5-haiku-latest",model_provider="Anthropic")
class MovieReview(BaseModel):
    """영화 리뷰 스키마"""
    title:str = Field(description="영화제목")
    rating:float = Field(description="10점 만점에 평점(ㄷx:7.5)")
    review:str = Field(description="리뷰내용(3~4문장")

#모델에 스키마를 바인딩
structed_llm = llm.with_structured_output(MovieReview)

#llm의 실행 결과가 ModelReview타입으로 넘어옴
result:MovieReview = structed_llm.invoke(
    "영화 '아이언맨'에 대한 리뷰를 작성해줘"
)
print("영화제목 :",result.title)
print("영화평점 :",result.rating)
print("리뷰내용 :",result.review)
