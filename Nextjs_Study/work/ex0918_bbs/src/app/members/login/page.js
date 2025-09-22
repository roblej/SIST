"use client";
import { Button, TextField } from "@mui/material";
import styles from "../../page.module.css";
import { useState } from "react";
import { useRouter } from "next/navigation";
import tokenStore from "../../store/TokenStore";
import axios from "axios";

export default function Login() {
    const router = useRouter();
    const {accessToken, setToken} = tokenStore();
    let api_url = "/api/members/login";
    //사용자가 입력한 객체 값들을 하나의 객체로 저장할 곳
    const [member, setMember] = useState({});
    function signIn() {
        //비동기식 서버통신
        axios.post(api_url, JSON.stringify(member),{
            withCredentials: true,
            headers: {
                'Content-Type': 'application/json'
            }
        }).then((res)=>{
            if(res.data.totalcount > 0){
                setToken(res.data.data.accessToken);
                router.push('/');
            }
        })
    }

    const handleChange = (e) => {
        const {name,value} = e.target;
        setMember({...member, [name]: value});
    }

    return (
        <div style={{width: '80%', margin: '0 auto', padding: '20px'}}>
            <h1>로그인</h1>
            <hr/>
            <div className={styles.page}>

            <div style={{margin: '0 auto' , display: 'flex', flexDirection: 'column', gap: '20px' , alignItems: 'flex-end',marginTop: '20px'}}>

                <div style={{display: 'flex', gap: '20px', alignItems: 'center'}}>
            <p>아이디 : </p><TextField label="아이디" size="small" name="mid" id="id" onChange={handleChange}/>
                </div>
                <div style={{display: 'flex', gap: '20px', alignItems: 'center'}}>
            <p>비밀번호 : </p><TextField label="비밀번호" size="small" name="mpw" id="password" onChange={handleChange}/>
                </div >
            <Button variant="contained" color="primary" style={{alignSelf: 'flex-start'}} onClick={signIn}>로그인</Button>
                </div>
            </div>
        </div>
    );
}