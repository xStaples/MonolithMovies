import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-movie-details',
  templateUrl: './movie-details.component.html',
  styleUrls: ['./movie-details.component.css']
})
export class MovieDetailsComponent implements OnInit {
  title = "Movie Details"
  constructor() { }

  movieDetails: any = [];

  ngOnInit(): void {
  }

}
