import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { SignupService } from './signup.service';
import { Router } from '@angular/router';
import { THIS_EXPR } from '@angular/compiler/src/output/output_ast';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  @ViewChild('f') registrationForm: NgForm;

  constructor(private signupSer:SignupService, private router:Router) { }

  class_types2:any=["Καθηγητης","Βιβλιοπωλείο"]
  ngOnInit() {
  }

  types: any[]=["Εκδότης", "Φοιτητής", "Σημειο Διανομης", "Γραμματεια Τμήματος", "Διαθέτης Δωρεάν Ηλεκτρ. Βοηθημάτων και Σημειώσεων", "Βιβλιοθήκη"];
  university_types: any[]=[];
  class_types: any[]=[];
  registrationtype=0;
  university_chosen='';

  selectedType(){
    if(this.registrationForm.value.user_type=='')
      this.registrationtype=0;
    else if(this.registrationForm.value.user_type=="Φοιτητής")
    { 
      this.signupSer.getuniversity_types().subscribe(
        (res:any[])=>{
          this.university_types=[];
          for(var i in res){
            this.university_types.push(res[i].name);
          }
      });  
      this.registrationtype=1;
    }
    else if(this.registrationForm.value.user_type=="Σημειο Διανομης")
      this.registrationtype=2;
  }

  selectedUniversityType(){
    if(this.registrationForm.value.university_type=='')
      return
    this.university_chosen=this.registrationForm.value.university_type;
    this.signupSer.getdepartment_types(this.university_chosen).subscribe(
      (res:any[])=>{
        this.class_types=[];
        for(var i in res){
          this.class_types.push(res[i].name);
        }
    });  

  }

  onSubmit(){
    if(this.registrationtype==1){
      this.foithtes();
    }
    else if(this.registrationtype==2){
      this.shmeiadianomhs();
    }

  }
  foithtes(){
    if(this.registrationForm.value.university_type=='' || this.registrationForm.value.class_type=='' || this.registrationForm.value.AM<=0 ||  this.registrationForm.value.name=='' || this.registrationForm.value.surname=='' || this.registrationForm.value.email=='' || this.registrationForm.value.password1=='' || this.registrationForm.value.tel==''|| this.registrationForm.value.run_semester<=0 || this.registrationForm.value.numofbooks<=0){
      window.alert("Άδεια πεδία");
      return;
    }
    if(this.registrationForm.value.password1!=this.registrationForm.value.password2){
      window.alert("Ξαναγράψτε τον κωδικό");
      return;
    }
    this.signupSer.signup_foithths(this.registrationForm.value.university_type,this.registrationForm.value.class_type,this.registrationForm.value.AM, this.registrationForm.value.name,this.registrationForm.value.surname,this.registrationForm.value.email,this.registrationForm.value.password1,this.registrationForm.value.tel,this.registrationForm.value.run_semester,this.registrationForm.value.numofbooks).subscribe(
      res=>{
        if(res)
          this.router.navigate(['login']);
        else
          window.alert("User with same email already exists!");
      });
  
  }
  shmeiadianomhs(){
    if(this.registrationForm.value.name==''|| this.registrationForm.value.class_type=='' || this.registrationForm.value.address=='' || this.registrationForm.value.email=='' || this.registrationForm.value.password1=='' || this.registrationForm.value.tel=='' || this.registrationForm.value.time_open=='' || this.registrationForm.value.senior==''){
      window.alert("Άδεια πεδία");
      return;
    }
    if(this.registrationForm.value.password1!=this.registrationForm.value.password2){
      window.alert("Ξαναγράψτε τον κωδικό");
      return;
    }
    this.signupSer.signup_shmeio_dianomhs(this.registrationForm.value.name,this.registrationForm.value.class_type,this.registrationForm.value.address,this.registrationForm.value.email,this.registrationForm.value.password1, this.registrationForm.value.tel,this.registrationForm.value.time_open,this.registrationForm.value.senior).subscribe(
      res=>{
        if(res)
          this.router.navigate(['login']);
        else
          window.alert("User with same email already exists!");
      });
  }

}
