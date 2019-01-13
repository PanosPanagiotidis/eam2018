import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { DistributionpointService } from './distributionpoint.service';
import { SessionStorageService } from 'ngx-webstorage';

@Component({
  selector: 'app-distributionpoint',
  templateUrl: './distributionpoint.component.html',
  styleUrls: ['./distributionpoint.component.css']
})
export class DistributionpointComponent implements OnInit {
  
  @ViewChild('f') registrationForm: NgForm;
  @ViewChild('n') insertionForm: NgForm;
  @ViewChild('s') searchForm: NgForm;
  @ViewChild('d') deliveryForm: NgForm;

  constructor(private sessionSt:SessionStorageService,private distrSer:DistributionpointService, private router:Router,private route: ActivatedRoute) { }
  page='';
  shmeio:any;
  change=0;
  searchbooks: any[]=[];
  allbooks: any[]=[];
  deliverybooks: any[]=[];
  ngOnInit() {
    this.page=this.route.snapshot.paramMap.get('type');
    if(this.page=='details'){
      this.distrSer.getdetails().subscribe(
        (res:any)=>{
          this.shmeio=res;
          }
      );
    }
    if(this.page=='allbooks'){
      this.distrSer.getallbooks().subscribe(
        (res:any[])=>{
          this.allbooks=res;
          }
      );
    }
  }

  onSubmitsearch(){
    this.distrSer.searchbooks(this.searchForm.value.name).subscribe(
      (res:any[])=>{
        if(res==null)
          window.alert("No book with these characteristics")
        else{
          this.searchbooks=res;
          this.page="searchresults";
        }
      }
    )
  }

  onSubmitinsert(){
    this.distrSer.insertbooks(this.insertionForm.value.name).subscribe(
      res=>{
        if(res==true)
          this.router.navigateByUrl('/home', {skipLocationChange: true}).then(()=>this.router.navigate(["distributions/allbooks"])); 
      }
    )
  }
  
  onSubmitdelivery(){
    this.distrSer.delivery(this.deliveryForm.value.pin).subscribe(
      (res:any[])=>{
        if(res==null)
          window.alert("No such pin")
        else{
          this.deliverybooks=res;
          this.page="deliverybooks";
        }
      }
    )
  }

}
