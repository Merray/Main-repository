import {Component, OnInit} from '@angular/core';
import {Client} from '../model/client';
import {clients} from '../listeClients';
import {ActivatedRoute, Router} from '@angular/router';


@Component({
  selector: 'app-crud-client-edit',
  templateUrl: './crud-client-edit.component.html',
  styleUrls: ['./crud-client-edit.component.css']
})
export class CrudClientEditComponent implements OnInit {

  client: Client = new Client();
  index = -1;

  constructor(private ar: ActivatedRoute, private router: Router) {
  }


  ngOnInit() {
    this.ar.paramMap.subscribe(map => {
      if (map.get('id')) {
        this.index = +map.get('id');
        this.client = clients[this.index];
        console.log('param');
      }
    });
  }

  public save() {
    if (this.index === -1) {
      clients.push(this.client);
    } else {
      clients[this.index] = this.client;
    }
    this.client = new Client();
    this.index = -1;
    this.router.navigate(['/crud', 'client', 'list']);
  }
}
