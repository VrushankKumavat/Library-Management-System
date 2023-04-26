import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UsersAuthService } from '../_services/users-auth.service';
import { UsersService } from '../_services/users.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent {

  constructor(
    private usersService : UsersService,
    private router : Router,
    private userAuthService : UsersAuthService
  ) { }

  name = this.userAuthService.getName();

  public isLoggedIn() {
    // console.log(this.name);
    return this.userAuthService.isLoggedIn();
  }

  public logout() {
    this.userAuthService.clear();
    this.router.navigate(['/']);
  }

}
