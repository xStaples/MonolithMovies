import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { MOVIE_API } from 'src/environments/environment';
import { Movie } from '../models/movie.model';
import { HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  constructor(private http: HttpClient) { }

  
  // getMovies(){
  //   return this.http.get()
  // }
  public findMovies(movie: Movie): Observable<any>{
    const headers = new HttpHeaders;
    headers.set('x-rapidapi-key', MOVIE_API);
    
    console.log(headers.set('x-rapidapi-key', MOVIE_API));
    
    return this.http.post<any>(`https://imdb8.p.rapidapi.com/title/find?q=${movie.name}`,{'headers':headers})
  }
}
