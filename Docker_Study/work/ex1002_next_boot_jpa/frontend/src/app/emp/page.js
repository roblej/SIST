"use client";
import { useState, useEffect } from "react";
import axios from "axios";
import { Card, CardHeader,CardContent, Avatar } from "@mui/material";
import { red } from "@mui/material/colors";
import EmpTable from "../component/EmpTable";
export default function Emp() {
    const api_url = "/api/emp/all";
    const [empList, setEmpList] = useState([]);

    useEffect(() => {
        axios.get(api_url).then(response => {
            setEmpList(response.data);
            console.log(response);
        });
    }, []);
    return (
        <div style={{width:"980px", margin:"10 auto"}}>

        <Card sx={{ maxWidth: 900 }}>
            <CardHeader
                avatar={
                    <Avatar sx={{ bgcolor: red[500] }} aria-label="recipe">
                        S
                    </Avatar>
                }
                title="SiST 사원목록"
                subheader="October 02, 2025"
            />
            <CardContent>
                <EmpTable ar={empList} />
            </CardContent>
        </Card>
        </div> 
    )
}