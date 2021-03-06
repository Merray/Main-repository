import {Routes} from '@angular/router';
import {ClientComponent} from './client/client.component';
import {TestComponent} from './test/test.component';
import {ClientDetailComponent} from './client-detail/client-detail.component';
import {CrudClientComponent} from './crud-client/crud-client.component';
import {CrudClientEditComponent} from './crud-client-edit/crud-client-edit.component';
import {AdherentComponent} from './adherent/adherent.component';
import {AdherentEditComponent} from './adherent/adherent-edit.component';

export const routes: Routes = [{path: 'home', component: TestComponent},
  {path: 'client', component: ClientComponent},
  {path: 'client/:nom', component: ClientDetailComponent},
  {path: 'crud/client/list', component: CrudClientComponent},
  {path: 'crud/client/edit', component: CrudClientEditComponent},
  {path: 'crud/client/edit/:id', component: CrudClientEditComponent},
  {path: 'adherent', component: AdherentComponent},
  {path: 'adherent/create', component: AdherentEditComponent},
  {path: 'adherent/edit/:id', component: AdherentEditComponent},
  {path: '', redirectTo: 'home', pathMatch: 'full'}];

