import {Component, OnInit} from '@angular/core';
import {AdherentService} from '../service/adherent.service';
import {Adherent} from '../model/adherent';

@Component({
  selector: 'app-adherent',
  templateUrl: './adherent.component.html',
  styleUrls: ['./adherent.component.css']
})
export class AdherentComponent implements OnInit {

  adherents: Adherent[];

  constructor(private adherentService: AdherentService) {
  }

  ngOnInit() {
    this.list();
  }

  public list() {
    this.adherentService.list().subscribe(resp => {
      this.adherents = resp;
    }, error => console.log(error));
  }

  public delete(id: number) {
    return this.adherentService.delete(id).subscribe(resp => {
      this.list();
    });
  }


}
