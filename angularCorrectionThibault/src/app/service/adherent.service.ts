import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Adherent} from '../model/adherent';

@Injectable({
  providedIn: 'root'
})
export class AdherentService {

  url: string = 'http://localhost:8080/demo';
  header: HttpHeaders;

  constructor(private http: HttpClient) {
    this.header = new HttpHeaders({'Content-type': 'application/json', 'Authorization': 'Basic ' + btoa('olivier:olivier')});
  }

  public list(): Observable<Adherent[]> {
    return this.http.get<Adherent[]>(`${this.url}/rest/adherent/`, {headers: this.header});
  }

  public delete(id: number): Observable<any> {
    return this.http.delete(`${this.url}/rest/adherent/${id}`, {headers: this.header});
  }

  public findBYId(id: number): Observable<Adherent> {
    return this.http.get<Adherent>(`${this.url}/rest/adherent/${id}`, {headers: this.header});
  }

  public save(adherent: Adherent): Observable<any> {
    if (adherent.id) {
      return this.http.put(`${this.url}/rest/adherent/`, adherent, {headers: this.header});
    } else {
      /* return this.http.post(`${this.url}/rest/adherent/`, adherent);*/
      const o = {
        id: adherent.id, prenom: adherent.prenom, nom: adherent.nom
      };
      console.log(o);
      return this.http.post(`${this.url}/rest/adherent/`, o, {headers: this.header});
    }
  }


  /*  public list() {
      return this.http.get<Adherent[]>(`${this.url}/rest/adherent/`);
    }*/

}
