import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { BusComponent } from './bus/bus.component';
import { AboutUsComponent} from "./about-us/about-us.component";
import { ContactUsComponent} from "./contact-us/contact-us.component";
import {TicketComponent} from "./ticket/ticket.component";
import {PrintComponent} from "./print/print.component";


const routes: Routes = [
  {path: 'home', component: HomeComponent},
  {path: '', redirectTo: 'home', pathMatch: 'full'},
  {path: 'bus', component: BusComponent},
  {path: 'aboutUs', component: AboutUsComponent},
  {path: 'contactUs', component: ContactUsComponent},
  {path: 'ticket', component: TicketComponent},
  {path: 'print', component:PrintComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
