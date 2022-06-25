import {Component, OnInit} from '@angular/core';
import {menu} from "../../../../assets/menu";

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.sass']
})
export class MenuComponent implements OnInit {
  menu = menu;

  constructor() {
  }

  ngOnInit(): void {
  }

}
