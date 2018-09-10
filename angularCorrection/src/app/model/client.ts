export class Client {
  constructor(private _prenom?: string, private _nom?: string, private _ca?: number) {

  }

  get prenom(): string {
    return this._prenom;
  }

  set prenom(value: string) {
    this._prenom = value;
  }

  get nom(): string {
    return this._nom;
  }

  set nom(value: string) {
    this._nom = value;
  }

  get ca(): number {
    return this._ca;
  }

  set ca(value: number) {
    this._ca = value;
  }
}
