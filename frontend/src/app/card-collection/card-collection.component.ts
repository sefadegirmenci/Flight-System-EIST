import {Component, Input, OnInit} from '@angular/core';
import {CardEntry} from "../types";

@Component({
  selector: 'card-collection',
  templateUrl: './card-collection.component.html',
  styleUrls: ['./card-collection.component.sass']
})
export class CardCollectionComponent implements OnInit {
  @Input()
  cards!: CardEntry[];

  constructor() { }

  ngOnInit(): void {
  }

}
