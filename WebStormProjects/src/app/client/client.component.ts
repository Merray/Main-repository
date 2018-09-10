import {Component, Input, OnInit} from '@angular/core';
import {Client} from './client';

@Component({
  selector: 'app-client',
  templateUrl: './client.component.html',
  styleUrls: ['./client.component.css']
})
export class ClientComponent implements OnInit {

  private _client: Client;

  constructor() {

  }

  ngOnInit() {
  }


  get client(): Client {
    return this._client;
  }

  set client(value: Client) {
    this._client = value;
  }
}
