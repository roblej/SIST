"use client";
import { useState, useEffect } from "react";
import axios from "axios";
import { Button, Card, CardContent, Divider } from "@mui/material";

export default function View({params}) {
    const api_url = "/memo/view?idx=" + params.idx;
    const [vo, setVO] = useState({});
    useEffect(() => {
        axios.get(api_url).then(function(response){
            setVO(response.data.m_view);
        });
    }, [params.idx]);

    return (
        <Card style={{ width: '500px', margin: '40px auto' }}>
            <CardContent>
                <p><strong>idx:</strong> {vo.idx}</p>
                <p><strong>작성자:</strong> {vo.writer}</p>
                <p><strong>내용:</strong> {vo.content}</p>
                <p><strong>등록일:</strong> {vo.reg_date}</p>
                <p><strong>IP:</strong> {vo.ip}</p>``
                <Divider/>
                <Button variant="contained" color="error">뒤로</Button> &nbsp;
                <Button variant="contained" color="error">수정</Button> &nbsp;
                <Button variant="contained" color="error">삭제</Button>
            </CardContent>∏
        </Card>
    );
}