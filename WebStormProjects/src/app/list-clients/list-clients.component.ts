import {Component, OnInit} from '@angular/core';
import {ClientComponent} from '../client/client.component';
import {Client} from '../client/client';

@Component({
  selector: 'app-list-clients, [app-list-clients]',
  templateUrl: './list-clients.component.html',
  styleUrls: ['./list-clients.component.css']
})
export class ListClientsComponent implements OnInit {

  private _client: Client = new Client();
  private _filtre: string = '';
  private _clientList: Array<Client> = [new Client('Franck', 'Fricelle', 1), new Client('Francky', 'Fricelly', -1), new Client('Francko', 'Fricello', 0)];

  constructor() {
  }

  ngOnInit() {
  }


  get clientList(): Array<Client> {
    return this._clientList;
  }

  set clientList(value: Array<Client>) {
    this._clientList = value;
  }


  get client(): Client {
    return this._client;
  }

  set client(value: Client) {
    this._client = value;
  }

  get filtre(): string {
    return this._filtre;
  }

  set filtre(value: string) {
    this._filtre = value;
  }

  public ajout() {
    this._clientList.push(this._client);
    this._client = new Client();
  }

  public supr(client: Client) {
    this._clientList.splice(this._clientList.indexOf(client), 1);
  }

  public filter() {
    return this.clientList.filter(c => c.nom.indexOf(this._filtre) !== -1 || c.prenom.indexOf(this._filtre) !== -1);
  }
}
