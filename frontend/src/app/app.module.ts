import {Injector, NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {MatToolbarModule} from "@angular/material/toolbar";

import {AppRoutingModule} from "./app-routing";
import {AppComponent} from './app.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {CardComponent} from './templates/card/card.component';
import {MatCardModule} from "@angular/material/card";
import {CardCollectionComponent} from './templates/card-collection/card-collection.component';
import {MatIconModule} from "@angular/material/icon";
import {MatButtonModule} from "@angular/material/button";
import {ElevationDirective} from "./templates/card/ElevationDirective";
import {RouterModule} from "@angular/router";
import {OverviewComponent} from './routes/overview/overview.component';
import {LocationStrategy, PathLocationStrategy} from "@angular/common";
import {ProfileComponent} from './routes/profile/profile.component';
import {MatSelectModule} from "@angular/material/select";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {LoginComponent} from './routes/login/login.component';
import {MatInputModule} from "@angular/material/input";
import {SavedFlightsComponent} from "./routes/saved-flights/saved-flights.component";
import { FlightCardComponent } from './templates/flight-card/flight-card.component';

@NgModule({
  declarations: [
    AppComponent,
    CardComponent,
    CardCollectionComponent,
    ElevationDirective,
    OverviewComponent,
    ProfileComponent,
    LoginComponent,
    SavedFlightsComponent,
    FlightCardComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatCardModule,
    MatIconModule,
    MatButtonModule,
    RouterModule,
    AppRoutingModule,
    MatSelectModule,
    FormsModule,
    ReactiveFormsModule,
    MatInputModule
  ],
  providers: [{provide: LocationStrategy, useClass: PathLocationStrategy}],
  bootstrap: [AppComponent]
})
export class AppModule {
  constructor(private injector: Injector) {
    AppInjector = this.injector;
  }
}

export let AppInjector: Injector;

