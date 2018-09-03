import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-test',
  templateUrl: './test.component.html',
  styleUrls: ['./test.component.css']
})
export class TestComponent implements OnInit {

  private _prenom: string = 'Jimmy';
  private _nbClick: number = 0;

  constructor() {
  }

  ngOnInit() {
  }

  public get prenom() {
    return this._prenom;
  }

  public set prenom(_prenom: string) {
    this._prenom = _prenom;
  }

  public get nbClick(): number {
    return this._nbClick;
  }

  public set nbClick(value: number) {
    this._nbClick = value;
  }

  public click() {
    this._nbClick++;
  }
}
