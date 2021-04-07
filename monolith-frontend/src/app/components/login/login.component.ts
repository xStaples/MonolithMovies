import { Component } from '@angular/core';
import { User } from 'src/app/models/user.model';
import { UserService } from 'src/app/services/user.service';
import { Router } from "@angular/router"

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  loginInfo: User = new User('','','','')
  user: User = new User('', '', '', '');

  constructor(private userServ: UserService, private router: Router) { }

  public loginUser() {
    console.log(this.loginInfo.username +" " +this.loginInfo.password);
    
    this.userServ.loginUser(this.loginInfo.username, this.loginInfo.password).subscribe(data => {
      this.user = data;

      console.log(this.user);
      if (this.user != null) {
        this.router.navigate(['/'])
      }
      // sessionStorage.setItem('loggedUser', JSON.stringify(this.user));
    });
    console.log(sessionStorage.getItem('loggedUser'));


  }


}
