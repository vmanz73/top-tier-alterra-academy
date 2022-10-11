import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ArticleDetailComponent } from './component/article-detail/article-detail.component';
import { ArticleFormComponent } from './component/article-form/article-form.component';
import { ArticleListComponent } from './component/article-list/article-list.component';
import { HomeComponent } from './component/home/home.component';
import { PassengerDetailComponent } from './component/passenger-detail/passenger-detail.component';
import { PassengerComponent } from './component/passenger/passenger.component';

const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'passenger', component: PassengerComponent},
  {path: 'passenger/:id', component: PassengerDetailComponent},
  {path: 'article', component: ArticleListComponent},
  {
    path: 'article/form', // child route path
    component: ArticleFormComponent, // child route component that the router renders
  },
  {path: 'article/form/:id', component: ArticleFormComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
