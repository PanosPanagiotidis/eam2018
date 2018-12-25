import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { LoginService } from './login.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  @ViewChild('f') loginform: NgForm;

  constructor(private loginSer:LoginService, private router:Router) { }

  ngOnInit() {
  }

  onSubmit(){
    this.loginSer.login(this.loginform.value.email,this.loginform.value.password).subscribe(
      res=>{
        if(res)
          if(this.loginform.value.email=="admin")
            this.router.navigate(['home']);
          else
          this.router.navigate(['customer']);
        else
          window.alert("Wrong email and/or password");
      }
    )
  }

}
