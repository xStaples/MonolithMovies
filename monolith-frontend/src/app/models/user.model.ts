export class User {
    username: string;
    password: string;
    firstName: string;
    lastName: string;
    userType: number;

    constructor(username: string, password: string, firstName: string, lastName: string, userType: number) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userType = userType
    }
}