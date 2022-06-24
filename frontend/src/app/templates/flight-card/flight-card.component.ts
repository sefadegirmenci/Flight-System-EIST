import {Component, Input, OnInit} from '@angular/core';
import {Flight} from "../../types/flight";

@Component({
  selector: 'app-flight-card',
  templateUrl: './flight-card.component.html',
  styleUrls: ['./flight-card.component.sass']
})
export class FlightCardComponent implements OnInit {
  @Input()
  flight!: Flight;

  constructor() {
  }

  ngOnInit(): void {
  }

  getTitle() {
    return this.flight.departureAirport + " - " + this.flight.arrivalAirport;
  }
}
