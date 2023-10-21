import {Component, OnInit} from '@angular/core';
import {Ticket} from "../ticket/ticket";
import {Router} from "@angular/router";
import {TicketService} from "../ticket/ticket.service";
import {SeatService} from "../seat/seat.service";

@Component({
  selector: 'app-print',
  templateUrl: './print.component.html',
  styleUrls: ['./print.component.css']
})

export class PrintComponent implements OnInit {
  confirmTicket:Ticket = new Ticket();
  userDetails:Ticket = new Ticket();
  id!:number;
  myDate!:Date;
  seatNo!:[];
  constructor(
    private route:Router,
    private ticketService:TicketService,
    private seatService:SeatService
  ) { }

  ngOnInit() {
    this.myDate = new Date();
    // @ts-ignore
    this.confirmTicket = JSON.parse(localStorage.getItem("journey"))
    this.id=Number(this.confirmTicket.id);
    this.seatService.getSeatByTickedID(this.id).subscribe(data => {
      this.seatNo = data;
    })
    this.ticketService.getTicketById(this.id).subscribe(data => {
      this.confirmTicket.id=this.id;
      this.confirmTicket.userName=data.userName;
      this.confirmTicket.email=data.email;
      this.confirmTicket.mobileNo=data.mobileNo;
    });
    if(!this.confirmTicket){
      this.route.navigate([''])
    }
  }

}

