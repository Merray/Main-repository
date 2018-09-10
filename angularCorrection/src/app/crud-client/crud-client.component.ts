import {Component, OnInit} from '@angular/core';
import {Client} from '../model/client';
import {clients} from '../listeClients';

@Component({
  selector: 'app-crud-client',
  templateUrl: './crud-client.component.html',
  styleUrls: ['./crud-client.component.css']
})
export class CrudClientComponent implements OnInit {

  constructor() {
  }

  ngOnInit() {
  }

  public list(): Array<Client> {
    return clients;
  }

  delete(index: number) {
    clients.splice(index, 1);
  }

}
