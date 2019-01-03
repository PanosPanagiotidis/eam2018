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

  constructor(private sessionSt:SessionStorageService,private distrSer:DistributionpointService, private router:Router,private route: ActivatedRoute) { }
  page='';
  shmeio:any;
  change=0;
  ngOnInit() {
    this.page=this.route.snapshot.paramMap.get('type');
    if(this.page=='details'){
      this.distrSer.getdetails().subscribe(
        (res:any)=>{
          this.shmeio=res;
          }
      );
    }
  }

  onSubmit(){
    if(this.registrationForm.value.password1!=this.registrationForm.value.password2){
      window.alert("Ξαναγράψτε τον κωδικό");
      return;
    }
    if(this.registrationForm.value.name=='')
      this.registrationForm.value.name=this.shmeio.name;
    if(this.registrationForm.value.address=='')
      this.registrationForm.value.address=this.shmeio.address;
    if(this.registrationForm.value.email=='')
      this.registrationForm.value.email=this.shmeio.email;
    if(this.registrationForm.value.password1=='')
      this.registrationForm.value.password1=this.shmeio.password;
    if(this.registrationForm.value.tel=='')
      this.registrationForm.value.tel=this.shmeio.phone;
    if(this.registrationForm.value.senior=='')
      this.registrationForm.value.senior=this.shmeio.senior;
    if(this.registrationForm.value.time_open=='')
      this.registrationForm.value.time_open=this.shmeio.time_open;
    this.distrSer.update_shmeio(this.registrationForm.value.name,this.shmeio.email,this.registrationForm.value.email,this.registrationForm.value.password1,this.registrationForm.value.tel,this.registrationForm.value.address,this.registrationForm.value.time_open,this.registrationForm.value.senior).subscribe(
      (res:any)=>{
        if(res){
          this.change=0;
          this.sessionSt.store('email',this.registrationForm.value.email);
          this.sessionSt.store('password',this.registrationForm.value.password);
          this.router.navigateByUrl('/home', {skipLocationChange: true}).then(()=>this.router.navigate(["distributions/details"])); 
        }
        else
          window.alert("User with same email already exists!");
      });
  }

}
