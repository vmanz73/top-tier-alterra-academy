import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './component/home/home.component';
import { MainFormComponent } from './main-form/main-form.component';

const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'passenger', component: MainFormComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
