import { Injectable } from '@angular/core';
import {Journey} from "../journey";
import {HttpClient} from "@angular/common/http";
import {Ticket} from "./ticket";
import {Observable} from "rxjs";
import {Bus} from "../bus/bus";

@Injectable({
  providedIn: 'root'
})
export class TicketService {

  private baseURL1 ="http://localhost:8089/api/ticket";

  constructor(private httpClient:HttpClient) { }

  createTicket(employee: Object): Observable<Object> {
    return this.httpClient.post(`${this.baseURL1}`, employee);
  }

  updateTicket(employee: Object): Observable<Object> {
    return this.httpClient.put(`${this.baseURL1}`, employee);
  }

  getTicketById(id: number): Observable<any>{
    return this.httpClient.get<any>(`${this.baseURL1}/${id}`);
  }

}
