import { Component, OnInit } from '@angular/core';
import { ClientMessage } from 'src/app/models/client-message.model';
import { User } from 'src/app/models/user.model';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {


  title = "User Login"

  constructor() { }

  public user: User = new User('', '', '', '', 0)
  public clientMessage: ClientMessage = new ClientMessage('');

}
