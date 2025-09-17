"use client";
import { Card, CardContent, Divider } from "@mui/material";
import { useState, useEffect } from "react";
import axios from "axios";
import MemoList from "../../components/memolist";

export default function Memo() {
    const api_url = "/memo/all";
    const [memoList, setMemoList] = useState([]);
    function callApi() {
        axios.get(api_url).then(function(response){
            setMemoList(response.data.m_list);
        });
    }
    useEffect(() => { //익명함수
        callApi();
    }, []); // [] : 현재 페이지가 열릴 때 한번 수행되고 끝남

  return (
    <div className="list-bg">
      <h2>메모장</h2>
        <Divider/>
        <MemoList memoList={memoList}/>
    </div>
  );
}