import { TestBed } from '@angular/core/testing';

import { DistributionpointService } from './distributionpoint.service';

describe('DistributionpointService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: DistributionpointService = TestBed.get(DistributionpointService);
    expect(service).toBeTruthy();
  });
});
