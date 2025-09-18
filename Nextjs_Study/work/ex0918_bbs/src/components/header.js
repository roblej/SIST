import Link from "next/link";

export default function Header() {
  return (
    <div style={{display: 'flex', justifyContent: 'space-between', alignItems: 'center', padding: '30px',borderBottom: '1px solid #e0e0e0'}}>
        <div style={{display: 'flex', gap: '20px'}}>
            <Link href="/">Home</Link>
            <Link href="/members">Members</Link>
            <Link href="/board">Board</Link>
        </div>
        <div style={{display: 'flex', gap: '20px'}}>
            <Link href="/login">Login</Link>
            <Link href="/register">Register</Link>
        </div>
    </div>
  );
}