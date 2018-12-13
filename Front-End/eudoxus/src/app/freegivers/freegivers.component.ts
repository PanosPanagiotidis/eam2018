import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { FreegiversService } from './freegivers.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-freegivers',
  templateUrl: './freegivers.component.html',
  styleUrls: ['./freegivers.component.css']
})
export class FreegiversComponent implements OnInit {

  constructor(private freegiverSer:FreegiversService, private router:Router,private activatedRoute: ActivatedRoute) { }
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
