import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http'
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { FormsModule} from '@angular/forms';
import { BusComponent } from './bus/bus.component';
import { AboutUsComponent } from './about-us/about-us.component';
import { ContactUsComponent } from './contact-us/contact-us.component'
import {NgOptimizedImage} from "@angular/common";
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { SeatComponent } from './seat/seat.component';
import { ModalModule } from 'ngx-bootstrap/modal';
import { TicketComponent } from './ticket/ticket.component';
import { PrintComponent } from './print/print.component';


//import {Ng2SearchPipeModule} from "ng2-search-filter";


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    BusComponent,
    AboutUsComponent,
    ContactUsComponent,
    BusComponent,
    SeatComponent,
    TicketComponent,
    PrintComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    FontAwesomeModule,
    ModalModule.forRoot(),
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

