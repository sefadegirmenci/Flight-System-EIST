import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SavedFlightsComponent } from './saved-flights.component';

describe('SavedFlightsComponent', () => {
  let component: SavedFlightsComponent;
  let fixture: ComponentFixture<SavedFlightsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SavedFlightsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SavedFlightsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
