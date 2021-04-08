import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/user.model';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-updateuser',
  templateUrl: './updateuser.component.html',
  styleUrls: ['./updateuser.component.css']
})
export class UpdateuserComponent{

  canEdit:boolean = false;

  updatedInfo:User = new User('','','','');
  user:User = new User('Santa','Clause','test','testpass');

  constructor(private userServ:UserService) { };
  editForm(){
    this.canEdit = !this.canEdit
  }
  saveForm(){
    console.log("Saved!");
    console.log(this.user);
    console.log(this.updatedInfo);
    
    this.editForm();
  }
  updateUser(){

    // this.userServ.updateUser(this.user);
  }

}
