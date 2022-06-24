import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InFlightServicesComponent } from './in-flight-services.component';

describe('InFlightServicesComponent', () => {
  let component: InFlightServicesComponent;
  let fixture: ComponentFixture<InFlightServicesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InFlightServicesComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(InFlightServicesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
