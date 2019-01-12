import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import * as h from '../host';

@Injectable({
  providedIn: 'root'
})
export class SearchService {

  constructor(private http:HttpClient) { }

  searchBook(name){
    const httpOptions={
      headers: new HttpHeaders({
        'Content-Type':  'application/json',
      }),
    };
    return this.http.put<any[]>(h.host+'/searchbooks',name,httpOptions);
  }

  getdepartment_types(university){
    university=encodeURI(university);
    const httpOptions={
      headers: new HttpHeaders({
        'Content-Type':  'application/json',
        'Authorization': 'Basic ' + university
      }),
    };
    return this.http.get<any[]>(h.host+'/getdepartment_types',httpOptions); 
  }
}
