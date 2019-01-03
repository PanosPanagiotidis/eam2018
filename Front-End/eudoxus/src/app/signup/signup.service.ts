import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import * as h from '../host';
import { SessionStorageService } from 'ngx-webstorage';
import { encode } from 'punycode';

@Injectable({
  providedIn: 'root'
})
export class SignupService {

  constructor(private http:HttpClient, private sessionSt:SessionStorageService) { }

  signup_foithths(university_type,class_type,AM,name,surname,email,password,tel,running_semester,numofbooks){
    const httpOptions={
      headers: new HttpHeaders({
        // 'Content-Type':  'application/json',
        'Authorization': 'Basic ' + btoa(email+':'+password)
      }),
    };
    return this.http.put<Boolean>(h.host+'/signup_foithths',university_type+':'+class_type+':'+AM+':'+name+':'+surname+':'+tel+':'+running_semester+':'+numofbooks,httpOptions); 
  }
  signup_shmeio_dianomhs(name,class_type,address,email,password,tel,time_open,senior){
    const httpOptions={
      headers: new HttpHeaders({
        // 'Content-Type':  'application/json',
        'Authorization': 'Basic ' + btoa(email+':'+password)
      }),
    };
    return this.http.put<Boolean>(h.host+'/signup_shmeio_dianomhs',name+':'+class_type+':'+address+':'+tel+':'+time_open+':'+senior,httpOptions); 
  }
  getuniversity_types(){
    const httpOptions={
      headers: new HttpHeaders({
        'Content-Type':  'application/json',
        'Authorization': 'Basic '
      }),
    };
    return this.http.get<any[]>(h.host+'/getuniversity_types',httpOptions); 
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
