"use client";

import ItemList from "@/components/ItemList";
import styles from "./page.module.css";
import axios from "axios";
import { useEffect, useState } from "react";
import { Divider } from "@mui/material";

export default function Home() {
  const api_url = "/api/v1/products.json?brand=maybelline"//cross도메인 이슈
  const [data,setData] = useState([]);
  function callApi(){
    axios.get(api_url).then(function(data){
      //성공했을 때 수행
      setData(data.data);
    })
  }
  useEffect(function(){
    callApi();
  },[])

  return (
    <div className={styles.page}>
        <div style={{width:'80%',margin:'auto',padding:'20px',textAlign:'left'}}>
          <h2>베스트 상품</h2>
          <Divider /> {/* 구분선 */}
          <ItemList list={data.slice(0, 9)} />

          <h2>최신 상품</h2>
          <Divider />
          <ItemList list={data.slice(9)} />
        </div>
    </div>
  );
}
