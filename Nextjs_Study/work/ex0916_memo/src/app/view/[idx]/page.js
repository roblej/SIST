"use client";
import { useState, useEffect } from "react";
import axios from "axios";
import { Card, CardContent } from "@mui/material";

export default function View({params}) {
    const api_url = "/memo/view?idx=" + params.idx;
    const [memo, setMemo] = useState({});
    useEffect(() => {
        axios.get(api_url).then(function(response){
            setMemo(response.data.m_view);
        });
    }, [params.idx]);

    return (
        <Card style={{ width: '500px', margin: '40px auto' }}>
            <CardContent>
                <p><strong>idx:</strong> {memo.idx}</p>
                <p><strong>작성자:</strong> {memo.writer}</p>
                <p><strong>내용:</strong> {memo.content}</p>
                <p><strong>등록일:</strong> {memo.reg_date}</p>
                <p><strong>IP:</strong> {memo.ip}</p>
            </CardContent>
        </Card>
    );
}