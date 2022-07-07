import {Component, OnInit} from '@angular/core';
import {MenuCategory} from "../../../types/interfaces";
import {MenuService} from "../../../services/backend/menu.service";

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.sass']
})
export class MenuComponent implements OnInit {
  menu?: MenuCategory[];

  constructor(private menuService: MenuService) {
  }

  ngOnInit(): void {
    this.menuService.getDishes().subscribe(dishes => this.menu = this.menuService.createMenu(dishes));
  }

}
