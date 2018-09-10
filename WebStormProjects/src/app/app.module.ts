import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {TestComponent} from './test/test.component';
import {FormsModule} from '@angular/forms';
import {ClientComponent} from './client/client.component';
import {AscBoldComponent} from './asc-bold/asc-bold.component';
import {AscBoldElementComponent} from './asc-bold-element/asc-bold-element.component';
import {AscTooltipComponent} from './asc-tooltip/asc-tooltip.component';
import {ListClientsComponent} from './list-clients/list-clients.component';
import {RouterModule} from '@angular/router';
import {routes} from './route';
import {tab} from './tab';
import { ClientDetailComponent } from './client-detail/client-detail.component';
import { ClientEditComponent } from './client-edit/client-edit.component';
import { ClientCategoryPipe } from './client-category.pipe';


@NgModule({
  declarations: [
    AppComponent,
    TestComponent,
    ClientComponent,
    AscBoldComponent,
    AscBoldElementComponent,
    AscTooltipComponent,
    ListClientsComponent,
    ClientDetailComponent,
    ClientEditComponent,
    ClientCategoryPipe,
  ],
  imports: [
    BrowserModule, FormsModule, RouterModule.forRoot(routes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
