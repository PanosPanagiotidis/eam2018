import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { PublishersService } from './publishers.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-publishers',
  templateUrl: './publishers.component.html',
  styleUrls: ['./publishers.component.css']
})
export class PublishersComponent implements OnInit {

  constructor(private publishSer:PublishersService, private router:Router,private activatedRoute: ActivatedRoute) { }s
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
