import {Routes} from '@angular/router';
import {ClientComponent} from './client/client.component';
import {TestComponent} from './test/test.component';
import {ListClientsComponent} from './list-clients/list-clients.component';
import {ClientDetailComponent} from './client-detail/client-detail.component';
import {ClientEditComponent} from './client-edit/client-edit.component';

export const routes: Routes = [{path: 'home', component: TestComponent},
  {path: 'client', component: ClientComponent},
  {
    path: '',
    redirectTo: 'home',
    pathMatch: 'full'
  },
  {path: 'clients', component: ListClientsComponent},
  {path: 'client/:ca', component: ClientDetailComponent},
  {path: 'editClient', component: ClientEditComponent},
  {path: 'editClient/:id', component: ClientEditComponent}];
