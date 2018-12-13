import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DistributionpointComponent } from './distributionpoint.component';

describe('DistributionpointComponent', () => {
  let component: DistributionpointComponent;
  let fixture: ComponentFixture<DistributionpointComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DistributionpointComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DistributionpointComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
