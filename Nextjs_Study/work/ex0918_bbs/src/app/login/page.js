"use client";
import { Button, TextField } from "@mui/material";
import styles from "../page.module.css";
import { useState } from "react";
import { useRouter } from "next/navigation";

export default function Login() {
    //사용자가 입력한 객체 값들을 하나의 객체로 저장할 곳
    const [bbs, setBbs] = useState({
        id: '',
        password: ''
    });
    const handleChange = (e) => {
        const {name,value} = e.target;
        setBbs({...bbs, [name]: value});
    }
    function signIn() {
        //비동기식 서버통신

        //정상적으로 서버로부터 처리가 되었는지 확인

        //받은 토큰을 저장


        //bbs 객체의 내부요소 출력
        router.push('/');
    }
    return (
        <div style={{width: '80%', margin: '0 auto', padding: '20px'}}>
            <h1>로그인</h1>
            <hr/>
            <div className={styles.page}>

            <div style={{margin: '0 auto' , display: 'flex', flexDirection: 'column', gap: '20px' , alignItems: 'flex-end',marginTop: '20px'}}>

                <div style={{display: 'flex', gap: '20px', alignItems: 'center'}}>
            <p>아이디 : </p><TextField label="아이디" size="small" name="id" id="id" onChange={handleChange}/>
                </div>
                <div style={{display: 'flex', gap: '20px', alignItems: 'center'}}>
            <p>비밀번호 : </p><TextField label="비밀번호" size="small" name="password" id="password" onChange={handleChange}/>
                </div >
            <Button variant="contained" color="primary" style={{alignSelf: 'flex-start'}} onClick={signIn}>로그인</Button>
                </div>
            </div>
        </div>
    );
}