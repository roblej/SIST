"use client";
import { Button, Table, TableBody, TableCell, TableContainer, TableHead, TableRow } from "@mui/material";
import Link from "next/link";
import styles from "../page.module.css";

export default function Board() {
    // 더미 데이터 배열을 컴포넌트 상단에 선언
    const dummyPosts = [
        { id: 1, title: "제목", author: "작성자", date: "작성일", views: "0" },
        { id: 2, title: "제목2", author: "작성자2", date: "작성일2", views: "12" },
        { id: 3, title: "제목3", author: "작성자3", date: "작성일3", views: "3" },
        { id: 4, title: "제목4", author: "작성자4", date: "작성일4", views: "125" },
        { id: 5, title: "제목5", author: "작성자5", date: "작성일5", views: "4" },
    ];
    return (
        <div>
            <h1>게시판</h1>
            <hr/>
            <div style={{position: 'relative' , width: '80%', margin: '0 auto'}}>

            {/* <Button variant="contained" color="primary" style={{position: 'absolute', right: '0'}} href="/board/write">글쓰기</Button>
            <TableContainer style={{width: '80%', margin: '0 auto', border: '1px solid #e0e0e0', marginTop: '20px'}}>
                <Table>
                    <TableHead>
                        <TableRow>
                            <TableCell>기본키</TableCell>
                            <TableCell>제목</TableCell>
                            <TableCell>작성자</TableCell>
                            <TableCell>작성일</TableCell>
                            <TableCell>조회수</TableCell>
                        </TableRow>
                    </TableHead>
                    <TableBody>
                        {dummyPosts.map((post) => (
                            <TableRow key={post.id}>
                                <TableCell>{post.id}</TableCell>
                                <TableCell>{post.title}</TableCell>
                                <TableCell>{post.author}</TableCell>
                                <TableCell>{post.date}</TableCell>
                                <TableCell>{post.views}</TableCell>
                            </TableRow>
                        ))}

                    </TableBody>
                </Table>
            </TableContainer> */}
                <table className="t1">
                    <thead>
                        <tr>
                            <td colSpan={5} className={styles.no_border}>
                                <Link href="/board/write">
                                    <button type="button">글쓰기</button>
                                </Link>
                            </td>
                        </tr>
                        <tr>
                            <th>기본키</th>
                            <th>제목</th>
                            <th>작성자</th>
                            <th>작성일</th>
                            <th>조회수</th>
                        </tr>
                    </thead>
                    <tbody>
                        {dummyPosts.map((post) => (
                            <tr key={post.id}>
                                <td>{post.id}</td>
                                <td>{post.title}</td>
                                <td>{post.author}</td>
                                <td>{post.date}</td>
                                <td>{post.views}</td>
                            </tr>
                        ))}
                    </tbody>
                </table>
            </div>
        </div>
    );
}