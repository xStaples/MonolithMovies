import { Component } from '@angular/core';
import { Movie } from 'src/app/models/movie.model';
import { ApiService } from 'src/app/services/api.service';
import {ModalDismissReasons, NgbModal} from '@ng-bootstrap/ng-bootstrap';


@Component({
  selector: 'app-findmovie',
  templateUrl: './findmovie.component.html',
  styleUrls: ['./findmovie.component.css']
})
export class FindmovieComponent{

  //TODO search feature for single move
  title="Search Movies!"
  public movie: Movie = new Movie('')
  public movieResults?: any = []
  public movieDetails?: any = []
  

  constructor(private apiServ: ApiService, private modalServ:NgbModal) { }

  closeModal!: string;
  public findMovie(): void{
    this.apiServ.findMovies(this.movie).subscribe((data) => {
      this.movieResults = data
      return this.movieResults
    });
    console.log(this.movieResults);
    
  }

  public getMovieDetails(): void {
    this.apiServ.getMovieDetails(this.movie).subscribe((data) => {
      this.movieDetails = data;
      console.log(this.movieDetails);
      return this.movieDetails
    });

  }

  public openDetails(content: any){
    const cardTitle = document.getElementById('movie-title')?.innerText;
    // this.movie.name? = cardTitle
    console.log(cardTitle);
    this.modalServ.open(content, {ariaLabelledBy: 'my-modal'}).result.then((res)=>{
      this.closeModal=`Closed with: ${res}`;
      

      
      
    })
    console.log(this.getMovieDetails());
  }
}
