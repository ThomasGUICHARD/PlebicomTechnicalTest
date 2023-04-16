import React, { useState,useEffect} from 'react'
import BookService from '../services/BookService'
import {Typography} from '@mui/material'
import {Table,TableContainer,TableHead,TableBody,TableRow,TableCell,Paper} from '@mui/material'

const ListBookComponent = () => {
    const [books, setBooks] = useState([])
    useEffect(() => {
        BookService.getAllBooks().then((response)=>{
            setBooks(response.data)
            console.log(response.data);
        }).catch(error=>{
            console.log(error);
        })
    }, [])
    

  return (
    <div>
        <TableContainer component={Paper} sx={{maxHeight: '300px'}}>
            <Table aria-aria-label='simple table' stickyHeader>
                <TableHead><TableRow><TableCell colSpan={4} align='center'>List of books</TableCell></TableRow>
                    <TableRow><TableCell>Reference</TableCell><TableCell>Name</TableCell><TableCell>Author</TableCell><TableCell>Release date</TableCell></TableRow>
                </TableHead>
                <TableBody>
                    {
                        books.map(
                            book=>
                            <TableRow key={book.id}>
                                <TableCell>{book.id}</TableCell>
                                <TableCell>{book.title}</TableCell>
                                <TableCell>{book.author}</TableCell>
                                <TableCell>{book.releaseDate}</TableCell>
                            </TableRow>
                        )
                    }
                </TableBody>
            </Table>
        </TableContainer>
    </div>
  )
}

export default ListBookComponent
