"use client";
import Link from "next/link";
// import { cookies } from "next/headers";
import tokenStore from "../app/store/TokenStore";
import { Button } from "@mui/material";
import axios from "axios";
import { useEffect } from "react";
import { useRouter } from "next/navigation";
import { useRef } from "react";

// export default async function Header() {
export default function Header() {
  // const cookieStore = await cookies();
  // const accessToken = cookieStore.get('accessToken')?.value;
  //상태관리에 필요한 객체 준비
  const {accessToken, setToken} = tokenStore(); 
  // 로그인 상태 유지를 위해 accessToken이 localStorage에 저장/복원되도록 구현

  // accessToken을 로컬스토리지에 저장하고, 새로고침 시 항상 동기화
  const isFirstLoad = useRef(true);

  useEffect(() => {
    if (typeof window === "undefined") return;

    // 새로고침(마운트) 시 localStorage에서 accessToken을 꺼내와서 상태와 비교
    const storedToken = localStorage.getItem("accessToken");
    if (storedToken && accessToken !== storedToken) {
      setToken(storedToken);
    }
    isFirstLoad.current = false;
  }, []);

  useEffect(() => {
    if (typeof window === "undefined" || isFirstLoad.current) return;

    // accessToken이 변경될 때마다 localStorage에 저장/삭제
    if (accessToken) {
      localStorage.setItem("accessToken", accessToken);
    } else {
      localStorage.removeItem("accessToken");
    }
  }, [accessToken]);

  //cookieStore.get("accessToken"값이 저장되지만 없으면 undefined가 저장된다.
  const api_url = "/api/members/logout";
  const router = useRouter();
  function logout(){
    if(confirm("로그아웃하시겠습니까?")){
    axios.post(api_url).then(function(json){
      console.log(json);
      if(json.data.msg == "logout"){
        setToken(null); // Zustand의 값을 null로 초기화
        router.push("/"); // sendRedirect
        }
      });
    }
    
  }
  return (
    <div style={{display: 'flex', justifyContent: 'space-between', alignItems: 'center', padding: '30px',borderBottom: '1px solid #e0e0e0'}}>
        <div style={{display: 'flex', gap: '20px'}}>
            <Link href="/">Home</Link>
            <Link href="/members">Members</Link>
            <Link href="/board">Board</Link>
        </div>
        <div style={{display: 'flex', gap: '20px'}}>
            {
            accessToken==null
            ? <Link href="/members/login">Login</Link>
            : <Link href="/" onClick={logout}>Logout</Link>
            }
            <Link href="/register">Register</Link>
        </div>
    </div>
  );
}