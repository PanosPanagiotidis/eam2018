import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { LibrariesService } from './libraries.service';
import { Router,ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-libraries',
  templateUrl: './libraries.component.html',
  styleUrls: ['./libraries.component.css']
})
export class LibrariesComponent implements OnInit {

  constructor(private libSer:LibrariesService, private router:Router,private activatedRoute: ActivatedRoute) { }

  page='';
  ngOnInit() {
    this.activatedRoute.queryParams.subscribe(params => {
      this.page = params['page'];
      if(this.page==undefined)
        this.page='';
      console.log(this.page);
    });
  }

}
