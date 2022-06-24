import {Component, OnInit} from '@angular/core';
import {ThemeService} from "./services/themes/theme-service.service";
import {UserService} from "./services/users/user-service.service";
import {Router} from "@angular/router";


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.sass']
})
export class AppComponent implements OnInit {
  title = 'frontend';

  constructor(private themeService: ThemeService, public userService: UserService, private router: Router) {
  }

  ngOnInit(): void {
    if (!this.userService.getUser()) {
      this.router.navigate(["/", "login"]);
    }
  }

  logout() {
    this.userService.logout();
  }
}
