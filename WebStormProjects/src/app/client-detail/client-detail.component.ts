import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {Client} from '../client/client';

@Component({
  selector: 'app-client-detail',
  templateUrl: './client-detail.component.html',
  styleUrls: ['./client-detail.component.css']
})
export class ClientDetailComponent implements OnInit {

  nomCLient: string;
  caClient: number;

  constructor(private route: ActivatedRoute) {
    this.route.paramMap.subscribe(params => this.caClient = + params.get('ca'));
  }

  ngOnInit() {
  }

}
