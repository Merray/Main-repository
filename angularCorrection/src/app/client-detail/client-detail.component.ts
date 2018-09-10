import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {extractStyleParams} from '@angular/animations/browser/src/util';

@Component({
  selector: 'app-client-detail',
  templateUrl: './client-detail.component.html',
  styleUrls: ['./client-detail.component.css']
})
export class ClientDetailComponent implements OnInit {

  nomClient: string;

  constructor(private route: ActivatedRoute) {
    this.route.paramMap.subscribe(params => {
      this.nomClient = params.get('nom');
    });
  }

  ngOnInit() {
  }

}
