import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/user.model';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent implements OnInit{

  loggedOn: boolean = false;
  constructor(private userServ:UserService, ) { }
  user: User = JSON.parse(sessionStorage.getItem('loggedUser')!) 

  ngOnInit(): void {
    this.navDisplay()
  }
  

  public navDisplay(){
    this.loggedOn = this.userServ.isUserSignedIn(this.user)
    
    return this.loggedOn;
  }

  public logout():void{
    this.userServ.logout()
  }
}
