import {Component, OnInit} from '@angular/core';
import {MoviesService} from "../../../services/backend/movies.service";
import {Movie} from "../../../types/interfaces";

@Component({
  selector: 'app-entertainment',
  templateUrl: './entertainment.component.html',
  styleUrls: ['./entertainment.component.sass']
})
export class EntertainmentComponent implements OnInit {
  movies?: Movie[];

  constructor(private moviesService: MoviesService) {
  }

  ngOnInit(): void {
    this.moviesService.getMovies().subscribe(movies => this.movies = movies);
  }
}
