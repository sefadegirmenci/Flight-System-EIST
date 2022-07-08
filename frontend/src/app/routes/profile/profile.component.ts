import {Component, OnInit} from '@angular/core';
import {Theme} from "../../types/interfaces";
import {ThemeService} from "../../services/themes/theme-service.service";
import {UserService} from "../../services/users/user-service.service";
import {User} from "../../types/user";
import {Router} from "@angular/router";

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.sass']
})
export class ProfileComponent implements OnInit {
  public themes: Theme[] = this.themeService.getThemeOptions();
  public selectedTheme: Theme = this.themeService.getTheme();
  user!: User;

  constructor(private themeService: ThemeService, private userService: UserService, private router: Router) {
    let user = userService.getUser();
    if (user) {
      this.user = user;
    } else {
      router.navigate(["/", "login"]);
    }
  }

  ngOnInit(): void {
  }

  setTheme(theme: Theme) {
    console.log("Setting theme to: " + theme.label)
    this.themeService.setTheme(theme);
  }

  getGreeting() {
    return "Hello, " + this.userService.getUser()?.firstName + " " + this.userService.getUser()?.lastName + "!";
  }
}
