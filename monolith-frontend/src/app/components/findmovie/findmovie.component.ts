import { Component } from '@angular/core';
import { Movie } from 'src/app/models/movie.model';
import { ReceivedMovie } from 'src/app/models/received-movie.model';
import { ApiService } from 'src/app/services/api.service';

@Component({
  selector: 'app-findmovie',
  templateUrl: './findmovie.component.html',
  styleUrls: ['./findmovie.component.css']
})
export class FindmovieComponent{

  //TODO search feature for single move
  title="Search Movies!"
  public movie: Movie = new Movie('')
  public movieResults:ReceivedMovie = new ReceivedMovie('', '', 0)

  constructor(private apiServ: ApiService) { }


  public findMovie(): void{
    this.apiServ.findMovies(this.movie).subscribe(data => this.movieResults = data)
    console.log(this.movieResults)
  }
}
