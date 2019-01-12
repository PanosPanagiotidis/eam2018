import { Component } from '@angular/core';
import { LoginService } from './login/login.service'
import { Router, ActivatedRoute} from '@angular/router';
import { Globals } from './globals'

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent {
  constructor(private loginSer:LoginService,private router:Router,private globals:Globals) { }

  searchInput:any

  title = 'eudoxus';
  onLogout(){
    console.log("logout")
    this.loginSer.logout()
  }

  onSearch(){
    this.globals.keyword = this.searchInput
    this.router.navigate(["search"])
  }
}