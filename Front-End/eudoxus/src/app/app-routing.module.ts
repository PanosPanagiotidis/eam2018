import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DistributionpointComponent } from './distributionpoint/distributionpoint.component';
import { FreegiversComponent } from './freegivers/freegivers.component';
import { HelpComponent } from './help/help.component';
import { HomeComponent } from './home/home.component';
import { LibrariesComponent } from './libraries/libraries.component';
import { LoginComponent } from './login/login.component';
import { PublishersComponent } from './publishers/publishers.component';
import { SecretariatComponent } from './secretariat/secretariat.component';
import { SignupComponent } from './signup/signup.component';
import { StudentsComponent } from './students/students.component';

const routes: Routes = [
  { path: '',redirectTo: '/home', pathMatch:'full' },
  { path: 'distributions', component: DistributionpointComponent },
  { path: 'freegivers', component: FreegiversComponent },
  { path: 'help', component: HelpComponent },
  { path: 'home', component: HomeComponent },
  { path: 'libraries', component: LibrariesComponent },
  { path: 'login', component: LoginComponent },
  { path: 'publishers', component: PublishersComponent },
  { path: 'secretariats', component: SecretariatComponent },
  { path: 'signup', component: SignupComponent },
  { path: 'students', component: StudentsComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
