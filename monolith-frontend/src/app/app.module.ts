import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MainComponent } from './components/main/main.component';
import { NavComponent } from './components/nav/nav.component';
import { RegisterComponent } from './components/register/register.component';
import { LoginComponent } from './components/login/login.component';
import { AllmoviesComponent } from './components/allmovies/allmovies.component';
import { FindmovieComponent } from './components/findmovie/findmovie.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule} from '@angular/common/http';
import { ResetpasswordComponent } from './components/resetpassword/resetpassword.component';
import { ReviewsComponent } from './components/reviews/reviews.component';
import { UpdateuserComponent } from './components/updateuser/updateuser.component';

@NgModule({
  declarations: [
    AppComponent,
    MainComponent,
    NavComponent,
    RegisterComponent,
    LoginComponent,
    AllmoviesComponent,
    FindmovieComponent,
    ResetpasswordComponent,
    ReviewsComponent,
    UpdateuserComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
