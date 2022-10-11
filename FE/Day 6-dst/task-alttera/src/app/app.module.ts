import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './component/home/home.component';
import { NavbarComponent } from './component/navbar/navbar.component';
import { PassengerFormComponent } from './component/passenger-form/passenger-form.component';
import { PassengerComponent } from './component/passenger/passenger.component';
import { PassengerDetailComponent } from './component/passenger-detail/passenger-detail.component';
import { HttpClientModule } from '@angular/common/http';
import { ArticleListComponent } from './component/article-list/article-list.component';
import { ArticleFormComponent } from './component/article-form/article-form.component';
import { ArticleDetailComponent } from './component/article-detail/article-detail.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    NavbarComponent,
    PassengerFormComponent,
    PassengerComponent,
    PassengerDetailComponent,
    ArticleListComponent,
    ArticleFormComponent,
    ArticleDetailComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    FormsModule,
    BrowserModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
