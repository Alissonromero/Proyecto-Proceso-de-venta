import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddSedeComponent } from './add-sede.component';

describe('AddSedeComponent', () => {
  let component: AddSedeComponent;
  let fixture: ComponentFixture<AddSedeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddSedeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddSedeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
