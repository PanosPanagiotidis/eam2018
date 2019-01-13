import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { StudentsService } from '../students/students.service';
import { Router, ActivatedRoute} from '@angular/router';
import { SessionStorageService } from 'ngx-webstorage';
import { DistributionpointService } from '../distributionpoint/distributionpoint.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  @ViewChild('f') registrationForm: NgForm;

  constructor(private sessionSt:SessionStorageService,private studentSer:StudentsService, private router:Router,private distSer:DistributionpointService) { }
  change=0;
  user: any;
  shmeio: any;
  university: any;
  department: any;
  booksofthisseason: any[]=[];
  historyoforders: any[]=[];
  exhangebooks: any[]=[];
  loginState = false;
  userType:string
  ngOnInit() {
    this.loginState = this.sessionSt.retrieve("loginState")
    this.userType = this.sessionSt.retrieve("userType")
    if(this.loginState == false){
      this.router.navigate(["login"])
    }

    if(this.userType === "student"){
      this.studentSer.getdetails().subscribe(
        (res:any)=>{
          this.user=res;
          }
      );

      this.studentSer.getuniversity().subscribe(
        (res:any)=>{
          this.university=res;
          }
      );
      this.studentSer.getdepartment().subscribe(
        (res:any)=>{
          this.department=res;
          }
      );
    }
    else if(this.userType === "distributionPoint"){
      this.distSer.getdetails().subscribe(
        res=>{
          this.shmeio = res
        }
      )
    }
    

    

    
  }


  onSubmitdetails(){
    if(this.registrationForm.value.password1!=this.registrationForm.value.password2){
      window.alert("Ξαναγράψτε τον κωδικό");
      return;
    }
    if(this.registrationForm.value.name=='')
      this.registrationForm.value.name=this.user.name;
    if(this.registrationForm.value.surname=='')
      this.registrationForm.value.surname=this.user.surname;
    if(this.registrationForm.value.email=='')
      this.registrationForm.value.email=this.user.email;
    if(this.registrationForm.value.password1=='')
      this.registrationForm.value.password1=this.user.password;
    if(this.registrationForm.value.tel=='')
      this.registrationForm.value.tel=this.user.phone;
    this.studentSer.update_foithths(this.registrationForm.value.name,this.registrationForm.value.surname,this.user.email,this.registrationForm.value.email,this.registrationForm.value.password1,this.registrationForm.value.tel,).subscribe(
      (res:any)=>{
        if(res){
          this.change=0;
          this.sessionSt.store('email',this.registrationForm.value.email);
          this.sessionSt.store('password',this.registrationForm.value.password);
          this.router.navigateByUrl('/home', {skipLocationChange: true}).then(()=>this.router.navigate(["students/details"])); 
        }
        else
          window.alert("User with same email already exists!");
      });
  }

  onSubmitchange(){
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
    this.distSer.update_shmeio(this.registrationForm.value.name,this.shmeio.email,this.registrationForm.value.email,this.registrationForm.value.password1,this.registrationForm.value.tel,this.registrationForm.value.address,this.registrationForm.value.time_open,this.registrationForm.value.senior).subscribe(
      (res:any)=>{
        if(res){
          this.change=0;
          this.sessionSt.store('email',this.registrationForm.value.email);
          this.sessionSt.store('password',this.registrationForm.value.password);
          this.router.navigateByUrl('/home', {skipLocationChange: true}).then(()=>this.router.navigate(["profile"])); 
        }
        else
          window.alert("User with same email already exists!");
      });
  }
}
