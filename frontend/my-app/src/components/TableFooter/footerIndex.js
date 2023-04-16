import React, { useEffect } from "react";

import styles from "./footerIndex.css";

const TableFooter = ({ range, setPage, page, slice }) => {
  useEffect(() => {
   // if (slice.length < 1 && page !== 1) {
     // setPage(page - 1);
    //}
  }, [slice, page, setPage]);
  return (
    <div className={styles.tableFooter}>
        <button key={page-1} onClick={() => {if(page>1){setPage(page-1)}}}>
        Previous
        </button>
        <button key={page+1} onClick={() => {if(page<range.length){setPage(page+1)}}}>
        Next
        </button>
        <p>Page {page} on {range.length}</p>
      
    </div>
  );
};

export default TableFooter;