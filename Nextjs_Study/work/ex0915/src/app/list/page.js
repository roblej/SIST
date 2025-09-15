function List(){
    let title = "방명록";
    let data = [
        {
            "title": "자바 바이블",
            "date": "2025-09-02",
            "writer": "홍길동",
            "content": "자바 바이블에 대한 방명록 내용입니다."
        },
        {
            "title": "스프링 용어집",
            "date": "2025-09-03",
            "writer": "김철수",
            "content": "스프링 용어집에 대한 방명록 내용입니다."
        },
        {
            "title": "ai 어쩌구",
            "date": "2025-09-04",
            "writer": "이영희",
            "content": "ai 어쩌구에 대한 방명록 내용입니다."
        }
    ];
    
    return (
        <div>
            <h2 className="title">{title}</h2>
            <hr/>
            <div className="list-bg">
                {/* ar1이라는 배열의 요소들을 data라는 변수에 전달하면서 반복하는 문장 */
                data.map(function(item,i){
                    return (
                        <div className="list-item" key={i}>
                                <h4>{item.title}</h4> {/* 글 제목 */}
                                <p>{item.date}</p> {/* 날짜 */}
                                <p>{item.writer}</p> {/* 작성자 */}
                                <p>{item.content}</p> {/* 내용 */}
                        </div>
                    )
                })}
            </div>
        </div>
    );
}

export default List;