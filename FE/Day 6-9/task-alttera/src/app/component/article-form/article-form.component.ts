import { Component, Input, OnInit } from '@angular/core';
import { ArticleService } from 'src/app/service/article.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-article-form',
  templateUrl: './article-form.component.html',
  styleUrls: ['./article-form.component.css']
})
export class ArticleFormComponent implements OnInit {
  @Input('formDataArticle') formDataArticle:any;
  @Input('articles') articles:any;

  constructor(private articleService: ArticleService, private router: Router, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.formDataArticle = this.articleService.form();
    const id: number = this.route.snapshot.params['id'];
    // console.log(id);
    if (id){
      this.articleService.updateForm(id);
    }
    else{
      this.formDataArticle.patchValue({
        title: '',
        description: ''
      });
    }
  }

  onSubmit(){

    let data = this.formDataArticle.value;
    // if (id == '0' || id){
    //   this.formDataArticle.edit(id, data);
    // }
    // else{
    //   this.formDataArticle.add(data);
    // }

    console.log(data);
    const id: number = this.route.snapshot.params['id'];
    if (id) {
      this.articleService.updateArticle(data, id);
    }
    else{
      this.articleService.create(data);
    }

    this.formDataArticle.reset();
    // this.articles = this.articleService.getAllArticle();
    // this.router.navigate(['article'])
  }

}
