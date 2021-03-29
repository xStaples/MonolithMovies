import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AllmoviesComponent } from './components/allmovies/allmovies.component';
import { FindmovieComponent } from './components/findmovie/findmovie.component';
import { LoginComponent } from './components/login/login.component';
import { MainComponent } from './components/main/main.component';
import { RegisterComponent } from './components/register/register.component';
import { ResetpasswordComponent } from './components/resetpassword/resetpassword.component';

const routes: Routes = [
  {path: '', redirectTo: 'main', pathMatch: 'full'},
  {path: 'main', component:MainComponent},
  {path: 'movieuser/adduser', component:RegisterComponent},
  {path: 'user/login', component:LoginComponent},
  {path: 'allmovies', component: AllmoviesComponent},
  {path: 'findmovie', component:FindmovieComponent},
  {path: 'resetpassword', component:ResetpasswordComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
