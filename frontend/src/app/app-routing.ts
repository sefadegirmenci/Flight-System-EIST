import {RouterModule, Routes} from '@angular/router';
import {SearchFlightsComponent} from "./routes/search-flights/search-flights.component";
import {SavedFlightsComponent} from "./routes/saved-flights/saved-flights.component";
import {OverviewComponent} from "./routes/overview/overview.component";
import {NgModule} from "@angular/core";
import {ProfileComponent} from "./routes/profile/profile.component";
import {LoginComponent} from "./routes/login/login.component";
import {InFlightServicesComponent} from "./routes/in-flight-services/in-flight-services.component";

const routes: Routes = [
  {
    path: '', component: OverviewComponent
  },
  {
    path: 'search', component: SearchFlightsComponent
  },
  {
    path: 'saved', component: SavedFlightsComponent
  },
  {path: 'profile', component: ProfileComponent},
  {path: 'login', component: LoginComponent},
  {path: 'inflight', component: InFlightServicesComponent},
  {path: '**', redirectTo: ''}
]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
