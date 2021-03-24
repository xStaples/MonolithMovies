import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import {HttpClient} from '@angular/common/http';
import { ClientMessage } from '../models/client-message.model';
import { User } from '../models/user.model';
import { RDS_URL } from 'src/environments/environment';
import {catchError} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class UserService {


  constructor(private http:HttpClient) { }

  public registerUser(user: User): Observable<ClientMessage>{
    return this.http.post<ClientMessage>(`${RDS_URL}registerUser`, user)
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
