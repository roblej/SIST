import Nav from "./nav";

export default function Header(){
    return(
        <div style={{width:'90%',margin:'auto',padding:'20px',textAlign:'left'}}>
            <img src="/images/logo.png" alt="logo" style={{height:'40px',marginBottom:'10px'}}/>
            <Nav/>
        </div>
    );
}