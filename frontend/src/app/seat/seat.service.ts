import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Seat} from "./seat";


@Injectable({
  providedIn: 'root'
})
export class SeatService {

  constructor(private httpClient:HttpClient) { }

  private baseURL = "http://localhost:8089/api/seat";
  private baseURL1 = "http://localhost:8089/api/seat/listOfSeat";

  getSeatByTickedID(ticketId: number): Observable<any>{
    return this.httpClient.get<any>(`${this.baseURL}/${ticketId}`);
  }

  getSeatByBusID(busId: number): Observable<any>{
    return this.httpClient.get<any>(`${this.baseURL}/${busId}`);
  }

  createSeat(employee: Seat): Observable<Object>{
    return this.httpClient.post(`${this.baseURL}`, employee);
  }

  saveSeatList(seat: Seat[]): Observable<Object>{
    return this.httpClient.post(`${this.baseURL1}`, seat);
  }
}
