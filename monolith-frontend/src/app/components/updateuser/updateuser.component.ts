import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/user.model';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-updateuser',
  templateUrl: './updateuser.component.html',
  styleUrls: ['./updateuser.component.css']
})
export class UpdateuserComponent{
  updatedInfo:User = new User('','','','');
  user:User = new User('','','','');

  constructor(private userServ:UserService) { };

  updateUser(){
    this.userServ.updateUser(this.user);
  }

}
