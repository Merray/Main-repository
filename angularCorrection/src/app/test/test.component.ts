import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-test',
  templateUrl: './test.component.html',
  styleUrls: ['./test.component.css']
})
export class TestComponent implements OnInit {

  private _prenom: string = 'thibault';
  private _nbClick: number = 0;
  private _couleur = '00ff00';

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

  public click() {
    this._nbClick++;
  }

  get nbClick(): number {
    return this._nbClick;
  }

  set nbClick(value: number) {
    this._nbClick = value;
  }


  get couleur(): string {
    return this._couleur;
  }

  set couleur(value: string) {
    this._couleur = value;
  }


}
