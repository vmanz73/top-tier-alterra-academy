import { Component, Input, OnInit } from '@angular/core';
import { FormControl, FormGroup, NgForm } from '@angular/forms';
import { PassengerService } from 'src/app/service/passenger.service';

@Component({
  selector: 'app-passenger-form',
  templateUrl: './passenger-form.component.html',
  styleUrls: ['./passenger-form.component.css']
})
export class PassengerFormComponent implements OnInit {

  @Input('formDataPassengger') formDataPassengger:any;


  constructor(private passengerService: PassengerService) {}

  ngOnInit(): void {
    this.formDataPassengger =  this.passengerService.form();
  }

  onSubmit() {
    let id = this.formDataPassengger.controls["id"].value;
    let data = this.formDataPassengger.value;
    if (id == '0' || id){
      this.passengerService.edit(id, data);
    }
    else{
      this.passengerService.add(data);
    }

    this.formDataPassengger.reset();
  }

}
