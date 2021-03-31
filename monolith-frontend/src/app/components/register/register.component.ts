import { Component} from '@angular/core';
import { ClientMessage } from 'src/app/models/client-message.model';
import { User } from 'src/app/models/user.model';
import { UserService } from 'src/app/services/user.service';


@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent{

  title = "New User Registration"
  constructor(private userServ: UserService) { }

  public user: User = new User('', '', '', '')
  public clientMessage: ClientMessage = new ClientMessage('');

  public registerUser(): void{
    this.userServ.registerUser(this.user).subscribe(data => this.clientMessage = data, error => this.clientMessage.message = "Something went wrong")
    console.log(this.user);
    
  }
}
