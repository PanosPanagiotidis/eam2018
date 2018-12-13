import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { SecretariatService } from './secretariat.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-secretariat',
  templateUrl: './secretariat.component.html',
  styleUrls: ['./secretariat.component.css']
})
export class SecretariatComponent implements OnInit {

  constructor(private secrSer:SecretariatService, private router:Router,private activatedRoute: ActivatedRoute) { }
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
