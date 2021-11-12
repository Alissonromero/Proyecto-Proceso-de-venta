import { TestBed } from '@angular/core/testing';

import { TipoReclamoService } from './tipo-reclamo.service';

describe('TipoReclamoService', () => {
  let service: TipoReclamoService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TipoReclamoService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});


