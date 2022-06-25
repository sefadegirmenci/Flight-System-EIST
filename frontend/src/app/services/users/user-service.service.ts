import {Injectable} from '@angular/core';
import {User} from "../../types/user";
import {Router} from "@angular/router";
import {Flight} from "../../types/flight";

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

      user.saveFlight(new Flight("BER", "MUC", "Lufthansa", new Date("2022-06-22T06:00:00Z"), new Date("2022-06-22T08:00:00Z")));
      user.saveFlight(new Flight("MUC", "GRZ", "KLM", new Date("2022-06-25T06:00:00Z"), new Date("2022-06-25T20:00:00Z")));
      user.saveFlight(new Flight("BER", "MUC", "Lufthansa", new Date("2022-06-26T06:00:00Z"), new Date("2022-06-26T08:00:00Z")));
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
