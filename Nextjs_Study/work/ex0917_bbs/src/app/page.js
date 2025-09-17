"use client";

import styles from "./page.module.css";
import { Divider } from "@mui/material";

export default function Home() {


  return (
    <div className={styles.page}>
        <div style={{width:'80%',margin:'auto',padding:'20px',textAlign:'left'}}>
          <h2>sist연습페이지</h2>
          <Divider /> {/* 구분선 */}

        </div>
    </div>
  );
}
