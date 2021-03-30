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
  
  constructor(private userServ:UserService) { }

  ngOnInit(): void {
  }

}
