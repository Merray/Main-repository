import {Component, HostListener, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-asc-tooltip',
  templateUrl: './asc-tooltip.component.html',
  styleUrls: ['./asc-tooltip.component.css']
})
export class AscTooltipComponent implements OnInit {

  @Input('asc-tooltip-titre')
  message: string;

  isVisible: boolean = false;

  constructor() {
  }

  ngOnInit() {
  }

  @HostListener('mouseenter')
  onMouseEnter() {
    this.isVisible = true;
  }

  @HostListener('mouseleave')
  onMouseLeave() {
    this.isVisible = false;
  }
}
