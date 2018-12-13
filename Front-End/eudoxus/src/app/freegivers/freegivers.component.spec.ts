import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FreegiversComponent } from './freegivers.component';

describe('FreegiversComponent', () => {
  let component: FreegiversComponent;
  let fixture: ComponentFixture<FreegiversComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FreegiversComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FreegiversComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
