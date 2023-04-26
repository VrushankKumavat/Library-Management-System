import { Component, OnInit} from '@angular/core';
import { UsersAuthService } from '../_services/users-auth.service';
import { UsersService } from '../_services/users.service';

@Component({
  selector: 'app-security',
  templateUrl: './security.component.html',
  styleUrls: ['./security.component.css']
})
export class SecurityComponent implements OnInit {

  authRequest:any = {
    "userName":"Vrushank",
    "password":"Vrushank"
  }

  response:any;

  constructor(private service:UsersService, 
              private userAuthSerivce:UsersAuthService
    ){}

  ngOnInit() {
    // this.getAccessToken(this.authRequest);
  }

  public getAccessToken(authRequest:any){
    let resp = this.service.generateToken(authRequest);
    resp.subscribe(data => this.accessApi(data));
  }

  public accessApi(token:any){
    let resp = this.service.welcome(token);
    resp.subscribe(data => this.response = data);
  }
}
