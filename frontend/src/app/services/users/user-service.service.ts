import {Injectable} from '@angular/core';
import {User} from "../../types/user";
import {Router} from "@angular/router";

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private user: User | null = null;

  constructor(private router: Router) {
  }

  private static authenticate(username: string, password: string) {
    if (username == "nico" && password == "1234") {
      let user = new User("Nico", "Trummer");

      return user;
    }
    return null;
  }

  public getUser() {
    return this.user;
  }

  public login(username: string, password: string) {
    let authenticatedUser = UserService.authenticate(username, password);
    this.user = authenticatedUser;
    return authenticatedUser != null;
  }

  public logout() {
    this.user = null;
    this.router.navigate(["/", "login"]);
  }
}
