import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/user.model';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-updateuser',
  templateUrl: './updateuser.component.html',
  styleUrls: ['./updateuser.component.css']
})
export class UpdateuserComponent implements OnInit {

  title = "Update Profile"
  firstName!:string;
  lastName!:string;
  username!:string;
  password!:string;
  
  isLoggedOn : boolean = false;
  

  user:User = new User(this.firstName, this.lastName, this.username, this.password)
  display: any;
  constructor(private userServ:UserService) { }

  ngOnInit(): void {
    this.isLoggedOn = this.userServ.isUserSignedIn(this.user);
    var display = document.getElementById('updateUser-body');
    if(this.isLoggedOn != false){
      
     display!.title = `sup`
    }
   
  }

  updateUser(){
    this.userServ.updateUser(this.user);
  }

}
