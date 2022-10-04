import { Injectable } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';

interface IUser {
  name: string,
  city: string
}

@Injectable({
  providedIn: 'root'
})
export class PassengerService {
  details: any[] = [];

  formDataPassengger = new FormGroup({
    id: new FormControl({value:"", disabled: true}),
    name: new FormControl(),
    city: new FormControl(),
  });

  constructor() { }

  public get() {
    return this.details;
  }

  public add(data: any) {
    this.details.push(data);
  }

  public edit(id: number, data: IUser){
    this.details[id] = data;
  }

  public delete(id: number){
    this.details.splice(id, 1)
  }

  public form() {
    return this.formDataPassengger
  }

  public detail(id: number) {
    return this.details[id];
  }
}
