import { Component } from '@angular/core';
import { Movie } from 'src/app/models/movie.model';

@Component({
  selector: 'app-findmovie',
  templateUrl: './findmovie.component.html',
  styleUrls: ['./findmovie.component.css']
})
export class FindmovieComponent{

  //TODO search feature for single move
  title="Search Movies!"
  public movie: Movie = new Movie('')
  constructor() { }

}
