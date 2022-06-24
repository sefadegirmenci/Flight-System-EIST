export class Flight {
  public constructor(private _departureAirport: string, private _arrivalAirport: string, private _airline: string) {
  }

  get departureAirport(): string {
    return this._departureAirport;
  }

  get arrivalAirport(): string {
    return this._arrivalAirport;
  }

  get airline(): string {
    return this._airline;
  }
}
