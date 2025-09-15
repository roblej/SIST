import Image from "next/image";
function Data(){
    let title = "자료실";
    let ar1 = ['자바바이블 예제','스프링 용어집','ai 어쩌구'];
    let ar2 = ['2025-09-02','2025-09-03','2025-09-04'];

    return (
        <div>
            <h2 className="title">{title}</h2>
            <hr/>
            {/* ar1이라는 배열의 요소들을 data라는 변수에 전달하면서 반복하는 문장 */
            ar1.map(function(data,i){
                return (
                    <div className="box" key={i}>
                        <header>
                            <h4>{data}</h4>
                            <p>{ar2[i]}</p>
                            <Image src={`/img/book${[i+1]}.png`} alt={data} width={130} height={180}/>
                        </header>
                    </div>
                )
            })}
        </div>
    );
}

export default Data;