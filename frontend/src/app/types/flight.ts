export class Flight {
  public constructor(private _departureAirport: string, private _arrivalAirport: string, private _airline: string, private _departureTime: Date, private _arrivalTime: Date) {
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


  get departureTime(): Date {
    return this._departureTime;
  }

  get arrivalTime(): Date {
    return this._arrivalTime;
  }
}
