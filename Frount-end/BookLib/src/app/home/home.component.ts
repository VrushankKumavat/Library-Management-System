import { Component, OnInit } from '@angular/core';
import { UsersAuthService } from '../_services/users-auth.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor( 
    private userAuthSerivce : UsersAuthService
  ) {}
  
  ngOnInit(): void {
  }

}
