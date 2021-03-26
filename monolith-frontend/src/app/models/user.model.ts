export class User {

    username: string;
    password: string;
    firstName: string;
    lastName: string;
    userTypeFk: number;


    constructor(username: string, password: string, firstName: string, lastName: string, userTypeFk: number) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userTypeFk = userTypeFk;
    }
}