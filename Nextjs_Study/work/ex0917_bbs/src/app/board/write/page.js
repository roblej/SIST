'use client';

import { Table, TableBody, TableCell, TableContainer, TableRow, Paper, Button } from "@mui/material";
import { useRouter } from "next/navigation";
import { useState } from "react";
import axios from "axios";

export default function Write(){
    const router = useRouter();
    const api_url = "/board/add";

    //서버로 보낼 파라미터 값들을 객체로 준비한다.
    const [vo,setVO] = useState({
        subject:"",
        writer:"",
        content:""
    });
    function changeVO(e){
        //목적은 useState의 vo객체를 변경하는 것이다.
        //그렇다면 기존 vo객체를 복사하고 복사한 객체의 특정 프로퍼티를 변경하면 된다.
        //...vo : 기존 vo객체를 복사한다.
        //[e.target.name]:e.target.value : 복사한 객체의 특정 프로퍼티를 변경한다.
        let bbs = {...vo};
        //e.target.value : 입력한 값
        let value = e.target.value;
        //e.target.name : 입력한 값의 이름
        let name = e.target.name;
        bbs[name] = value;
        setVO(bbs);
    }
    function saveData(){
        console.log(vo);
        axios.post(
            api_url,
            {
                subject:vo.subject,
                writer:vo.writer,
                content:vo.content,
                bname:"BBS"
            }
        ).then(function(res){
            if(res.data.cnt ==1){
                router.push("/board");
            }else{
                alert("저장 실패");
            }
        });
    }
    return(
        <div style={{width:'80%',margin:'auto',padding:'20px',textAlign:'left'}}>
            <TableContainer component={Paper}>
                <Table sx={{ minWidth: 650 }}>
                    <TableBody>
                        <TableRow>
                            <TableCell>제목</TableCell>
                            <TableCell>
                                <input type="text" name="subject" onChange={changeVO}/>
                            </TableCell>
                        </TableRow>
                        <TableRow>
                            <TableCell>글쓴이</TableCell>
                            <TableCell>
                                <input type="text" name="writer" onChange={changeVO}/>
                            </TableCell>
                        </TableRow>
                        <TableRow>
                            <TableCell>내용</TableCell>
                            <TableCell>
                                <textarea name="content" rows={7} cols={50} onChange={changeVO}/>
                            </TableCell>
                        </TableRow>
                        <TableRow>
                            <TableCell calspan={2}>
                                <Button variant="contained" color="primary" onClick={saveData}>저장</Button>
                            </TableCell>
                        </TableRow>
                    </TableBody>
                </Table>
            </TableContainer>
        </div>
    );
}