import {Component, OnInit, HostListener, Input} from '@angular/core';


@Component({
  selector: 'app-asc-bold,[app-asc-bold]',
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


  @HostListener('click') click() {

    alert(this.nom);
  }
}
