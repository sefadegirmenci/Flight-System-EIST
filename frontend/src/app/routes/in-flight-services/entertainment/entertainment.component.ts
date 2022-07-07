import {Component, OnInit} from '@angular/core';
import {movies} from "../../../../assets/movies";

@Component({
  selector: 'app-entertainment',
  templateUrl: './entertainment.component.html',
  styleUrls: ['./entertainment.component.sass']
})
export class EntertainmentComponent implements OnInit {
  movies = movies;

  constructor() {
  }

  ngOnInit(): void {
  }

}
