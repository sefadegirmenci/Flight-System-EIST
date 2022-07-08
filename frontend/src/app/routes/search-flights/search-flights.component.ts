import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import {FlightsService} from "../../services/backend/flights.service";
import {FlightInterface} from "../../types/interfaces";


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

  flights?: FlightInterface[];

  public airports: string[] = ["MUC", "BER", "VIE"];

  constructor(private flightService: FlightsService) {
  }

  ngOnInit(): void {
    this.flightService.getFlights().subscribe(data => this.setFlights(data));
  }

  public trackFlights(index: number, item: FlightInterface) {
    return item.id;
  }

  private setFlights(data: FlightInterface[]) {
    this.flights = data;
    console.log(this.flights)
  }
}
