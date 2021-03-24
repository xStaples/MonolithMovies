export class User {
    id: number;
    username: string;
    password: string;
    firstName: string;
    lastName: string;
    userTypeFk: number;
    movieFk: number;

    constructor(id: number, username: string, password: string, firstName: string, lastName: string, userTypeFk: number, movieFk: number) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userTypeFk = userTypeFk;
        this.movieFk = movieFk;
    }
}