import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Article} from '../model/article';
import {Dvd} from '../model/dvd';
import {Bluray} from '../model/bluray';

@Injectable({
  providedIn: 'root'
})
export class ArticleService {

  url: string = 'http://localhost:8080/demo';
  header: HttpHeaders;

  constructor(private http: HttpClient) {
    this.header = new HttpHeaders({'Content-type': 'application/json', 'Authorization': 'Basic ' + btoa('olivier:olivier')});
  }

  public list(): Observable<Article[]> {
    return this.http.get<Article[]>(`${this.url}/rest/article/`, {headers: this.header});
  }

  public delete(id: number): Observable<any> {
    return this.http.delete(`${this.url}/rest/article/${id}`, {headers: this.header});
  }

  public findById(id: number): Observable<Article> {
    return this.http.get<Article>(`${this.url}/rest/article/${id}`, {headers: this.header});
  }

  public save(article: Article): Observable<any> {
    if (article.id) {
      return this.http.put(`${this.url}/rest/article/`, article, {headers: this.header});
    } else {
      /* return this.http.post(`${this.url}/rest/adherent/`, adherent);*/
      if (article instanceof Dvd) {
        const o = {
          id: article.id, nbDisques: article.nbDisques, bonus: article.bonus
        };
        console.log(o);
        return this.http.post(`${this.url}/rest/article/`, o);
      } else if (article instanceof Bluray) {
        const o = {
          id: article.id, nbDisques: article.nbDisques, bonus: article.troisD
        };
        console.log(o);
        return this.http.post(`${this.url}/rest/article/`, o, {headers: this.header});

      }

    }
  }


}
