import { Component } from '@angular/core';
import { ClientMessage } from 'src/app/models/client-message.model';
import { User } from 'src/app/models/user.model';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {


  title = "User Login"
  username!:string;
  password!:string;

  
  public clientMessage: ClientMessage = new ClientMessage('')
  user?: User;
  
  constructor(private userServ:UserService) { }





  public loginUser(){
    
    this.userServ.loginUser(this.username, this.password).subscribe(data => {this.user = data, (error: any) => this.clientMessage.message = "Username or Password is Incorrect. Please try again."; 
    sessionStorage.setItem('loggedUser', JSON.stringify(this.user));
    })
    console.log(sessionStorage.getItem('loggedUser'));
    
  }

  
}
