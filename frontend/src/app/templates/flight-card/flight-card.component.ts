import {Component, Input, OnInit} from '@angular/core';
import {FlightInterface} from "../../types/interfaces";

@Component({
  selector: 'app-flight-card',
  templateUrl: './flight-card.component.html',
  styleUrls: ['./flight-card.component.sass']
})
export class FlightCardComponent implements OnInit {
  @Input()
  flight!: FlightInterface;

  constructor() {
  }

  ngOnInit(): void {
  }

  getTitle() {
    return this.flight.departureAirport.airportCode + " (" + this.flight.departureAirport.city + ") - (" + this.flight.arrivalAirport.airportCode + ") " + this.flight.arrivalAirport.city;
  }

  getSubtitle() {
    return "Airline: ";
  }


  getText() {
    let formatString = 'MMMM d, y, h:mm:ss a z';
    let localeString = "en-US";
    return "";
  }
}
