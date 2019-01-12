import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute} from '@angular/router';
import { SearchService } from './search.service';
import { Globals } from '../globals';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  constructor(private route: ActivatedRoute, private globals:Globals, private searchSer:SearchService) { }
  keyword=""
  results:any[]
  ngOnInit() {
    this.searchSer.searchBook(this.globals.keyword).subscribe(
      (res:any)=>{
        this.results=res
      }
    )
  }

}
