import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {MatToolbarModule} from "@angular/material/toolbar";

import {AppRoutingModule} from "./app-routing";
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { CardComponent } from './card/card.component';
import { MatCardModule } from "@angular/material/card";
import { CardCollectionComponent } from './card-collection/card-collection.component';
import {MatIconModule} from "@angular/material/icon";
import {MatButtonModule} from "@angular/material/button";
import {ElevationDirective} from "./card/ElevationDirective";
import {RouterModule} from "@angular/router";
import { OverviewComponent } from './routes/overview/overview.component';
import {HashLocationStrategy, LocationStrategy} from "@angular/common";
import { ProfileComponent } from './routes/profile/profile.component';

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
    AppRoutingModule
  ],
  providers: [{provide: LocationStrategy, useClass: HashLocationStrategy}],
  bootstrap: [AppComponent]
})
export class AppModule { }
