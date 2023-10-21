import { Component, OnInit } from '@angular/core';
import { ContactUs } from './contact-us';
import { ContactUsService } from './contact-us.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-contact-us',
  templateUrl: './contact-us.component.html',
  styleUrls: ['./contact-us.component.css']
})
export class ContactUsComponent implements OnInit {

  contactUs: ContactUs = new ContactUs();
  constructor(private employeeService: ContactUsService,
              private router: Router) { }

  ngOnInit(): void {
  }

  saveEmployee(){
    this.employeeService.createEmployee(this.contactUs).subscribe( data =>{
        console.log(data);
        this.goToEmployeeList();
      },
      error => console.log(error));
  }

  goToEmployeeList(){
    this.router.navigate(['/employees']);
  }

  onSubmit(){
    console.log(this.contactUs);
    this.saveEmployee();
  }
}

