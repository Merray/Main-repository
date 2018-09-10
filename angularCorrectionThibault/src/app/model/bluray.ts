import {Article} from './article';

export class Bluray extends Article {

  constructor(private _troisD: Boolean) {
    super();

  }


  get troisD(): Boolean {
    return this._troisD;
  }

  set troisD(value: Boolean) {
    this._troisD = value;
  }
}
