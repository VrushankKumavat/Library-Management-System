import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Observable } from 'rxjs';
import { Users } from '../_model/users.model';
import { UsersAuthService } from './users-auth.service';

@Injectable({
  providedIn: 'root'
})
export class UsersService {

  constructor(
    private http:HttpClient,
    private userAuthService: UsersAuthService
    ) { }

  public generateToken(request:any) {
    return this.http.post("http://localhost:8080/authenticate", request, {responseType: "text" as "json"});
  }

  public welcome(token:any){
    let tokenStr = 'Bearer '+token;
    return this.http.get("http://localhost:8080/", 
        {headers: new HttpHeaders().set('Authorization',tokenStr), responseType: "text" as "json"});
  }

  public login(loginData: NgForm) {
    console.log(loginData);
    return this.http.post("http://localhost:8080/authenticate", loginData, {responseType: "text" as "json"});
  }

  public getUserByName(userName:String, token:any): Observable<Users> {
    return this.http.get<Users>("http://localhost:8080/user/"+userName,
    {headers: new HttpHeaders().set('Authorization',token)});
  }

}
