import { Component, OnInit } from '@angular/core';
import { ApiService } from 'src/app/services/api.service';

@Component({
  selector: 'app-allmovies',
  templateUrl: './allmovies.component.html',
  styleUrls: ['./allmovies.component.css']
})
export class AllmoviesComponent implements OnInit {


  title = "Movies"
  movies?: any = [];
  constructor(private apiServ: ApiService) { }


  ngOnInit(): void {

    console.log(this.apiServ.getBestMovies().subscribe(data => this.movies = data));
    
  }

}
