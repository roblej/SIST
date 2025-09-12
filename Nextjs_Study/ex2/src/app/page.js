"use client"
import Image from "next/image";
import styles from "./page.module.css";
import { useState } from "react";

export default function Home() {
  let title = "SiST"
  let title2 = "쌍용교육센터"
const [sub,setSub] = useState("Michael");

  return (
    <div className={styles.page}>
      <h1 className="title">{title}</h1>
      <h2 className={styles.redcolor}>{title2}</h2>
      <h2 >{sub}</h2>
    </div>
  );
}
