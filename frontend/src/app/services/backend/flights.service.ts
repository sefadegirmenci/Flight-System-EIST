import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {FlightInterface} from "../../types/interfaces";

@Injectable({
  providedIn: 'root'
})
export class FlightsService {

  constructor(private http: HttpClient) {
  }

  public getFlights() {
    return this.http.get<FlightInterface[]>("http://20.117.224.156:8080/flights");
  }
}
