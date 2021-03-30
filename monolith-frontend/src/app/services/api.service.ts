import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { MOVIE_API } from 'src/environments/environment';
import { Movie } from '../models/movie.model';


@Injectable({
  providedIn: 'root'
})
export class ApiService{

  data:any = []
  constructor(private http:HttpClient) { }

  public findMovies(movie: Movie): Observable<any>{
    
    const url = `http://www.omdbapi.com/?s=${movie.name}&apikey=${MOVIE_API}`;
    this.http.get(url).subscribe((res) => {
      this.data = res
      console.log(res);
      
    })
    
    return this.http.get(url);
  }

  public getMovieDetails(movie: Movie): Observable<any>{
    const url = `http://www.omdbapi.com/?t=${movie.name}&apikey=${MOVIE_API}`;
    this.http.get(url).subscribe((res) => {
      this.data = res
      console.log(res);
      
    })
    return this.http.get(url);
  }

  getBestMovies(): Observable<any>{
    const url = `http://www.omdbapi.com/?s=the%20avengers&apikey=${MOVIE_API}`
    this.http.get(url).subscribe((res) => {
      this.data = res
      console.log(res);
    })

    return this.http.get(url);
  }
}
