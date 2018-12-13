import { TestBed } from '@angular/core/testing';

import { FreegiversService } from './freegivers.service';

describe('FreegiversService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: FreegiversService = TestBed.get(FreegiversService);
    expect(service).toBeTruthy();
  });
});
