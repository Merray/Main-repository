import {Component, HostListener, Input, OnInit} from '@angular/core';
import {Client} from '../model/client';

@Component({
  selector: 'app-asc-bold, [app-asc-bold]',
  templateUrl: './asc-bold.component.html',
  styleUrls: ['./asc-bold.component.css']
})
export class AscBoldComponent implements OnInit {

  @Input()
  nom: string;


  constructor() {
  }

  ngOnInit() {
  }

  @HostListener('click')
  Alert() {
    console.log(this.nom);
  }

}
