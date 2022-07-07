import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.sass'],
})
export class CardComponent implements OnInit {
  @Input()
  title!: string
  @Input()
  subTitle?: string
  @Input()
  imageUrl?: string
  @Input()
  imageAltText?: string
  @Input()
  text?: string
  @Input()
  link?: string

  constructor() {
  }

  ngOnInit(): void {
  }

}
