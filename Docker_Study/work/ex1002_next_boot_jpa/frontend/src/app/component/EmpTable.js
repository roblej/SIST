import { Table, TableBody, TableCell, TableHead, TableRow } from "@mui/material";

export default function EmpTable({ ar }) {
    return (
        <Table>
                    <TableHead>
                        <TableRow>
                            <TableCell align="center">번호</TableCell>
                            <TableCell align="center">사원명</TableCell>
                            <TableCell align="center">사번</TableCell>
                            <TableCell align="center">직종</TableCell>
                            <TableCell align="center">부서코드</TableCell>
                            <TableCell align="center">부서명</TableCell>
                        </TableRow>
                    </TableHead>
                    <TableBody>
                        {ar.map((row,i) => (
                            <TableRow key={i}>
                                <TableCell align="center">{i+1}</TableCell>
                                <TableCell align="center">{row.ename}</TableCell>
                                <TableCell align="center">{row.empno}</TableCell>
                                <TableCell align="center">{row.job}</TableCell>
                                <TableCell align="center">{row.deptno}</TableCell>
                                <TableCell align="center">{row.dept?.dname || 'N/A'}</TableCell>

                            </TableRow>
                        ))}
                    </TableBody>
                </Table>
    )
}