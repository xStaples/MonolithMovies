import { Component, Directive } from '@angular/core';
import { Movie } from 'src/app/models/movie.model';
import { ApiService } from 'src/app/services/api.service';
import { NgbModal} from '@ng-bootstrap/ng-bootstrap';


@Component({
  selector: 'app-findmovie',
  templateUrl: './findmovie.component.html',
  styleUrls: ['./findmovie.component.css']
})


export class FindmovieComponent{

  //TODO search feature for single move
  title="Search Movies!"
  public movie: Movie = new Movie('');
  public selectedMovie: Movie = new Movie('');
  public movieDetails?: any = [];
  public movieResults?: any = [];
  
  

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

    });

  }

  public openDetails(content: any){


    let cardTitle = document.getElementsByClassName('card-title');
    
    for (let i = 0; i < cardTitle.length; i++) {
      const movieTitle = cardTitle[i].innerHTML;
      this.selectedMovie.name = movieTitle;
      
      console.log(this.movieDetails);
      console.log(this.selectedMovie);
      if(this.selectedMovie === this.movieDetails){
        console.log(this.movieDetails);
        
        return this.movieDetails
      }
    }
    this.modalServ.open(content, {ariaLabelledBy: 'my-modal'}).result.then((res)=>{
      this.closeModal=`Closed with: ${res}`;
    })
  }
}
