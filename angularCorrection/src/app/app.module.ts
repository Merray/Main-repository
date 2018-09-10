import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {TestComponent} from './test/test.component';
import {FormsModule} from '@angular/forms';
import {ClientComponent} from './client/client.component';
import {AscBoldComponent} from './asc-bold/asc-bold.component';
import {AscBoldElementComponent} from './asc-bold-element/asc-bold-element.component';
import {AscTooltipComponent} from './asc-tooltip/asc-tooltip.component';
import {RouterModule} from '@angular/router';
import {routes} from './route';
import {ClientDetailComponent} from './client-detail/client-detail.component';
import {HomeComponent} from './home/home.component';
import {_myclient} from './tableauClients';
import {CrudClientComponent} from './crud-client/crud-client.component';
import {CrudClientEditComponent} from './crud-client-edit/crud-client-edit.component';
import {ClientCategoryPipePipe} from './client-category-pipe.pipe';
import {AdherentComponent} from './adherent/adherent.component';
import {AdherentService} from './service/adherent.service';
import {HttpClientModule} from '@angular/common/http';
import { AdherentEditComponent } from './adherent/adherent-edit.component';

@NgModule({
  declarations: [
    AppComponent,
    TestComponent,
    ClientComponent,
    AscBoldComponent,
    AscBoldElementComponent,
    AscTooltipComponent,
    ClientDetailComponent,
    HomeComponent,
    CrudClientComponent,
    CrudClientEditComponent,
    ClientCategoryPipePipe,
    AdherentComponent,
    AdherentEditComponent
  ],
  imports: [
    BrowserModule, FormsModule, RouterModule, RouterModule.forRoot(routes), HttpClientModule
  ],
  providers: [ClientCategoryPipePipe, AdherentService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
