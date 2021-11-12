import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ConsultaReclamoComponent } from './consulta-reclamo.component';

describe('ConsultaReclamoComponent', () => {
  let component: ConsultaReclamoComponent;
  let fixture: ComponentFixture<ConsultaReclamoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ConsultaReclamoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ConsultaReclamoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});



