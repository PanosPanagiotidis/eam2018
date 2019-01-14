import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { NgxWebstorageModule } from 'ngx-webstorage';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { HomeComponent } from './home/home.component';
import { StudentsComponent } from './students/students.component';
import { HelpComponent } from './help/help.component';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { DistributionpointComponent } from './distributionpoint/distributionpoint.component';
import { ProfileComponent } from './profile/profile.component';
import { SearchComponent } from './search/search.component';
import { Globals } from './globals';
import { BrowseComponent } from './browse/browse.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    StudentsComponent,
    HelpComponent,
    LoginComponent,
    SignupComponent,
    DistributionpointComponent,
    ProfileComponent,
    SearchComponent,
    BrowseComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    NgxWebstorageModule.forRoot(),
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [Globals],
  bootstrap: [AppComponent]
})
export class AppModule { }
