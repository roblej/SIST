'use client';
import Image from "next/image";
import { useState } from "react";
function Data(){
    let title = "인기과목";
    let ar1 = ['자바바이블 예제','스프링 용어집','ai 어쩌구'];
    let ar2 = ['2025-09-02','2025-09-03','2025-09-04'];
    let [count, setCount] = useState([0,0,0]);
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
                            <div className="fr">
                                <span>{count[i]}</span>&nbsp;
                                <button onClick={function(){
                                    //버튼을 클릭할 떄 마다 수행하는 곳

                                    //일단 useState값 복사
                                    let ar = [...count];
                                    ar[i]++;
                                    setCount(ar);
                                }}>+</button>
                            </div>
                        </header>
                    </div>
                )
            })}
        </div>
    );
}

export default Data;