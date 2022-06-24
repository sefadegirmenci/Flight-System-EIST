import {Component, OnInit} from '@angular/core';
import {inflightEntries} from "../../../assets/inflightEntries";
import {CardEntry} from "../../types/interfaces";

@Component({
  selector: 'app-in-flight-services',
  templateUrl: './in-flight-services.component.html',
  styleUrls: ['./in-flight-services.component.sass']
})
export class InFlightServicesComponent implements OnInit {
  inFlightEntries: CardEntry[] = inflightEntries;

  constructor() {
  }

  ngOnInit(): void {
  }

}
