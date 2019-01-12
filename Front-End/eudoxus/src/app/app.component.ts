import { Component } from '@angular/core';
import { LoginService } from './login/login.service'
import { Router, ActivatedRoute} from '@angular/router';
import { SearchService } from './search/search.service';
import { Globals } from './globals'


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent {
  constructor(private loginSer:LoginService,private router:Router,private globals:Globals, private searchSer:SearchService) { }

  searchInput:any

  title = 'eudoxus';
  onLogout(){
    console.log("logout")
    this.loginSer.logout()
  }

  onSearch(){
    this.searchSer.searchBook(this.searchInput).subscribe(
      (res:any)=>{
        this.globals.results=res
        console.log(this.globals.results)
        this.router.navigate(["search"])
      }
    )
  }
}