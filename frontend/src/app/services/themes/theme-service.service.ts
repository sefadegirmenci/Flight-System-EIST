import {Injectable} from "@angular/core";
import {themes} from "../../../assets/themes";
import {Theme} from "../../types";
import {StyleManagerService} from "./style-manager.service";

@Injectable({
  providedIn: 'root'
})
export class ThemeService {
  private themes: Theme[] = themes;
  private activeTheme: Theme = themes[0];

  constructor(private styleManager: StyleManagerService) {
  }

  getThemeOptions() {
    return this.themes;
  }

  setTheme(theme: Theme) {
    this.activeTheme = theme;

    this.styleManager.setStyle("theme", `assets/themes/${theme.value}.css`)
  }

  getTheme() {
    return this.activeTheme;
  }
}
