import { Component, Input, OnInit } from '@angular/core';
import { ArticleService } from 'src/app/service/article.service';

@Component({
  selector: 'app-article-list',
  templateUrl: './article-list.component.html',
  styleUrls: ['./article-list.component.css']
})
export class ArticleListComponent implements OnInit {
  @Input('articles') articles:any;

  constructor(private articleService : ArticleService) { }

  ngOnInit(): void {
    this.articles = this.articleService.getAllArticle();
  }

  onDelete(id: number){
    this.articleService.deleteArticle(id);
    // window.location.reload();
  }

  // onEdit(data: any){

  // }

}
