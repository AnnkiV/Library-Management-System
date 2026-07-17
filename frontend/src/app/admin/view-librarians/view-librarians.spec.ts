import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewLibrarians } from './view-librarians';

describe('ViewLibrarians', () => {
  let component: ViewLibrarians;
  let fixture: ComponentFixture<ViewLibrarians>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ViewLibrarians],
    }).compileComponents();

    fixture = TestBed.createComponent(ViewLibrarians);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
