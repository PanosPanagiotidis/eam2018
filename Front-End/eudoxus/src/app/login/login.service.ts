import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import * as h from '../host';
import { SessionStorageService } from 'ngx-webstorage';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http:HttpClient, private sessionSt:SessionStorageService) { }

  login(email,password){
    this.sessionSt.store('email',email);
    this.sessionSt.store('password',password);
    const httpOptions={
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': 'Basic ' + btoa(email+':'+password)
      }),
    };
    return this.http.get<number>(h.host+'/login',httpOptions);
  }
}
