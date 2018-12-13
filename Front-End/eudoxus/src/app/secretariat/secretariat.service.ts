import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import * as h from '../host';
import { SessionStorageService } from 'ngx-webstorage';


@Injectable({
  providedIn: 'root'
})
export class SecretariatService {

  constructor(private http:HttpClient, private sessionSt:SessionStorageService) { }
}
