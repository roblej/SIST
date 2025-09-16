import Nav from "./nav";

export default function Header(){
    return(
        <div style={{width:'80%',margin:'auto',padding:'20px',textAlign:'left'}}>
            <img src="/images/logo.png" alt="logo"/>
            <Nav/>
        </div>
    );
}