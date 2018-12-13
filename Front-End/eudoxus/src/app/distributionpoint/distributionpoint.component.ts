import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { DistributionpointService } from './distributionpoint.service';

@Component({
  selector: 'app-distributionpoint',
  templateUrl: './distributionpoint.component.html',
  styleUrls: ['./distributionpoint.component.css']
})
export class DistributionpointComponent implements OnInit {

  constructor(private distrSer:DistributionpointService, private router:Router,private activatedRoute: ActivatedRoute) { }
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
