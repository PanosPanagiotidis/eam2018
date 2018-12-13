import { TestBed } from '@angular/core/testing';

import { DistributionpointsService } from './distributionpoints.service';

describe('DistributionpointsService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: DistributionpointsService = TestBed.get(DistributionpointsService);
    expect(service).toBeTruthy();
  });
});
