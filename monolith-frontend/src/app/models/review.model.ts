export class Review {
    id: number;
    reviewScore: number;
    reviewText: string;
    movieFk: number;


    constructor(id: number, reviewScore: number, reviewText: string, movieFk: number) {
        this.id = id;
        this.reviewScore = reviewScore;
        this.reviewText = reviewText;
        this.movieFk = movieFk;

    }
}