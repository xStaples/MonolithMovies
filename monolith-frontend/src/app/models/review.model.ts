export class Review {
    id: number;
    reviewScore: number;
    reviewText: string;
    movieFk: number;
    userFk: number;



    constructor(id: number, reviewScore: number, reviewText: string, movieFk: number, userFk: number) {
        this.id = id;
        this.reviewScore = reviewScore;
        this.reviewText = reviewText;
        this.movieFk = movieFk;
        this.userFk = userFk;
    }
}