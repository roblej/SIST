import { TableContainer, Paper, Table, TableHead, TableRow, TableCell, TableBody, Button, Pagination } from "@mui/material";
import { useRouter } from "next/navigation";

export default function BbsList({ar,tp,cp}){
    const router = useRouter();

    return(
        <TableContainer component={Paper} >
            <Table sx={{ minWidth: 650 }}>
                <TableHead>
                    <TableRow>
                        <TableCell>번호</TableCell>
                        <TableCell component="th" scope="ar">제목</TableCell>
                        <TableCell align="right">작성자</TableCell>
                        <TableCell align="right">작성일</TableCell>
                        <TableCell align="right">조회수</TableCell>
                    </TableRow>
                </TableHead>
                <TableBody>
                    {ar.map((item,index)=>(
                        <TableRow key={index} sx={{ '&:last-child td, &:last-child th': { border: 0 } }}>
                            <TableCell>{item.b_idx}</TableCell>
                            <TableCell component="th" scope="ar">{item.subject}</TableCell>
                            <TableCell align="right">{item.writer}</TableCell>
                            <TableCell align="right">{item.write_date}</TableCell>
                            <TableCell align="right">{item.hit}</TableCell>
                        </TableRow>
                    ))}

                    {/* 다음은 페이징 기법을 위한 행이 추가되야 한다. */}
                    <TableRow>
                        <TableCell colSpan={4} align="center">
                        <Pagination count={tp} color="primary" onChange={cp}/>
                        </TableCell>
                        <TableCell>
                            <Button variant="contained" color="primary" onClick={() => router.push("board/write")}>글쓰기</Button>
                            {
                            /* Link : 이동할 페이지 경로가 정해져있을 때
                            router.push : 이동하기 전에 조건 또는 구현되는 로직에 따라 경로가 정해져야될 때 
                            */}
                        </TableCell>
                    </TableRow>
                </TableBody>
            </Table>
        </TableContainer>
    );
}