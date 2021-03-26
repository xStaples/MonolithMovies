import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import {HttpClient} from '@angular/common/http';
import { ClientMessage } from '../models/client-message.model';
import { User } from '../models/user.model';
import { BACKEND_URL } from 'src/environments/environment';
import {catchError} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class UserService {


  constructor(private http:HttpClient) { }

  public updateUser(user:User){
    //TODO: service layer update user account info
  }

  public loginUser(user: User){
    //TODO: service layer login function
  }


  public registerUser(user: User): Observable<ClientMessage>{
    return this.http.post<ClientMessage>(`${BACKEND_URL}registerUser`, user)
    .pipe(
      catchError(this.handleError<any>('Cannot register User!'))
    )
  }

  private handleError<T>(operation = 'operation', result?: T){
    return(error: any): Observable<T> => {
      console.error(error);
      return of(result as T)
    }
  }
}
