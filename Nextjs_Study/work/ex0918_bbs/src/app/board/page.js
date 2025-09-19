"use client";
import { Button, Table, TableBody, TableCell, TableContainer, TableHead, TableRow } from "@mui/material";
import Link from "next/link";
import styles from "../page.module.css";
import { useState, useEffect } from "react";
import axios from "axios";
import BbsTR from "../../components/BbsTR";



export default function Board() {
    //비동기식 통신을 수행하는 함수
    const api_url = "/api/bbs";
    const [list, setList] = useState([]);
    function getBbsList() {
        axios.get(api_url).then(function(json){
            if(json.data.totalcount > 0)
            setList(json.data.data);
        console.log(json.data);
        });
    }

    useEffect(() => {
        getBbsList();
    }, []);
    
    return (
        <div>
            <h1>게시판</h1>
            <hr/>
            <div style={{position: 'relative' , width: '80%', margin: '0 auto'}}>


                <table className="t1">
                    <thead>
                        <tr>
                            <td colSpan={5} className={styles.no_border}>
                                <Link href="/board/write">
                                    <button type="button">글쓰기</button>
                                </Link>
                            </td>
                        </tr>
                        <tr>
                            <th>기본키</th>
                            <th>제목</th>
                            <th>작성자</th>
                            <th>작성일</th>
                            <th>조회수</th>
                        </tr>
                    </thead>
                    <tbody>
                    {list.map((item,i) => (
                        <BbsTR key={i} b_idx={item.b_idx} title={item.title} writer={item.writer} write_date={item.write_date} hit={item.hit} />
                        ))}
                    </tbody>
                </table>
            </div>
        </div>
    );
}