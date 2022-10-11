import { Component, Input, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { PassengerService } from 'src/app/service/passenger.service';

@Component({
  selector: 'app-passenger',
  templateUrl: './passenger.component.html',
  styleUrls: ['./passenger.component.css']
})
export class PassengerComponent implements OnInit {
  @Input('data') data:any;
  @Input('formDataPassengger') formDataPassengger:any;

  constructor(private passengerService: PassengerService) {}

  ngOnInit(): void {
    this.data =  this.passengerService.get();
    this.formDataPassengger = this.passengerService.form();
  }

  edit(id:number, data: any){
    this.formDataPassengger.patchValue({
      id: id,
      name: data.name,
      city: data.city
    });
  }

  delete(id: number) {
    this.passengerService.delete(id);
  }
}
