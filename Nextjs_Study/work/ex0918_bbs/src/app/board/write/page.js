"use client";
import { Button, Table, TableBody, TableCell, TableContainer, TableRow, TextField, TextareaAutosize } from "@mui/material";
import { useState } from "react";
import { useRouter } from "next/navigation";
import axios from "axios";
export default function Write() {

    //서버 url
    const api_url = "/api/bbs/write";
    const router = useRouter();
    //사용자가 입력한 객체 값들을 하나의 객체로 저장할 곳
    const [bbs, setBbs] = useState({
        title: '',
        writer: '',
        content: ''
    });
    const handleChange = (e) => {
        const {name,value} = e.target;
        setBbs({...bbs, [name]: value});
    }
    function sendData() {
        //비동기식 서버통신
        axios.post(api_url,JSON.stringify(bbs),{headers: {'Content-Type': 'application/json'}}).then(function(json){
            console.log(json);
            if(json.data.totalcount > 0)
            router.push('/board');
        });
    }
    return (
        <div style={{width: '80%', margin: '0 auto', padding: '20px'}}>
            <h1>글쓰기</h1>
            <hr/>
            <TableContainer style={{width: '50%', margin: '0 auto', border: '1px solid #e0e0e0', marginTop: '20px'}}>
                <Table>
                    <TableBody >
                        <TableRow>
                            <TableCell>제목</TableCell>
                            <TableCell><TextField label="제목" size="small" name="title" id="title" onChange={handleChange}/></TableCell>
                        </TableRow>
                        <TableRow>
                            <TableCell>작성자</TableCell>
                            <TableCell><TextField label="작성자" size="small" name="writer" id="writer" onChange={handleChange}/></TableCell>
                        </TableRow>
                        <TableRow>
                            <TableCell>내용</TableCell>
                            <TableCell>
                                <TextareaAutosize minRows={10} cols={40} aria-label="내용" name="content" id="content" onChange={handleChange}>
                                </TextareaAutosize>
                            </TableCell>
                        </TableRow>
                        <TableRow>
                            <TableCell><Button variant="contained" color="primary" href="/board">뒤로</Button></TableCell>
                            <TableCell><Button variant="contained" color="primary" onClick={sendData}>저장</Button></TableCell>
                        </TableRow>
                    </TableBody>
                </Table>
            </TableContainer>
        </div>
    );
}