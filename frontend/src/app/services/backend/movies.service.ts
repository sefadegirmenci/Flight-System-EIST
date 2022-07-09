import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Movie} from "../../types/interfaces";

@Injectable({
  providedIn: 'root'
})
export class MoviesService {

  constructor(private http: HttpClient) {
  }

  public getMovies() {
    return this.http.get<Movie[]>("http://20.117.224.156:8080/inflight/movies");
  }
}
