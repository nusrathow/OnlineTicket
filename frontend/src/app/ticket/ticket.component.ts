import {Component, OnInit} from '@angular/core';
import {Journey} from "../journey";
import {Router} from "@angular/router";
import {TicketService} from "./ticket.service";
import {NgForm} from "@angular/forms";
import {Ticket} from "./ticket";
import {SeatService} from "../seat/seat.service";

@Component({
  selector: 'app-ticket',
  templateUrl: './ticket.component.html',
  styleUrls: ['./ticket.component.css']
})

export class TicketComponent implements OnInit {
  journey!: Journey;
  confirmTicket:Ticket = new Ticket();
  idOfTicket = new Ticket();
  ticket!:number;
  ticket1!:number;
  seatNo!:[];
  constructor(
    private ticketService: TicketService,
    private SeatService: SeatService,
    private route:Router
  ) { }

  ngOnInit() {
    // @ts-ignore
    this.confirmTicket = JSON.parse(localStorage.getItem("journey"))
    this.ticket1 = Number(this.confirmTicket.id);
    this.SeatService.getSeatByTickedID(this.ticket1).subscribe(data => {
      console.log('data',data);
      this.seatNo = data;
    })
  }


  onSubmit() {
    // @ts-ignore
    this.ticket = Number(this.confirmTicket.id);


    this.ticketService.getTicketById(this.ticket).subscribe(data => {
      this.idOfTicket.id = data.id;
      this.idOfTicket.busId = data.busId;
      this.idOfTicket.seat = data.seat;
      this.idOfTicket.userName = this.confirmTicket.userName;
      this.idOfTicket.email = this.confirmTicket.email;
      this.idOfTicket.mobileNo = this.confirmTicket.mobileNo;
      this.ticketService.updateTicket(this.idOfTicket).subscribe((response: any) => {
      })
    })

    this.route.navigate(['print']);
  }

}
