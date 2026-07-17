import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddLibrarian } from './add-librarian';

describe('AddLibrarian', () => {
  let component: AddLibrarian;
  let fixture: ComponentFixture<AddLibrarian>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AddLibrarian],
    }).compileComponents();

    fixture = TestBed.createComponent(AddLibrarian);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
