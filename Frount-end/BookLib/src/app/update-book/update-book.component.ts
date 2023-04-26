import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Books } from '../_model/books.model';
import { BooksService } from '../_services/books.service';
import { UsersAuthService } from '../_services/users-auth.service';

@Component({
  selector: 'app-update-book',
  templateUrl: './update-book.component.html',
  styleUrls: ['./update-book.component.css']
})
export class UpdateBookComponent implements OnInit {

  bookId!: number;
  book: Books = new Books();
  tokenStr:String = this.usersAuthService.getToken();

  constructor(
    private booksService: BooksService,
    private usersAuthService: UsersAuthService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    this.bookId = this.route.snapshot.params['id'];
    console.log("bookid is: "+this.bookId)
    this.booksService.getBookById(this.bookId,this.tokenStr).subscribe(data => {
      this.book = data;
    })
  }

  onSubmit() {
    this.booksService.updateBook(this.bookId, this.book).subscribe( data =>{
        this.goToBooksList();
    },
    error => console.log(error));
  }

  goToBooksList() {
    this.router.navigate(['/books']);
  }

}
