import { TestBed } from '@angular/core/testing';

import { SecretariatService } from './secretariat.service';

describe('SecretariatService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: SecretariatService = TestBed.get(SecretariatService);
    expect(service).toBeTruthy();
  });
});
