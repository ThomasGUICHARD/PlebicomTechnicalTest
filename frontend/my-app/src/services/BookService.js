import axios from 'axios'

const BOOK_REST_API_URL='http://localhost:8080/api/books/getAllBooks';

export const API = axios.create({
    baseURL: "${uriChecker()}",
    headers: {
        'Access-Control-Allow-Credentials': true,
        'Access-Control-Allow-Origin': 'http://localhost:8080',
        'Access-Control-Allow-Methods': 'GET,PUT,POST,DELETE,PATCH,OPTIONS',
        'Access-Control-Allow-Headers':
            'X-CSRF-Token, X-Requested-With, Accept, Accept-Version, Content-Length, Content-MD5, Content-Type, Date, X-Api-Version',
    },
})

class BookService{

    async getAllBooks(){
        
        const machin = await API.get(BOOK_REST_API_URL)
        return machin
    }
}

export default new BookService();