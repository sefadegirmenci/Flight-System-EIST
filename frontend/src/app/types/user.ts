import {Flight, Theme} from "./interfaces";
import {ThemeService} from "../services/themes/theme-service.service";
import {AppInjector} from "../app.module";

export class User {
  private themeService: ThemeService;

  constructor(private _firstName: string, private _lastName: string) {
    this.themeService = AppInjector.get(ThemeService);
    this._theme = this.themeService.getTheme();
  }

  private _theme: Theme;

  get theme(): Theme {
    return this._theme;
  }

  get firstName(): string {
    return this._firstName;
  }

  get lastName(): string {
    return this._lastName;
  }

  private _savedFlights: Flight[] = [];

  get savedFlights(): Flight[] {
    return this._savedFlights;
  }

  public saveFlight(flight: Flight) {
    this._savedFlights.push(flight);
  }

  public setTheme(theme: Theme) {
    this._theme = theme;
  }

  public getPastFlights() {
    return this.getFlights(flight => false);
  }

  public getCurrentFlights() {
    return this.getFlights(flight => true);
  }

  public getFutureFlights() {
    return this.getFlights(flight => false);
  }

  private getFlights(filter: (flight: Flight) => boolean) {
    return this.savedFlights.filter(filter);
  }
}
