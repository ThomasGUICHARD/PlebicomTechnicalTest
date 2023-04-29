import React, { useEffect } from "react";
import {Button,FormGroup,FormControlLabel,Switch} from '@mui/material'
import styles from "./footerIndex.css";

const TableFooter = ({ range, setPage, page, slice, alpha }) => {
  useEffect(() => {
   // if (slice.length < 1 && page !== 1) {
     // setPage(page - 1);
    //}
  }, [slice, page, setPage]);
  return (
    <div className={styles.tableFooter}>
        <Button key={page-1} onClick={() => {if(page>1){setPage(page-1)}}}>
        Previous
        </Button>
        <Button key={page+1} onClick={() => {if(page<range.length){setPage(page+1)}}}>
        Next
        </Button>
        <p>Page {page} on {range.length}</p>
        <Switch onChange={(e) => this.setState(prevState => ({alpha: !prevState.alpha}))}/>
      
    </div>
  );
};

export default TableFooter;