import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { FreegiversService } from './freegivers.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-freegivers',
  templateUrl: './freegivers.component.html',
  styleUrls: ['./freegivers.component.css']
})
export class FreegiversComponent implements OnInit {

  constructor(private freegiverSer:FreegiversService, private router:Router) { }

  ngOnInit() {
  }

}
