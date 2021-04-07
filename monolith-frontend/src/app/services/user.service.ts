import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import {HttpClient} from '@angular/common/http';
import { ClientMessage } from '../models/client-message.model';
import { User } from '../models/user.model';
import { BACKEND_URL } from 'src/environments/environment';
import {catchError} from 'rxjs/operators';

@Injectable({
  providedIn: 'any'
})
export class UserService {

  user?:User;

  constructor(private http:HttpClient) { }

  public updateUser(user:User){
  
  }

  public loginUser(username:string, password:string) {

    return this.http.get<User>(`${BACKEND_URL}movieusers/login/${username}/${password}`)
  }

  public logout(){
  
    sessionStorage.clear();
  }

  public registerUser(user: User): Observable<User>{
    return this.http.post<User>(`${BACKEND_URL}movieusers/adduser`, user)
    .pipe(
      catchError(this.handleError<any>('Cannot register User!'))
    )
  }

  public isUserSignedIn(user:User){
    if(user !== null){
      return true;
    }else{return false}
  }

  private handleError<T>(operation = 'operation', result?: T){
    return(error: any): Observable<T> => {
      console.error(error);
      return of(result as T)
    }
  }
}
