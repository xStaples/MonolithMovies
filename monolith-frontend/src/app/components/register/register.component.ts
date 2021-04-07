import { Component } from '@angular/core';
import { User } from 'src/app/models/user.model';
import { UserService } from 'src/app/services/user.service';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import {Router} from "@angular/router"



@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {


  constructor(private userServ: UserService, private router:Router) { }

  user: User = new User('', '', '', '');

  public registerUser(): void {
    this.userServ.registerUser(this.user).subscribe(data => this.user = data)
    console.log(this.user);
    this.router.navigate(['/login'])
  }
}
