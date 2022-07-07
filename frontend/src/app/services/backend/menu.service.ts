import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Dish, MenuCategory} from "../../types/interfaces";

@Injectable({
  providedIn: 'root'
})
export class MenuService {
  constructor(private http: HttpClient) {
  }

  public getDishes() {
    return this.http.get<Dish[]>("http://20.117.224.156:8080/inflight/items");
  }

  public createMenu(dishes: Dish[]) {
    let categories = new Set<string>();

    dishes.forEach(dish => categories.add(dish.category));

    let menuCategories: MenuCategory[] = [];

    for (let category of categories) {
      menuCategories.push({
        "name": category,
        "entries": dishes.filter(dish => dish.category == category)
      });
    }

    return menuCategories;
  }
}
