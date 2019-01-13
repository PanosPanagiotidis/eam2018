import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { LoginService } from './login.service';
import { Router } from '@angular/router';
import { SessionStorageService } from 'ngx-webstorage';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  @ViewChild('f') loginform: NgForm;

  constructor(private loginSer:LoginService, private router:Router, private sessionSt:SessionStorageService) { }

  ngOnInit() {
  }

  onLogin(){
    this.loginSer.login(this.loginform.value.email,this.loginform.value.password).subscribe(
      res=>{
        if(res){
          this.sessionSt.store('email',this.loginform.value.email);
          this.sessionSt.store('password',this.loginform.value.password);
          this.sessionSt.store('loginState',true);
          if(res == 2){
            this.sessionSt.store('userType',"student")
          }
          else if(res == 3){
            this.sessionSt.store('userType',"distributionPoint")
          }
          
          this.router.navigate(['home']);
        }
        else{
          window.alert("Wrong email and/or password");
        }
          
      }
    )
  }
}
