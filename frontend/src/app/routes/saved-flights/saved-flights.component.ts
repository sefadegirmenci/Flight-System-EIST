import {Component, OnInit} from '@angular/core';
import {UserService} from "../../services/users/user-service.service";

@Component({
  selector: 'app-saved-flights',
  templateUrl: './saved-flights.component.html',
  styleUrls: ['./saved-flights.component.sass']
})
export class SavedFlightsComponent implements OnInit {

  constructor(private userService: UserService) {
  }

  ngOnInit(): void {
  }

  getPastFlights() {
    return this.userService.getUser()?.getPastFlights();
  }

  getCurrentFlights() {
    return this.userService.getUser()?.getCurrentFlights();
  }

  getFutureFlights() {
    return this.userService.getUser()?.getFutureFlights();
  }
}
