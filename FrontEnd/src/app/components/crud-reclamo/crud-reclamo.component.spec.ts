import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CrudReclamoComponent } from './crud-reclamo.component';

describe('CrudReclamoComponent', () => {
  let component: CrudReclamoComponent;
  let fixture: ComponentFixture<CrudReclamoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CrudReclamoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CrudReclamoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
