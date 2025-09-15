export default function NoticeTR(props){
    return (
        <tr>
            <td>1</td>
            <td>{props.subject}</td>
            <td>{props.writer}</td>
            <td>{props.date}</td>
            <td>10</td>
        </tr>
    );
}