import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AllmoviesComponent } from './components/allmovies/allmovies.component';
import { FindmovieComponent } from './components/findmovie/findmovie.component';
import { LoginComponent } from './components/login/login.component';
import { MainComponent } from './components/main/main.component';
import { RegisterComponent } from './components/register/register.component';

const routes: Routes = [
  {path: '', redirectTo: 'main', pathMatch: 'full'},
  {path: 'main', component:MainComponent},
  {path: 'register', component:RegisterComponent},
  {path: 'login', component:LoginComponent},
  {path: 'allmovies', component: AllmoviesComponent},
  {path: 'findmovie', component:FindmovieComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
