import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CrudMarcaComponent } from './crud-marca.component';

describe('CrudMarcaComponent', () => {
  let component: CrudMarcaComponent;
  let fixture: ComponentFixture<CrudMarcaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CrudMarcaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CrudMarcaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
