import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { ContactUs } from './contact-us';

@Injectable({
  providedIn: 'root'
})
export class ContactUsService {

  private baseURL = "http://localhost:8080/api/v1/contactUs";

  constructor(private httpClient: HttpClient) { }

  getEmployeesList(): Observable<ContactUs[]>{
    return this.httpClient.get<ContactUs[]>(`${this.baseURL}`);
  }

  createEmployee(employee: ContactUs): Observable<Object>{
    return this.httpClient.post(`${this.baseURL}`, employee);
  }

  getEmployeeById(id: number): Observable<ContactUs>{
    return this.httpClient.get<ContactUs>(`${this.baseURL}/${id}`);
  }

  updateEmployee(id: number, employee: ContactUs): Observable<Object>{
    return this.httpClient.put(`${this.baseURL}/${id}`, employee);
  }

  deleteEmployee(id: number): Observable<Object>{
    return this.httpClient.delete(`${this.baseURL}/${id}`);
  }
}
