import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddReclamoComponent } from './add-reclamo.component';

describe('AddReclamoComponent', () => {
  let component: AddReclamoComponent;
  let fixture: ComponentFixture<AddReclamoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddReclamoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddReclamoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
