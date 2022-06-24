export class Flight {
  public constructor(private _departureAirport: string, private _arrivalAirport: string, private _airline: string, private _departureTime: Date, private _arrivalTime: Date) {
    if (_arrivalTime <= _departureTime) {
      console.error("Arrival time is lower or equal to departure time.");
    }
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

  public getAirportConnection() {
    return this.departureAirport + "-" + this.arrivalAirport;
  }

  public isFuture() {
    return new Date() < this._departureTime;
  }

  public isCurrent() {
    let now = new Date();
    return this._departureTime < now && now < this._arrivalTime;
  }

  public isPast() {
    return this._arrivalTime < new Date();
  }
}
