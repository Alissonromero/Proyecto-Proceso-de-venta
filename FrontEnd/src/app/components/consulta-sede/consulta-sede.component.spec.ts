import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ConsultaSedeComponent } from './consulta-sede.component';

describe('ConsultaSedeComponent', () => {
  let component: ConsultaSedeComponent;
  let fixture: ComponentFixture<ConsultaSedeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ConsultaSedeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ConsultaSedeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
