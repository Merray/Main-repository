import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CrudClientEditComponent } from './crud-client-edit.component';

describe('CrudClientEditComponent', () => {
  let component: CrudClientEditComponent;
  let fixture: ComponentFixture<CrudClientEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CrudClientEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CrudClientEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
