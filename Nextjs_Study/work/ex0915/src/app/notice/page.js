import NoticeTR from "@/components/noticeTR";
export default function notice(){
    let subject = ["나에게도 행복을", "가을", "겨울", "봄", "여름", "겨울"];
    return (
        <div>
            <h1 className="title">게시판</h1>
            <hr/>
            <table className="t1">
                <thead>
                    <tr>
                        <th>번호</th>
                        <th>제목</th>
                        <th>작성자</th>
                        <th>작성일</th>
                        <th>조회수</th>
                    </tr>
                </thead>
                
                <tbody>
                    {/* 다음은 컴포넌트를 활용한 예다. */}
                    <NoticeTR subject={subject[0]} writer="Michael" date="2025-09-15" num={1}/>
                    <NoticeTR subject={subject[1]} writer="이영희" date="2025-09-14" num={2}/>
                    <NoticeTR subject={subject[2]} writer="박철수" date="2025-09-13" num={3}/>
                    <NoticeTR subject={subject[3]} writer="최영희" date="2025-09-12" num={4}/>
                    <NoticeTR subject={subject[4]} writer="이영희" date="2025-09-11" num={5}/>
                    <NoticeTR subject={subject[5]} writer="박철수" date="2025-09-10" num={6}/>


                </tbody>
            </table>
        </div>
    );
}