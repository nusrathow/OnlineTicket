import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Bus} from "./bus";

@Injectable({
  providedIn: 'root'
})
export class BusService {

  private baseURL = "http://localhost:8089/api/bus/journeyFrom";
  private baseURL1 ="http://localhost:8089/api/bus/search";
  private baseURL2 ="http://localhost:8089/api/bus";
  constructor(private httpClient:HttpClient) { }

  getJourneyFrom(): Observable<Bus[]>{
    return this.httpClient.get<Bus[]>(`${this.baseURL}`);
  }

  searchBus(employee: Bus): Observable<Object>{
  return this.httpClient.post(`${this.baseURL1}`, employee);
}

  updateBus(bus: Bus): Observable<Object>{
    return this.httpClient.put(`${this.baseURL2}`, bus);
  }

  getBusById(id: number): Observable<any>{
    return this.httpClient.get<any>(`${this.baseURL2}/${id}`);
  }
}
