import {Injectable} from "@angular/core";
import {themes} from "../../../assets/themes";
import {Theme} from "../../types/interfaces";
import {StyleManagerService} from "./style-manager.service";
import {UserService} from "../users/user-service.service";

@Injectable({
  providedIn: 'root'
})
export class ThemeService {
  private themes: Theme[] = themes;

  constructor(private styleManager: StyleManagerService, private userService: UserService) {
  }

  public getThemeOptions() {
    return this.themes;
  }

  public setTheme(theme: Theme) {
    this.userService.getUser()?.setTheme(theme);

    this.styleManager.setStyle("theme", `assets/themes/${theme.value}.css`)
  }

  public getTheme() {
    let theme = this.userService.getUser()?.theme;
    if (theme) return theme;
    else return this.themes[1];
  }
}
