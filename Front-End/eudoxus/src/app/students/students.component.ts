import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { StudentsService } from './students.service';
import { Router, ActivatedRoute} from '@angular/router';
import { SessionStorageService } from 'ngx-webstorage';


@Component({
  selector: 'app-students',
  templateUrl: './students.component.html',
  styleUrls: ['./students.component.css']
})
export class StudentsComponent implements OnInit {

  @ViewChild('f') registrationForm: NgForm;
  @ViewChild('f') exhangeForm: NgForm;
  constructor(private sessionSt:SessionStorageService,private studentSer:StudentsService, private router:Router,private route: ActivatedRoute) { }
  page='';
  change=0;
  user: any;
  university: any;
  department: any;
  booksofthisseason: any[]=[];
  historyoforders: any[]=[];
  exhangebooks: any[]=[];
  ngOnInit() {
    this.page=this.route.snapshot.paramMap.get('type');
    if(this.page=='details'){
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
    if(this.page=='declaration'){
      this.studentSer.getseasonbooks().subscribe(
        (res:any[])=>{
          this.booksofthisseason=res;
        }
      )
    }
    if(this.page=='history'){
      this.studentSer.gethistory().subscribe(
        (res:any[])=>{
          this.historyoforders=res;
        }
      )
    }
    if(this.page=='exhange'){
      this.studentSer.getavailablebooksforexhange().subscribe(
        (res:any[])=>{
          this.exhangebooks=res;
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
  onSubmitexhange(){
    this.studentSer.exhangebooks(this.exhangeForm.value.name).subscribe(
      res=>{
        if(res==true)
          this.router.navigateByUrl('/home', {skipLocationChange: true}).then(()=>this.router.navigate(["students/details"])); 
      }
    )
  }
}
