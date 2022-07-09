import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import {FlightsService} from "../../services/backend/flights.service";
import {Airport, Flight} from "../../types/interfaces";
import {map, startWith} from "rxjs/operators";
import {Observable} from "rxjs";


@Component({
  selector: 'app-search-flights',
  templateUrl: './search-flights.component.html',
  styleUrls: ['./search-flights.component.sass']
})
export class SearchFlightsComponent implements OnInit {
  search = new FormGroup({
    departureAirport: new FormControl(''),
    arrivalAirport: new FormControl(''),
    fromDate: new FormControl(''),
    toDate: new FormControl(''),
  });

  flights?: Flight[];

  public airports: Map<string, Airport> = new Map();
  public filteredDepartureAirports?: Observable<Airport[]>;
  public filteredArrivalAirports?: Observable<Airport[]>;

  constructor(private flightService: FlightsService) {
  }

  ngOnInit(): void {
    this.flightService.getFlights().subscribe(flights => {
      this.setFlights(flights);

      for (let flight of flights) {
        for (let airport of [flight.arrivalAirport, flight.departureAirport]) {
          this.airports.set(airport.airportCode, airport);
        }
      }

      this.filteredDepartureAirports = this.search.controls["departureAirport"].valueChanges.pipe(
        startWith(""),
        map(value => this.getFilteredAirports(value || '')),
      );

      this.filteredArrivalAirports = this.search.controls["arrivalAirport"].valueChanges.pipe(
        startWith(""),
        map(value => this.getFilteredAirports(value || '')),
      );
    });
  }


  public track(index: number, item: Flight | Airport) {
    return item.id;
  }

  public executeSearch() {
    console.log(this.search.controls["departureAirport"]);
  }

  public getAirport(airportCode: string) {
    return this.airports.get(airportCode);
  }

  public airportToString(airport: Airport) {
    return airport.city + " (" + airport.airportCode + ")";
  }

  private getFilteredAirports(term: string): Airport[] {
    return Array.from(this.airports.values())
      .filter(airport => this.airportToString(airport).toLowerCase().includes(term.toLowerCase()));
  }

  private setFlights(data: Flight[]) {
    this.flights = data;
  }
}
