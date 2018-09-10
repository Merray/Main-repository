import {Component, OnInit} from '@angular/core';
import {Article} from '../model/article';
import {ArticleService} from '../service/article.service';


@Component({
  selector: 'app-article',
  templateUrl: './article.component.html',
  styleUrls: ['./article.component.css']
})
export class ArticleComponent implements OnInit {

  articles: Article[];

  constructor(private articleService: ArticleService) {
  }

  ngOnInit() {
    this.list();
  }

  public list() {
    this.articleService.list().subscribe(resp => {
      this.articles = resp;
    }, error => console.log(error));
  }

  public delete(id: number) {
    return this.articleService.delete(id).subscribe(resp => {
      this.list();
    });
  }


}
