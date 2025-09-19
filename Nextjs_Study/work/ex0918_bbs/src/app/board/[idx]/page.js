"use client";
import Link from "next/link";
import styles from "../../page.module.css";
import { useState, useEffect } from "react";
import axios from "axios";
import { useParams } from "next/navigation";
import { Table, TableBody, TableCell, TableContainer, TableRow } from "@mui/material";



export default function Page() {
    //비동기식 통신을 수행하는 함수
    const {idx} = useParams();
    const api_url = `/api/bbs/${idx}`;
    const [list, setList] = useState([]);
    function getBbs() {
        axios.get(api_url).then(function(json){
            if(json.data.totalcount > 0)
            setList(json.data.data);
        console.log(json.data);
        });
    }

    useEffect(() => {
        getBbs();
    }, [idx]);
    
    return (
        <div>
            <h1>게시판</h1>
            <hr/>
            <div style={{position: 'relative' , width: '80%', margin: '0 auto'}}>


            <TableContainer style={{width: '50%', margin: '0 auto', border: '1px solid #e0e0e0', marginTop: '20px'}}>
                <Table>
                    <TableBody>
                        <TableRow>
                            <TableCell>제목</TableCell>
                            <TableCell>
                                {list.title}
                            </TableCell>
                        </TableRow>
                        <TableRow>
                            <TableCell>작성자</TableCell>
                            <TableCell>
                                {list.writer}
                            </TableCell>
                        </TableRow>
                        <TableRow>
                            <TableCell>작성일</TableCell>
                            <TableCell>
                                {list.write_date}
                            </TableCell>
                        </TableRow>
                        <TableRow>
                            <TableCell>조회수</TableCell>
                            <TableCell>
                                {list.hit}
                            </TableCell>
                        </TableRow>
                        <TableRow>
                            <TableCell>내용</TableCell>
                            <TableCell style={{whiteSpace: 'pre-line'}}>
                                {list.content}
                            </TableCell>
                        </TableRow>
                        <TableRow>
                            <TableCell colSpan={2}>
                                <Link href="/board">
                                    <button type="button">뒤로</button>
                                </Link>
                            </TableCell>
                        </TableRow>
                    </TableBody>
                </Table>
            </TableContainer>
            </div>
        </div>
    );
}