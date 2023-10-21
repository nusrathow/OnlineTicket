import { Component, OnInit} from '@angular/core';
import { Journey} from "../journey";
import { Journey_Route} from "../route";
import { Router } from '@angular/router';
import { Bus} from "../bus/bus";
import { BusService} from "../bus/bus.service";
import { Subscription } from 'rxjs';
import {TicketService} from "../ticket/ticket.service";
import {Ticket} from "../ticket/ticket";
import {Seat} from "./seat";


@Component({
  selector: 'seat',
  templateUrl: './seat.component.html',
  styleUrls: ['./seat.component.css']
})
export class SeatComponent implements OnInit{

  // @ts-ignore
  subscription:Subscription;
  constructor(
    private route:Router,
    private BusService:BusService,
    private ticketService:TicketService
  ) { }

  ngOnInit() {
  }

}
