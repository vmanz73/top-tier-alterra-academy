import { Component, OnInit } from '@angular/core';
import { from, interval, Subscription } from 'rxjs';
import { map } from 'rxjs/operators';

@Component({
  selector: 'app-main-form',
  templateUrl: './main-form.component.html',
  styleUrls: ['./main-form.component.css'],
})
export class MainFormComponent implements OnInit {
  data: { [id: string]: any } = {};


  constructor() {}

  ngOnInit(): void {}

  onSubmit(e: any): void {
    let id = (<HTMLInputElement>document.getElementById('data_id')).value;
    let name = (<HTMLInputElement>document.getElementById('name')).value;
    let city = (<HTMLInputElement>document.getElementById('city')).value;
    console.log(name);
    console.log(city);

    this.data[id] = {
      "name": name,
      "city": city,
    };
    (<HTMLInputElement>document.getElementById('data_id')).value = "";
    (<HTMLInputElement>document.getElementById('name')).value = "";
    (<HTMLInputElement>document.getElementById('city')).value = "";
  }

  onEdit(id:string): void{
    (<HTMLInputElement>document.getElementById('data_id')).value = id;
    (<HTMLInputElement>document.getElementById('name')).value = this.data[id].name;
    (<HTMLInputElement>document.getElementById('city')).value = this.data[id].city;
  }

  onDelete(id:string): void{
    delete this.data[id];
  }

}
