import { Injectable } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { catchError, map, retry } from 'rxjs';
import { ConfigService } from 'src/app/service/config/config.service';

interface IArticle {
  id : number,
  title: string,
  description: string
}

@Injectable({
  providedIn: 'root'
})
export class ArticleService {

  details: any[] = [];
  article: any;

  formDataArticle = new FormGroup({
    title: new FormControl(),
    description: new FormControl(),
  });

  constructor(private apiService: ConfigService) { }

  public getAllArticle(){
    this.details = [];
    this.apiService.getAll('task').subscribe(data => {
      data.forEach((article: any) => {
        this.details.push(article);
      });
    });
    return this.details;
  }

  public form() {
    return this.formDataArticle;
  }

  public create(data:any) {
    this.apiService.create(data).subscribe(data => {
      console.log(data);
    });
  }

  public detail(id: number) {
    this.apiService.getById('task', id).pipe(retry(1))
    return this.article;
  }

  public deleteArticle(id: number) {
    this.apiService.deleteById('task', id);
    console.log(this.apiService.status);
  }

  public updateForm(id:number){
    this.apiService.getById('task', id).subscribe(res => {
      this.formDataArticle.patchValue({
        title: res.body.title,
        description: res.body.description
      });
      console.log(res);
    })
  }

  public updateArticle(data:any, id:number) {
    this.apiService.updateById(data, 'task', id).subscribe(data => {
      console.log(data);
    });
  }

}
