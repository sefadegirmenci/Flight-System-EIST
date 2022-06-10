import {Component, OnInit} from '@angular/core';
import {ThemeService} from "./services/themes/theme-service.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.sass']
})
export class AppComponent implements OnInit {
  title = 'frontend';

  constructor(private themeService: ThemeService) {
  }

  ngOnInit(): void {
    this.themeService.setDefaultTheme();
  }
}
