import { Component, OnInit } from '@angular/core';
import { ClientMessage } from 'src/app/models/client-message.model';
import { LoginTemplete } from 'src/app/models/login-templete.model';

import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {


  title = "User Login"

  constructor(private userServ:UserService) { }

  public user: LoginTemplete = new LoginTemplete('', '')
  public clientMessage: ClientMessage = new ClientMessage('');


  public loginUser():void{
    
    this.userServ.loginUser(this.user).subscribe(data => this.clientMessage = data, error => this.clientMessage.message = "Username or Password is Incorrect. Please try again.")
    console.log(this.user);
  }
}
