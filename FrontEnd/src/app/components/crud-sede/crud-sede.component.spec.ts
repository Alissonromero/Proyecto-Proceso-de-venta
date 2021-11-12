import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CrudSedeComponent } from './crud-sede.component';

describe('CrudSedeComponent', () => {
  let component: CrudSedeComponent;
  let fixture: ComponentFixture<CrudSedeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CrudSedeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CrudSedeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
