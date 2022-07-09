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
import {HashLocationStrategy, LocationStrategy} from "@angular/common";
import {ProfileComponent} from './routes/profile/profile.component';
import {MatSelectModule} from "@angular/material/select";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {LoginComponent} from './routes/login/login.component';
import {MatInputModule} from "@angular/material/input";
import {SavedFlightsComponent} from "./routes/saved-flights/saved-flights.component";
import {FlightCardComponent} from './templates/flight-card/flight-card.component';
import {InFlightServicesComponent} from './routes/in-flight-services/in-flight-services.component';
import {EntertainmentComponent} from './routes/in-flight-services/entertainment/entertainment.component';
import {MenuComponent} from './routes/in-flight-services/menu/menu.component';
import {MatTabsModule} from "@angular/material/tabs";
import {SearchFlightsComponent} from "./routes/search-flights/search-flights.component";
import {MatAutocompleteModule} from "@angular/material/autocomplete";
import {MatDatepickerModule} from "@angular/material/datepicker";
import {MAT_DATE_LOCALE, MatNativeDateModule} from "@angular/material/core";
import {HttpClientModule} from "@angular/common/http";

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
    SearchFlightsComponent,
    FlightCardComponent,
    InFlightServicesComponent,
    EntertainmentComponent,
    MenuComponent
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
    MatInputModule,
    MatTabsModule,
    MatAutocompleteModule,
    MatDatepickerModule,
    MatNativeDateModule,
    HttpClientModule
  ],
  providers: [{provide: LocationStrategy, useClass: HashLocationStrategy}, {
    provide: MAT_DATE_LOCALE,
    useValue: 'de-DE'
  }],
  bootstrap: [AppComponent]
})
export class AppModule {
  constructor(private injector: Injector) {
    AppInjector = this.injector;
  }
}

export let AppInjector: Injector;

