import { Component, OnInit } from '@angular/core';
import {overviewEntries} from "../../../assets/overviewEntries";
import {CardEntry} from "../../types";

@Component({
  selector: 'app-overview',
  templateUrl: './overview.component.html',
  styleUrls: ['./overview.component.sass']
})
export class OverviewComponent implements OnInit {
  public cards: CardEntry[] = overviewEntries;

  constructor() { }

  ngOnInit(): void {
  }

}
