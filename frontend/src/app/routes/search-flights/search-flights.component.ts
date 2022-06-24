import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";


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

  public airports: string[] = ["MUC", "BER", "VIE"];

  constructor() {
  }

  ngOnInit(): void {
  }

}
