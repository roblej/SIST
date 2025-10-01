"use client";

import { useState, useEffect } from "react";
import axios from "axios";
import MyTable from "../component/MyTable";

export default function Page() {
    const api_url = "/api/emp/all"
    //서버로부터 전달되어오는 자원을 저장할곳
    const [list, setList] = useState([]);

    //서버를 비동기식 통신하는 함수
    function getData(){
        axios.get(api_url).then(response => {
            //response는 스프링부트쪽에서 보낸 정보다
            //스프링에서 보낸 실제 자원은 data에 담겨있다.
            setList(response.data.ar);
        })
    }

    useEffect(() => {
        getData();//실제 서버를 통신하는 함수
    }, []);

    return (
        <div className=";ist-bg">
            <MyTable ar={list}/>
        </div>
    );
}
