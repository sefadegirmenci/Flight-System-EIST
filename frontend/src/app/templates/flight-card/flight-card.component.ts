import {Component, Input, OnInit} from '@angular/core';
import {Flight} from "../../types/flight";
import {formatDate} from "@angular/common";

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

  getSubtitle() {
    return "Airline: " + this.flight.airline;
  }


  getText() {
    let formatString = 'MMMM d, y, h:mm:ss a z';
    let localeString = "en-US";
    return formatDate(this.flight.departureTime, formatString, localeString) + " - " + formatDate(this.flight.arrivalTime.toLocaleString(), formatString, localeString);
  }
}
