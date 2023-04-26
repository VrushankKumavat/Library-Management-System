import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Books } from '../_model/books.model';
import { BooksService } from '../_services/books.service';
import { UsersAuthService } from '../_services/users-auth.service';

@Component({
  selector: 'app-books-list',
  templateUrl: './books-list.component.html',
  styleUrls: ['./books-list.component.css']
})
export class BooksListComponent implements OnInit {

  books:Books[] | undefined;
  token:String = this.userAuthService.getToken();
  str:String = "";

  constructor(
    private userAuthService : UsersAuthService,
    private bookService : BooksService,
    private router : Router
    ) {

  }

  ngOnInit() {
    this.getBooksList(this.token);
  }

  getBooksList(token:any) {
    if(token.length === 0) {
      console.log("There is no login");
      this.str = "There is no login";
    }
    else {
      this.bookService.getBooksList(token).subscribe( data => {
        this.books = data;
      });
      this.books?.forEach(d => console.log(d));
    }
  }

  updateBook(bookId: number) {
    this.router.navigate(['update-book', bookId ]);
  }

  deleteBook(bookId: number) {
    this.bookService.deleteBook(bookId,this.token).subscribe( data => this.getBooksList(this.token));
  }

}
