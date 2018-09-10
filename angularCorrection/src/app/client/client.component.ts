import {Component, Input, OnInit} from '@angular/core';
import {Client} from '../model/client';
import {_myclient} from '../tableauClients';

@Component({
  selector: 'app-client, [app-client]',
  templateUrl: './client.component.html',
  styleUrls: ['./client.component.css']
})
export class ClientComponent implements OnInit {

  private _client: Client = new Client('thibault', 'toutfeutoutflamme', 30000000000);
  private _clientb: Client = new Client('kim', 'petitzizi', 0.3);
  filtre: string = '';


  @Input('prefix') private _title: string;
  @Input() private _text: string;

  constructor() {
  }


  get client(): Client {
    return this._client;
  }

  set client(value: Client) {
    this._client = value;
  }

  get title(): string {
    return this._title;
  }

  set title(value: string) {
    this._title = value;
  }

  get text(): string {
    return this._text;
  }

  set text(value: string) {
    this._text = value;
  }


  get clientb(): Client {
    return this._clientb;
  }

  set clientb(value: Client) {
    this._clientb = value;
  }


  ngOnInit() {
  }

  addClient(p: string, n: string, c: number) {
    let clientnv = new Client();
    clientnv.prenom = p;
    clientnv.nom = n;
    clientnv.ca = c;
    _myclient.push(clientnv);
  }

  add() {
    _myclient.push(this.client);
    this.client = new Client();
  }

  supp(index: number): void {
    _myclient.splice(index, 1);
  }

  filter() {
    return _myclient.filter(c => c.nom.indexOf(this.filtre) !== -1);
  }
}
