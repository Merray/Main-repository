import {Component, OnInit} from '@angular/core';
import {Client} from '../client/client';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-client-edit',
  templateUrl: './client-edit.component.html',
  styleUrls: ['./client-edit.component.css']
})
export class ClientEditComponent implements OnInit {

  private _client: Client = new Client();
  index: number = null;

  constructor(private ar: ActivatedRoute, private router: Router) {

  }

  ngOnInit() {
    this.ar.paramMap.subscribe(map => {
      this.index = +map.get('id');
      this.client = clientList[this.index];
    });
  }

  public save() {

    if (this.index == null) {
      clientList.push(this.client);

    } else {
      clientList[this.index] = this.client;
    }
    this.client = new Client();
    this.router.navigate(['/clients']);
  }

  get client(): Client {
    return this._client;
  }

  set client(value: Client) {
    this._client = value;
  }
}
