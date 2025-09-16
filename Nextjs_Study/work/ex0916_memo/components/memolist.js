import { Card, CardContent } from "@mui/material";
import Link from "next/link";

export default function MemoList({ memoList }) {
    return (
        <Card style={{ width: '500px', margin: '20px auto' }}>
            <CardContent>
                {memoList.map((item, index) => (
                    <Link key={index} href={`/view/${item.idx}`}>
                        <div className="list-item">
                            <h4 className="list-item-h4">{item.content}</h4>
                            <p className="list-item-p">{item.writer}</p>
                        </div>
                    </Link>
                ))}
            </CardContent>
        </Card>
    );
}