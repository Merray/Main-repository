import {Component, HostListener, Input, OnInit} from '@angular/core';
import {ClientComponent} from '../client/client.component';
import {text} from '@angular/core/src/render3/instructions';

@Component({
  selector: 'app-asc-bold-element, [app-asc-bold-element]',
  templateUrl: './asc-bold-element.component.html',
  styleUrls: ['./asc-bold-element.component.css']
})
export class AscBoldElementComponent implements OnInit {

  @Input() text: string;
  @Input() prefix: string;

  constructor() {
  }

  ngOnInit() {
  }

}
