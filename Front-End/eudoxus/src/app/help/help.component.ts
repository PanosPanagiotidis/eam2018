import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { HelpService } from './help.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-help',
  templateUrl: './help.component.html',
  styleUrls: ['./help.component.css']
})
export class HelpComponent implements OnInit {

  constructor(private helpSer:HelpService, private router:Router,private activatedRoute: ActivatedRoute) { }

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
