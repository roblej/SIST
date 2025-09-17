'use client';
import { useState,useEffect } from "react";
import axios from "axios";
import BbsList from "@/components/BbsList";

export default function Page(){
    const api_url = "/board/list";

    const [bname,setBname] = useState("BBS");
    //스프링 서버에서 전달되는 json배열을 저장할 곳
    const[list,setList] = useState([]);
    const[cPage,setCPage] = useState(1);
    const[totalPage,setTotalPage] = useState(0);
    
    function callData(){
        
        axios.get(
            api_url,
            {
                params:{bname:bname,cPage:cPage}
            }
        ).then(function(res){
            console.log(res.data);
            setList(res.data.ar);
            setTotalPage(res.data.totalPage);
        });
    }
    useEffect(function(){
        callData();
    },[cPage]);
    

        function changePage(e,p){
            console.log(p);
            setCPage(p);
        }
    return(
        <div style={{width:'80%',margin:'auto',padding:'20px',textAlign:'left'}}>
             <BbsList ar={list} tp={totalPage} cp={changePage}/>
             {/* cp라는 이름으로 changePage함수를 전달 */}
        </div>
    );
}