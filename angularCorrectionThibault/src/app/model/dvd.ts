import {Article} from './article';

export class Dvd extends Article {

  constructor(private _bonus: Boolean) {
    super();

  }


  get bonus(): Boolean {
    return this._bonus;
  }

  set bonus(value: Boolean) {
    this._bonus = value;
  }
}
