import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Books } from '../_model/books.model';
import { UsersAuthService } from './users-auth.service';

@Injectable({
  providedIn: 'root'
})
export class BooksService {

  tokenStr:any = this.usersAuthService.getToken();

  private baseURL = "http://localhost:8080/";

  constructor(
    private httpClient: HttpClient,
    private usersAuthService : UsersAuthService
  ) { }

  getBooksList(token:any): Observable<Books[]> {
    return this.httpClient.get<Books[]>(this.baseURL+"books",{headers: new HttpHeaders().set('Authorization',token)});
  }

  createBook(book: Books): Observable<Object> {
    return this.httpClient.post(this.baseURL+"books", book, {headers: new HttpHeaders().set('Authorization',this.tokenStr), responseType: "text" as "json"}); //{responseType: "text" as "json"}
  }

  getBookById(bookId: number, token:any): Observable<Books> {
    return this.httpClient.get<Books>(this.baseURL+"books/"+bookId,{headers: new HttpHeaders().set('Authorization',token)});
  }

  updateBook(bookId: number, book: Books): Observable<Object> {
    return this.httpClient.put(this.baseURL+"books/"+bookId, book, {headers: new HttpHeaders().set('Authorization',this.tokenStr), responseType: "text" as "json"}); //{responseType: "text" as "json"}
  }

  deleteBook(bookId: number, token:any): Observable<Object> {
    return this.httpClient.delete(this.baseURL+"books/"+bookId, {headers: new HttpHeaders().set('Authorization',token)});
  }

}
