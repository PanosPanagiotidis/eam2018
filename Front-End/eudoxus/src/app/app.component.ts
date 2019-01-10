import { Component } from '@angular/core';
import { LoginService } from './login/login.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  constructor(private loginSer:LoginService) { }
  title = 'eudoxus';
  onLogout(){
    console.log("logout")
    this.loginSer.logout()
  }
}