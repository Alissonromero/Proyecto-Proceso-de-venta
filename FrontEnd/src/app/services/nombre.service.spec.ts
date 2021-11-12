import { TestBed } from '@angular/core/testing';

import { NombreService } from './nombre.service';

describe('NombreService', () => {
  let service: NombreService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(NombreService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
