import BbsTR from "@/components/bbsTR";
export default function Bbs(){
    return (
        <div>
            <h1 className="title">게시판</h1>
            <hr/>
            <div className="t1">
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
                    {/* JSX주석
                    --다음은 컴포넌트를 활용한 예다.
                    */}
                    <BbsTR/>
                    <BbsTR/>
                    <BbsTR/>
                    <BbsTR/>
                    <BbsTR/>
                    <BbsTR/>
                </tbody>
            </div>
        </div>
    );
}