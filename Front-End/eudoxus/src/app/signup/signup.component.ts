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

  ngOnInit() {
  }

  types: any[]=["Εκδότης", "Φοιτητής", "Σημειο Διανομης", "Γραμματεια Τμήματος", "Διαθέτης Δωρεάν Ηλεκτρ. Βοηθημάτων και Σημειώσεων", "Βιβλιοθήκη"];
  university_types: any[]=["Καποδιστριακο"]
  registrationtype=0;
  university_chosen='';

  selectedType(){
    if(this.registrationForm.value.user_type=='')
      this.registrationtype=0;
    else if(this.registrationForm.value.user_type=="Εκδότης")
      this.registrationtype=1;
    else if(this.registrationForm.value.user_type=="Φοιτητής")
      this.registrationtype=2;
    else if(this.registrationForm.value.user_type=="Σημειο Διανομης")
      this.registrationtype=3;
    else if(this.registrationForm.value.user_type=="Γραμματεια Τμήματος")
      this.registrationtype=4;
    else if(this.registrationForm.value.user_type=="Διαθέτης Δωρεάν Ηλεκτρ. Βοηθημάτων και Σημειώσεων")
      this.registrationtype=5;
    else if(this.registrationForm.value.user_type=="Βιβλιοθήκη")
      this.registrationtype=6;
  }

  selectedUniversityType(){
    if(this.registrationForm.value.university_type=='')
      return
    this.university_chosen=this.registrationForm.value.university_type;
  }

  onSubmit(){
    if(this.registrationtype==1){
      this.ekdoths();
    }
    else if(this.registrationtype==2){
      this.foithtes();
    }
    else if(this.registrationForm.value.user_type==3){
      this.shmeiadianomhs();
    }
    else if(this.registrationtype==4){
      this.grammateia();
    }
    else if(this.registrationtype==5){
      this.diathetes();
    }
    else if(this.registrationtype==6){
      this.bibliothikes();
    }
  }
  ekdoths(){
    if(this.registrationForm.value.name=='' || this.registrationForm.value.address=='' || this.registrationForm.value.email=='' || this.registrationForm.value.password1=='' || this.registrationForm.value.tel=='' || this.registrationForm.value.time_open=='' || this.registrationForm.value.senior==''){
      window.alert("Άδεια πεδία");
      return;
    }
    if(this.registrationForm.value.password1!=this.registrationForm.value.password2){
      window.alert("Ξαναγράψτε τον κωδικό");
      return;
    }
    this.signupSer.signup_ekdoths(this.registrationForm.value.name,this.registrationForm.value.address,this.registrationForm.value.email,this.registrationForm.value.password1, this.registrationForm.value.tel,this.registrationForm.value.time_open,this.registrationForm.value.senior)
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
    this.signupSer.signup_foithths(this.registrationForm.value.university_type,this.registrationForm.value.class_type,this.registrationForm.value.AM, this.registrationForm.value.name,this.registrationForm.value.surname,this.registrationForm.value.email,this.registrationForm.value.password1,this.registrationForm.value.tel,this.registrationForm.value.run_semester,this.registrationForm.value.numofbooks)
  
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
    this.signupSer.signup_shmeio_dianomhs(this.registrationForm.value.name,this.registrationForm.value.class_type,this.registrationForm.value.address,this.registrationForm.value.email,this.registrationForm.value.password1, this.registrationForm.value.tel,this.registrationForm.value.time_open,this.registrationForm.value.senior)
  }
  grammateia(){
    if(this.registrationForm.value.university_type=='' || this.registrationForm.value.class=='' || this.registrationForm.value.email=='' || this.registrationForm.value.password1=='' || this.registrationForm.value.tel==''|| this.registrationForm.value.time_open==''|| this.registrationForm.value.senior==''){
      window.alert("Άδεια πεδία");
      return;
    }
    if(this.registrationForm.value.password1!=this.registrationForm.value.password2){
      window.alert("Ξαναγράψτε τον κωδικό");
      return;
    }
    this.signupSer.signup_grammateia(this.registrationForm.value.university_type,this.registrationForm.value.class,this.registrationForm.value.email,this.registrationForm.value.password1,this.registrationForm.value.tel,this.registrationForm.value.time_open,this.registrationForm.value.senior)
  }
  diathetes(){
    if(this.registrationForm.value.email==''|| this.registrationForm.value.password1==''){
      window.alert("Άδεια πεδία");
      return;
    }
    if(this.registrationForm.value.password1!=this.registrationForm.value.password2){
      window.alert("Ξαναγράψτε τον κωδικό");
      return;
    }
    this.signupSer.signup_diatheths(this.registrationForm.value.email,this.registrationForm.value.password1);
  }
  bibliothikes(){
    if(this.registrationForm.value.name=='' || this.registrationForm.value.address=='' || this.registrationForm.value.email=='' || this.registrationForm.value.password1=='' || this.registrationForm.value.tel=='' || this.registrationForm.value.time_open=='' || this.registrationForm.value.senior==''){
      window.alert("Άδεια πεδία");
      return;
    }
    if(this.registrationForm.value.password1!=this.registrationForm.value.password2){
      window.alert("Ξαναγράψτε τον κωδικό");
      return;
    }
    this.signupSer.signup_bibliothiki(this.registrationForm.value.name,this.registrationForm.value.address,this.registrationForm.value.email,this.registrationForm.value.password1, this.registrationForm.value.tel,this.registrationForm.value.time_open,this.registrationForm.value.senior)
  }

}
