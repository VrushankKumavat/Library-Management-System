import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { UsersAuthService } from '../_services/users-auth.service';
import { UsersService } from '../_services/users.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  inavlidLogin:boolean = false;
  errorMessage:String = "";

  constructor(
    private userService: UsersService,
    private userAuthSerivce: UsersAuthService,
    private router: Router
  ){ }

  ngOnInit() {
  }

  login(loginForm: NgForm) {
    this.userService.login(loginForm.value).subscribe(
      (response: any)=>{
        const specialChars = /["]/;
        this.userAuthSerivce.setToken('Bearer '+response);
        let payload = this.userAuthSerivce.getToken().split(".")[1];
        payload = window.atob(payload);
        console.log(payload.split(specialChars)[3]);
        this.userService.getUserByName(payload.split(specialChars)[3],'Bearer '+response).subscribe(
          (data) => {
            this.userAuthSerivce.setName(data.name);
            this.userAuthSerivce.setUserId(data.userId);
          }
        );
        console.log(this.userAuthSerivce.getToken());

        this.router.navigate(['/books']);
      },
      (error)=>{
        console.log(error);
        this.errorMessage = error.message;
        this.inavlidLogin = true;
      }
    );
  }

}
