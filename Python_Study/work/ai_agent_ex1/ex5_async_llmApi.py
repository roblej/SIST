"""
LLM을 사용할 때 가끔은 실패할 때가 있다. 이때 재시도를 하기 위해
다음과 같은 패키지를 설치하고 재 시도를 수행하도록 유도해야 한다.

pip install tenacity
"""
import asyncio
import os
from anthropic import AsyncAnthropic
from dotenv import load_dotenv
import logging
import random
import atexit
import sys
from tenacity import retry, stop_after_attempt, wait_exponential, retry_if_exception_type
logging.basicConfig(level=logging.INFO)
logger = logging.getLogger(__name__)

load_dotenv()

api_key = os.getenv("ANTHROPIC_API_KEY")
if not api_key:
    raise ValueError("ANTHROPIC_API_KEY가 설정되지 않았음")

async def simple_random_failure():
    #50% 확률로 예외를 발생시키는 임의의 메서드
    if random.random() < 0.5:
        logger.warning("인위적으로 API호출 실패 발생")
        raise ConnectionError("인위적으로 발생시킨 연결오류")
    #약간의 시간을 지연시킨다.
    await asyncio.sleep(random.uniform(0.1,0.5)) # 0.1~0.5 사이

#tenacity를 사용한 재시도 데코레이터 적용
@retry(
    retry=retry_if_exception_type(), # 모든 예외에 대해 재시도
    wait=wait_exponential(multiplier=1,min=2,max=10), #재시도 시간 지연 계산
                            #기본단위 : 1초, 최소대기:2초, 최대대기:10초
    stop= stop_after_attempt(3), # 최대 재시도 3회
    before_sleep =lambda retry_state:logger.warning(
        f"API호출 실패: {retry_state.outcome.exception()},"
        f"{retry_state.attempt_number}번째 재시도중...."
    )
)
async def call_claude(prompt: str,model: str = "claude-3-5-haiku-latest") -> str:
    #claude API를 비동기식으로 호출
    logger.info(f"claude api호출 시작:{model}")
    #핵심: async with 를 사용하여 클라이언트 자동정리 
    async with AsyncAnthropic(api_key=api_key) as client:
        response = await client.messages.create(
            model= model,
            messages=[{"role":"user","content":prompt}],
            max_tokens=1000
            )
        logger.info(f"Claude API 호출 완료:{model}")
        return response.content[0].text
    
async def main():
    print("동시에 API 호출하기(재시도 로직 포함)")
    prompt = "ec2에서 상태검사는 모두 통과이고 포트도 열어줬는데 ssh연결이 되지 않는 이유는 뭘까?"
    result = call_claude(prompt)
    print(result)

    try:
        #gather는 전체 작업중 하나라도 실패하면 예외 발생
        claude_response = await asyncio.gather(result,return_exceptions=False)
        print(f"claude api 호출 완료:{claude_response[0]}")
    except Exception as e:
        logger.error(f"calude api 호출 실패: {e}")


def setup_clean_exit():
    #Windows에서 깔끔한 프로그램 종료를 위한 설정
        if sys.platform =="win32":
            asyncio.set_event_loop_policy(asyncio._WindowsProactorEventLoopPolicy())
            def cleanup():
                try:
                    loop = asyncio.get_event_loop()
                    if not loop.is_closed():
                        #실행중인 모든 태스크 취소
                        tasks = asyncio.all_tasks(loop)
                        for task in tasks:
                            task.cancel()

                        #취소된 태스크들 완료 대기
                        if tasks:
                            loop.run_until_complete(
                                asyncio.gather(*tasks, return_exceptions=true)
                            )
                        loop.close()
                except:
                    pass #정리과정에서 에러는 무시
            atexit.register(cleanup)

if __name__ == "__main__":
    setup_clean_exit()
    try:
        #메인 함수 실행
        asyncio.run(main())
    except KeyboardInterrupt:
        logger.info("프로그램이 중단되었습니다.")
    finally:
        logger.info("프로그램 종료!")