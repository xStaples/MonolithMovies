import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent implements OnInit{

  loggedOn: boolean = false;
  constructor(private userServ:UserService, ) { }


  ngOnInit(): void {
    this.navDisplay()
  }


  public navDisplay(){
    this.loggedOn = this.userServ.isUserSignedIn()
    return this.loggedOn;
  }

  public logout():void{
    this.userServ.logout()
  }
}
