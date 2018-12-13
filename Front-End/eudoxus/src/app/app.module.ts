import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { NgxWebstorageModule } from 'ngx-webstorage';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { HomeComponent } from './home/home.component';
import { StudentsComponent } from './students/students.component';
import { PublishersComponent } from './publishers/publishers.component';
import { HelpComponent } from './help/help.component';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { DistributionpointComponent } from './distributionpoint/distributionpoint.component';
import { SecretariatComponent } from './secretariat/secretariat.component';
import { FreegiversComponent } from './freegivers/freegivers.component';
import { LibrariesComponent } from './libraries/libraries.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    StudentsComponent,
    PublishersComponent,
    HelpComponent,
    LoginComponent,
    SignupComponent,
    DistributionpointComponent,
    SecretariatComponent,
    FreegiversComponent,
    LibrariesComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    NgxWebstorageModule.forRoot(),
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
