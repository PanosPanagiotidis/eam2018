import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { DistributionpointService } from './distributionpoint.service';

@Component({
  selector: 'app-distributionpoint',
  templateUrl: './distributionpoint.component.html',
  styleUrls: ['./distributionpoint.component.css']
})
export class DistributionpointComponent implements OnInit {

  constructor(private distrSer:DistributionpointService, private router:Router) { }

  ngOnInit() {
  }

}
