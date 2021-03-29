import { HttpClient } from '@angular/common/http';
import { Injectable, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { MOVIE_API } from 'src/environments/environment';
import { Movie } from '../models/movie.model';


@Injectable({
  providedIn: 'root'
})
export class ApiService{

  
  constructor(private http:HttpClient) { }

  public findMovies(movie: Movie): Observable<any>{
    
  
    
    return this.http.post<any>(`https://imdb8.p.rapidapi.com/title/find?q=${movie.name}`, movie)
  }
}
