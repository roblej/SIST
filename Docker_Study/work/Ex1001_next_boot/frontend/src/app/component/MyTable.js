import { TableContainer, Table, TableHead, TableBody, TableRow, TableCell, Paper, Card } from "@mui/material";

export default function MyTable({ar}){
    return (
        <div>
            {/* MU설치후 카드안에 Table Container을 활용하여 ar의 요소들을 표현하자 */}
            <Card style={{width: "50%"}}>
            <TableContainer component={Paper}>
            <Table>
                <TableHead>
                    <TableRow>
                        <TableCell align="center">사원번호</TableCell>
                        <TableCell align="center">사원명</TableCell>
                        <TableCell align="center">부서번호</TableCell>
                    </TableRow>
                </TableHead>
                <TableBody>
                    {ar.map((item, index) => (
                        <TableRow key={index}>
                            <TableCell align="center">{item.empno}</TableCell>
                            <TableCell align="center">{item.ename}</TableCell>
                            <TableCell align="center">{item.deptno}</TableCell>
                        </TableRow>
                    ))}
                </TableBody>
            </Table>
            </TableContainer>
            </Card>
        </div>
    );
}