import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import * as h from '../host';
import { SessionStorageService } from 'ngx-webstorage';

@Injectable({
  providedIn: 'root'
})
export class StudentsService {

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
    return this.http.get<any>(h.host+'/get_foithths_details',httpOptions); 
  }
  getuniversity(){
    var email=this.sessionSt.retrieve('email');
    var password=this.sessionSt.retrieve('password');
    const httpOptions={
      headers: new HttpHeaders({
        'Content-Type':  'application/json',
        'Authorization': 'Basic ' + btoa(email+':'+password)
      }),
    };
    return this.http.get<any>(h.host+'/get_university_details',httpOptions); 
  }
  getdepartment(){
    var email=this.sessionSt.retrieve('email');
    var password=this.sessionSt.retrieve('password');
    const httpOptions={
      headers: new HttpHeaders({
        'Content-Type':  'application/json',
        'Authorization': 'Basic ' + btoa(email+':'+password)
      }),
    };
    return this.http.get<any>(h.host+'/get_department_details',httpOptions); 
  }

  update_foithths(name,surname,email,newemail,password,tel){
    const httpOptions={
      headers: new HttpHeaders({
        // 'Content-Type':  'application/json',
        'Authorization': 'Basic ' + btoa(email+':'+password)
      }),
    };
    return this.http.put<Boolean>(h.host+'/update_foithths',name+':'+surname+':'+tel+':'+newemail,httpOptions); 
  }

  getseasonbooks(){
    var email=this.sessionSt.retrieve('email');
    var password=this.sessionSt.retrieve('password');
    const httpOptions={
      headers: new HttpHeaders({
        'Content-Type':  'application/json',
        'Authorization': 'Basic ' + btoa(email+':'+password)
      }),
    };
    return this.http.get<any[]>(h.host+'/getseasonbooks',httpOptions); 
  }

  gethistory(){
    var email=this.sessionSt.retrieve('email');
    var password=this.sessionSt.retrieve('password');
    const httpOptions={
      headers: new HttpHeaders({
        'Content-Type':  'application/json',
        'Authorization': 'Basic ' + btoa(email+':'+password)
      }),
    };
    return this.http.get<any[]>(h.host+'/gethistory',httpOptions); 
  }

  getavailablebookstoexhange(){
    var email=this.sessionSt.retrieve('email');
    var password=this.sessionSt.retrieve('password');
    const httpOptions={
      headers: new HttpHeaders({
        'Content-Type':  'application/json',
        'Authorization': 'Basic ' + btoa(email+':'+password)
      }),
    };
    return this.http.get<any[]>(h.host+'/getavailablebookstoexhange',httpOptions); 
  }

  exhangebooks(arrayofisbn){
    var email=this.sessionSt.retrieve('email');
    var password=this.sessionSt.retrieve('password');
    const httpOptions={
      headers: new HttpHeaders({
        // 'Content-Type':  'application/json',
        'Authorization': 'Basic ' + btoa(email+':'+password)
      }),
    };
    return this.http.put<Boolean>(h.host+'/exhangebooks',arrayofisbn,httpOptions); 
  }

  getexhangersforbook(isbn){
    var email=this.sessionSt.retrieve('email');
    var password=this.sessionSt.retrieve('password');
    const httpOptions={
      headers: new HttpHeaders({
        'Content-Type':  'application/json',
        'Authorization': 'Basic ' + btoa(email+':'+password)
      }),
    };
    return this.http.put<any[]>(h.host+'/getexhangersforbook',isbn,httpOptions); 
  }

  declareBooks(books:any[]){
    var email=this.sessionSt.retrieve('email');
    var password=this.sessionSt.retrieve('password');
    const httpOptions={
      headers: new HttpHeaders({
        'Content-Type':  'application/json',
        'Authorization': 'Basic ' + btoa(email+':'+password)
      }),
    };
    // var books = book1+':'+book2+':'+book3+':'+book4+':'+book5+':'+book6+':'+book7
    var booksString = ""
    for (var i of books){
      if(i!=null){
        booksString += i + ":"
      }
      
    }
    console.log(booksString)
    return this.http.put<number>(h.host+'/declareBooks',booksString,httpOptions);
  }

  getDeclaredBooks(){
    var email=this.sessionSt.retrieve('email');
    var password=this.sessionSt.retrieve('password');
    const httpOptions={
      headers: new HttpHeaders({
        'Content-Type':  'application/json',
        'Authorization': 'Basic ' + btoa(email+':'+password)
      }),
    };
    return this.http.get<any[]>(h.host+'/getDeclaredBooks',httpOptions)
  }
}
