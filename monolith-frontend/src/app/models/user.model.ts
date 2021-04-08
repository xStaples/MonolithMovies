export class User {
    username: string;
    password: string;
    firstName: string;
    lastName: string;

    constructor(firstName: string, lastName: string, username: string, password: string) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}