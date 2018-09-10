import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {Article} from '../model/article';
import {ArticleService} from '../service/article.service';
import {Dvd} from '../model/dvd';
import {Bluray} from '../model/bluray';


@Component({
  selector: 'app-article-edit',
  templateUrl: './article-edit.component.html',
  styleUrls: ['./article-edit.component.css']
})
export class ArticleEditComponent implements OnInit {

  article: Article;

  constructor(private articleService: ArticleService, private ar: ActivatedRoute, private router: Router) {

  }

  ngOnInit() {
    this.ar.params.subscribe(params => {
      /*  console.log(params);*/
      console.log(this.article);
      if (params.type === 'D') {
        this.article = new Dvd(true);
      } else if (params.type === 'B') {
        this.article = new Bluray(true);
      }
      if (params.id) {
        this.articleService.findById(params.id).subscribe(resp => {
          this.article = resp;
          console.log(this.article);
        });
      }
    });
  }

  public save() {
    this.articleService.save(this.article).subscribe(resp => {
      this.router.navigate([`/article`]);
    });
  }

}
