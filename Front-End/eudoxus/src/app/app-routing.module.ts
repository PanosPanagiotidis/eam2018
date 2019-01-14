import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DistributionpointComponent } from './distributionpoint/distributionpoint.component';
import { HelpComponent } from './help/help.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { StudentsComponent } from './students/students.component';
import { ProfileComponent } from './profile/profile.component';
import { SearchComponent } from './search/search.component';
import { BrowseComponent } from './browse/browse.component';

const routes: Routes = [
  { path: '',redirectTo: '/home', pathMatch:'full' },
  { path: 'distributions/:type', component: DistributionpointComponent },
  { path: 'help', component: HelpComponent },
  { path: 'home', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  { path: 'signup', component: SignupComponent },
  { path: 'students/:type', component: StudentsComponent },
  { path: 'profile', component: ProfileComponent },
  { path: 'search', component: SearchComponent },
  { path: 'browse/:type', component: BrowseComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
