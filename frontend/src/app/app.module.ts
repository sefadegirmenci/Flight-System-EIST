import {NgModule} from '@angular/core';
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
import {FormsModule} from "@angular/forms";

@NgModule({
  declarations: [
    AppComponent,
    CardComponent,
    CardCollectionComponent,
    ElevationDirective,
    OverviewComponent,
    ProfileComponent,
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
    FormsModule
  ],
  providers: [{provide: LocationStrategy, useClass: PathLocationStrategy}],
  bootstrap: [AppComponent]
})
export class AppModule {
}
