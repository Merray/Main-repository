import {Component, OnInit} from '@angular/core';
import {AdherentService} from '../service/adherent.service';
import {ActivatedRoute, Router} from '@angular/router';
import {Adherent} from '../model/adherent';

@Component({
  selector: 'app-adherent-edit',
  templateUrl: './adherent-edit.component.html',
  styleUrls: ['./adherent-edit.component.css']
})
export class AdherentEditComponent implements OnInit {

  adherent: Adherent = new Adherent();

  constructor(private adherentService: AdherentService, private ar: ActivatedRoute, private router: Router) {

  }

  ngOnInit() {
    this.ar.params.subscribe(params => {
      /*  console.log(params);*/
      console.log(this.adherent);
      if (params.id) {
        this.adherentService.findBYId(params.id).subscribe(resp => {
          this.adherent = resp;
          console.log(this.adherent);
        });
      }
    });
  }

  public save() {
    this.adherentService.save(this.adherent).subscribe(resp => {
      this.router.navigate([`/adherent`]);
    });
  }

}
