import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './component/home/home.component';
import { PassengerDetailComponent } from './component/passenger-detail/passenger-detail.component';
import { PassengerComponent } from './component/passenger/passenger.component';

const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'passenger', component: PassengerComponent},
  {path: 'passenger/:id', component: PassengerDetailComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
