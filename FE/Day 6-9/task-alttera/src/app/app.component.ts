import { Component, ElementRef, ViewChild } from '@angular/core';
import { PassengerService } from './service/passenger.service';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  constructor(public passengerService: PassengerService){

  }

  title = 'task-alttera';
  data = this.passengerService.get();
}

