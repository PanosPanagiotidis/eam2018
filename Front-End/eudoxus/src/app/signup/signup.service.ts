import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import * as h from '../host';
import { SessionStorageService } from 'ngx-webstorage';

@Injectable({
  providedIn: 'root'
})
export class SignupService {

  constructor(private http:HttpClient, private sessionSt:SessionStorageService) { }

  signup_ekdoths(name,address,email,password,tel,time_open,senior){
    const httpOptions={
      headers: new HttpHeaders({
        // 'Content-Type':  'application/json',
        'Authorization': 'Basic ' + btoa(email+':'+password)
      }),
    };
    return this.http.put<Boolean>(h.host+'/signup_ekdoths',name+':'+address+':'+email+':'+password+':'+tel+':'+time_open+':'+senior,httpOptions); 
  }
  signup_foithths(university_type,class_type,AM,name,surname,email,password,tel,running_semester,numofbooks){
    const httpOptions={
      headers: new HttpHeaders({
        // 'Content-Type':  'application/json',
        'Authorization': 'Basic ' + btoa(email+':'+password)
      }),
    };
    return this.http.put<Boolean>(h.host+'/signup_foithtes',university_type+':'+class_type+':'+AM+':'+name+':'+surname+':'+email+':'+password+':'+tel+':'+running_semester+':'+numofbooks,httpOptions); 
  }
  signup_shmeio_dianomhs(name,class_type,address,email,password,tel,time_open,senior){
    const httpOptions={
      headers: new HttpHeaders({
        // 'Content-Type':  'application/json',
        'Authorization': 'Basic ' + btoa(email+':'+password)
      }),
    };
    return this.http.put<Boolean>(h.host+'/signup_shmeio_dianomhs',name+':'+class_type+':'+address+':'+email+':'+password+':'+tel+':'+time_open+':'+senior,httpOptions); 
  }
  signup_grammateia(university_type,class_type,email,password,phone,time_open,senior){
    const httpOptions={
      headers: new HttpHeaders({
        // 'Content-Type':  'application/json',
        'Authorization': 'Basic ' + btoa(email+':'+password)
      }),
    };
    return this.http.put<Boolean>(h.host+'/signup_grammateia',university_type+':'+class_type+':'+phone+':'+time_open+':'+senior,httpOptions); 
  }
  signup_diatheths(email,password){
    const httpOptions={
      headers: new HttpHeaders({
        // 'Content-Type':  'application/json',
        'Authorization': 'Basic ' + btoa(email+':'+password)
      }),
    };
    return this.http.put<Boolean>(h.host+'/signup_diatheths',httpOptions); 
  }
  signup_bibliothiki(name,address,email,password,tel,time_open,senior){
    const httpOptions={
      headers: new HttpHeaders({
        // 'Content-Type':  'application/json',
        'Authorization': 'Basic ' + btoa(email+':'+password)
      }),
    };
    return this.http.put<Boolean>(h.host+'/signup_bibliothiki',name+':'+address+':'+email+':'+password+':'+tel+':'+time_open+':'+senior,httpOptions); 
  }

}
