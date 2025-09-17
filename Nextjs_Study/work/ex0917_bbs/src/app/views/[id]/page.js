'use client';
import { use,useState,useEffect } from "react";
import axios from "axios";
import Item from "@/components/Item";

export default function Page({params}){
    // const id = params.id;
    // const id = `${params.id}`;
    const {id} = use(params);

    const api_url = `/api/v1/products/${id}.json`;
    const [vo,setVO] = useState({});
    function getData(){//데이터를 가져오는 함수
        axios.get(api_url).then(function(res){
            setVO(res.data);
        });
    }
    useEffect(function(){
        if(id&&id>0){
            getData();
        }
    },[id]);//id가 변경될 때마다 데이터를 가져옴
    return (
        <div style={{width:'80%',margin:'auto',padding:'20px',textAlign:'left'}}>
            <Item item={vo} />
        </div>
    );
}