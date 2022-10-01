import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-main-data',
  templateUrl: './main-data.component.html',
  styleUrls: ['./main-data.component.css']
})
export class MainDataComponent implements OnInit {
data_form: any;

  constructor() { }

  ngOnInit(): void {
  }

  onSelectData(data: any) {
    this.data_form = data;
  }


}
