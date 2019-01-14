import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import * as h from '../host';

@Injectable({
  providedIn: 'root'
})
export class BrowseService {

  constructor(private http:HttpClient) { }

  getDepartments(){
    const httpOptions={
      headers: new HttpHeaders({
        'Content-Type':  'application/json',
      }),
    };
    return this.http.get<any>(h.host+'/getDepartments',httpOptions); 
  }

  getDistPoints(){
    const httpOptions={
      headers: new HttpHeaders({
        'Content-Type':  'application/json',
      }),
    };
    return this.http.get<any>(h.host+'/getDistPoints',httpOptions); 
  }

}
