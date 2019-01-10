import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import * as h from '../host';
import { SessionStorageService } from 'ngx-webstorage';

@Injectable({
  providedIn: 'root'
})
export class DistributionpointService {

  constructor(private http:HttpClient, private sessionSt:SessionStorageService) { }

  getdetails(){
    var email=this.sessionSt.retrieve('email');
    var password=this.sessionSt.retrieve('password');
    const httpOptions={
      headers: new HttpHeaders({
        'Content-Type':  'application/json',
        'Authorization': 'Basic ' + btoa(email+':'+password)
      }),
    };
    return this.http.get<any>(h.host+'/get_shmeio_details',httpOptions); 
  }

  update_shmeio(name,email,newemail,password,tel,address,time_open,senior){
    const httpOptions={
      headers: new HttpHeaders({
        // 'Content-Type':  'application/json',
        'Authorization': 'Basic ' + btoa(email+':'+password)
      }),
    };
    return this.http.put<Boolean>(h.host+'/update_shmeio',name+':'+tel+':'+newemail+':'+address+':'+time_open+':'+senior,httpOptions); 
  }
  searchbooks(variable){
    var email=this.sessionSt.retrieve('email');
    var password=this.sessionSt.retrieve('password');
    const httpOptions={
      headers: new HttpHeaders({
        // 'Content-Type':  'application/json',
        'Authorization': 'Basic ' + btoa(email+':'+password)
      }),
    };
    return this.http.put<any[]>(h.host+'/searchbooks',variable,httpOptions); 
  }
  insertbooks(arrayofisbn){
    var email=this.sessionSt.retrieve('email');
    var password=this.sessionSt.retrieve('password');
    const httpOptions={
      headers: new HttpHeaders({
        // 'Content-Type':  'application/json',
        'Authorization': 'Basic ' + btoa(email+':'+password)
      }),
    };
    return this.http.put<Boolean>(h.host+'/insertbooks',arrayofisbn,httpOptions); 
  }
  delivery(pin){
    var email=this.sessionSt.retrieve('email');
    var password=this.sessionSt.retrieve('password');
    const httpOptions={
      headers: new HttpHeaders({
        // 'Content-Type':  'application/json',
        'Authorization': 'Basic ' + btoa(email+':'+password)
      }),
    };
    return this.http.put<any[]>(h.host+'/delivery',pin,httpOptions); 
  }
  getallbooks(){
    var email=this.sessionSt.retrieve('email');
    var password=this.sessionSt.retrieve('password');
    const httpOptions={
      headers: new HttpHeaders({
        'Content-Type':  'application/json',
        'Authorization': 'Basic ' + btoa(email+':'+password)
      }),
    };
    return this.http.get<any[]>(h.host+'/getallbooks',httpOptions); 
  }
}
