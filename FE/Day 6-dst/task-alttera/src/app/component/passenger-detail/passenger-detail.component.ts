import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { PassengerService } from 'src/app/service/passenger.service';

@Component({
  selector: 'app-passenger-detail',
  templateUrl: './passenger-detail.component.html',
  styleUrls: ['./passenger-detail.component.css']
})
export class PassengerDetailComponent implements OnInit {
  @Input('data') data: any;

  constructor(private route: ActivatedRoute,
    private passengerService: PassengerService) { }

  ngOnInit(): void {
    const id: number = this.route.snapshot.params['id'];
    this.data = this.passengerService.detail(id);
    this.data = {
      ...this.data,
      id: id
    }
  }

}
