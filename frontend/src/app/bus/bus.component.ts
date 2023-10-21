import {Component, EventEmitter, OnInit, Output, TemplateRef} from '@angular/core';
import { Bus} from "./bus";
import {BusService} from "./bus.service";
import { BsModalService, BsModalRef } from 'ngx-bootstrap/modal';
import {TicketService} from "../ticket/ticket.service";
import {Ticket} from "../ticket/ticket";
import {Journey} from "../journey";
import {Router} from "@angular/router";
import {SeatService} from "../seat/seat.service";
import {Seat} from "../seat/seat";

@Component({
  selector: 'app-bus',
  templateUrl: './bus.component.html',
  styleUrls: ['./bus.component.css']
})
export class BusComponent implements OnInit {

  bus: Bus = new Bus();
  // @ts-ignore
  ticket: Ticket = new Ticket();
  // @ts-ignore
  searchResult: any[];
  journeyFrom!: any[];
  busTypes=['Ac','Non-Ac']
  searchText: any;
  modalRef!: BsModalRef;
  busId!:any;
  idOfTicket = new Ticket();
  ticket1!:number;
  showSeatList:Seat[]=[];
  @Output('closeModal') closeModal = new EventEmitter()
  total=0;
  fillupSeat:Seat[]=[];
  array=[];
  alert=false;
  seat = new Seat();
  duplicateId=new Seat();
  seatNo!:[];
  isBooked:boolean=false;

  constructor(private busService:BusService,
              private modalService: BsModalService,
              private ticketService:TicketService,
              private seatService:SeatService,
              private route:Router) {
  }

  ngOnInit(): void {

  }
  onSubmit(){
    }




  private getJourneyFrom(){
    this.busService.getJourneyFrom().subscribe(data => {
      this.journeyFrom = data;
    });
  }
  searchBus(){
    this.busService.searchBus(this.bus).subscribe( data =>{
        this.searchResult=data as any[];
      },
      error => console.log(error));
  }

  //@ts-ignore
  seletedBus(result){
    this.ticket.busId=result;
    this.busId=result;
    this.ticketService.createTicket(this.ticket).subscribe((response: any) =>{
      this.idOfTicket.id = response.id;
      this.idOfTicket.busId = response.busId;
      this.idOfTicket.userName = response.userName;
      this.idOfTicket.email = response.email;
      this.idOfTicket.mobileNo = response.mobileNo;

      //@ts-ignore
      this.seatService.getSeatByBusID(result.id).subscribe(data =>{
        this.seatNo = data;
        this.isBooked=true;
        for(let i=0;i<this.seatNo.length;i++){
          // @ts-ignore
          let id = document.getElementById(this.seatNo[i]);
          // @ts-ignore
          id.style.pointerEvents='none';
          // @ts-ignore
          id.innerHTML = `   <img src="../assets/img/bookseat.png" alt="">

         `
        }
      })
      // @ts-ignore
      let confirmTicket :Ticket={
        id:result.id
      }
      localStorage.setItem("confirmTicket",JSON.stringify(confirmTicket))
    })
  }


  // @ts-ignore     -------------------------select seat start-------------
  Seat(e) {
    // @ts-ignore
    this.ticket = JSON.parse(localStorage.getItem("confirmTicket"))
    this.ticket1=Number(this.ticket.id);
    console.log('ticket id==',this.idOfTicket.id)
    console.log('bus id==',this.busId)
    this.fillupSeat.push(e);
    // @ts-ignore
    let id = document.getElementById(e);

    let forFillupSeat=e;
    let forShowSeatList=e;
    let duplicate =this.countDuplicates(this.fillupSeat);
    forFillupSeat=duplicate.toString();
    if(duplicate.length<1){
      // @ts-ignore
        if((this.showSeatList.length!=4)) {
          // @ts-ignore
          id.innerHTML = `   <img src="../assets/img/fseat.png" alt="">`
          //@ts-ignore
          this.busService.getBusById(this.ticket1).subscribe(data =>{
            this.bus=data;
            let seat={
              busId:this.ticket1,
              ticketId:this.idOfTicket.id,
              seatNo:e,
              fare:data.fare,
              seatClass:data.busTypes
            }
            this.showList(seat);
            this.totalFare(seat.fare);
          })
        }
        else{
          this.alert=true;
        }
    }else{
      // @ts-ignore
      id.innerHTML = `   <img src="../assets/img/bseat.png" alt="">`
      forShowSeatList=this.fillupSeat.indexOf(forFillupSeat);
      this.showSeatList.splice(this.showSeatList.indexOf(this.showSeatList[forShowSeatList]), 1);
      this.fillupSeat.splice(this.fillupSeat.indexOf(forFillupSeat), 1);
      this.fillupSeat.splice(this.fillupSeat.indexOf(forFillupSeat), 1);
      //@ts-ignore
      this.busService.getBusById(this.ticket1).subscribe(data => {
        let seat={
          seatNo:e,
          fare:data.fare,
          seatClass:data.busTypes
        }
        this.totalFare((seat.fare)*(-1));
      })
    }
  }


  //@ts-ignore
  countDuplicates(arr) {
    var cache = [];
    var results = [];
    for (var i = 0, len = arr.length; i < len; i++) {
      if(cache[arr[i]] === true){
        results.push(arr[i]);
      }else{
        cache[arr[i]] = true;
      }
    }
    return results;
  }

  // @ts-ignore
  showList(seat){
    this.showSeatList.push(seat);
  }
  // @ts-ignore
  totalFare(fare){
    this.total+=fare;
  }



  confirmSeat(){
    /////saving seats in database
    this.seatService.saveSeatList(this.showSeatList).subscribe( data =>{
    })

    this.bus.seatAvailable=this.bus.seatAvailable-this.showSeatList.length;
    //@ts-ignore
    this.busService.updateBus(this.bus).subscribe((response: any) =>{
    })

    let journey :Ticket={
      id:this.idOfTicket.id,
      busId:this.idOfTicket.busId,
      seat:this.idOfTicket.seat,
      userName:this.idOfTicket.userName,
      email:this.idOfTicket.email,
      mobileNo:this.idOfTicket.mobileNo
    }
    localStorage.setItem("journey",JSON.stringify(journey))
    this.route.navigate(['ticket']);
  }

}
