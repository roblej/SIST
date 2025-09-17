"use client";

import { Box, Grid } from "@mui/material";
import Link from "next/link";

function Nav(){
    const navItem = [{
        title:"Products",
        path:"/products"
    },{
        title:"Color cosmetics",
        path:"/color-cosmetics"
    },{
        title:"Skin cosmetics",
        path:"/skin-cosmetics"
    },{
        title:"Board",
        path:"/board"
    },{
        title:"about",
        path:"/about"
    }];

    return(
        <nav id="header">
            <Grid container spacing={2} justifyContent="center">
                {navItem.map(function (item,i){
                    return (
                        
                        <Grid item key={i} size={{xs:12,md:2}}>
                            <Link href={`${item.path}`} key={i}>
                            <Box bgcolor="primary.light" p={2}>{item.title}</Box>
                        </Link>
                        </Grid>
                    );
                })
                }
            </Grid>
        </nav>
    );
}
export default Nav;