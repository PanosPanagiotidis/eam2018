import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute} from '@angular/router';
import { BrowseService } from './browse.service';

@Component({
  selector: 'app-browse',
  templateUrl: './browse.component.html',
  styleUrls: ['./browse.component.css']
})
export class BrowseComponent implements OnInit {

  constructor(private route: ActivatedRoute,private browseSer:BrowseService) { }

  browseType: string
  departments: any[]
  distpoints: any[]

  ngOnInit() {
    this.browseType=this.route.snapshot.paramMap.get('type');
    this.browseSer.getDepartments().subscribe(
      res=>{
        this.departments = res
      }
    )
    this.browseSer.getDistPoints().subscribe(
      res=>{
        this.distpoints = res
      }
    )
  }

}
