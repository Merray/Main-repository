export abstract class Article {

  constructor(protected _id?: number, protected _nbDisques?: number) {

  }


  get id(): number {
    return this._id;
  }

  set id(value: number) {
    this._id = value;
  }


  get nbDisques(): number {
    return this._nbDisques;
  }

  set nbDisques(value: number) {
    this._nbDisques = value;
  }
}
