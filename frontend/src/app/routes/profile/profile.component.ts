import {Component, OnInit} from '@angular/core';
import {Theme} from "../../types";
import {ThemeService} from "../../services/themes/theme-service.service";

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.sass']
})
export class ProfileComponent implements OnInit {
  public themes: Theme[] = this.themeService.getThemeOptions();
  public selectedTheme: Theme = this.themeService.getTheme();

  constructor(private themeService: ThemeService) {
  }

  ngOnInit(): void {
  }

  setTheme(theme: Theme) {
    console.log("Setting theme to: " + theme.label)
    this.themeService.setTheme(theme);
  }
}
