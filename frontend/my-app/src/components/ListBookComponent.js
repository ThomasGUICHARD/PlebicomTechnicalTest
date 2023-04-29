import React, { useState,useEffect} from 'react'
import useTable from "../hooks/toolTable";
import {Table,TableContainer,TableHead,TableBody,TableRow,TableCell,Paper} from '@mui/material'
import TableFooter from './TableFooter/footerIndex';



const ListBookComponent = () => {
    const [page, setPage] = useState(1);
    const [rowsPerPage, setRowsPerPage] = useState(5);
    const [alpha, setAlpha] = useState(false);
    const { slice, range } = useTable(page, rowsPerPage, alpha);
    
    

  return (
    <div>
        <TableContainer component={Paper} sx={{maxHeight: '300px'}}>
            <Table aria-aria-label='simple table' stickyHeader>
                <TableHead>
                    <TableRow><TableCell colSpan={4} align='center'>List of books</TableCell></TableRow>
                    <TableRow><TableCell>Reference</TableCell><TableCell>Name</TableCell><TableCell>Author</TableCell><TableCell>Release date</TableCell></TableRow>
                </TableHead>
                <TableBody>
                    {
                        slice.map(
                            (book)=>(
                            <TableRow key={book.id}>
                                <TableCell>{book.id}</TableCell>
                                <TableCell>{book.title}</TableCell>
                                <TableCell>{book.author}</TableCell>
                                <TableCell>{book.releaseDate}</TableCell>
                            </TableRow>
                            )
                        )
                    }
                </TableBody>
            </Table>
            
        </TableContainer>
        <TableFooter range={range} slice={slice} setPage={setPage} page={page} alpha={alpha} />
    </div>
  )
}

export default ListBookComponent
