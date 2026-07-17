import { ComponentFixture, TestBed } from '@angular/core/testing';

import { IssuedBooks } from './issued-books';

describe('IssuedBooks', () => {
  let component: IssuedBooks;
  let fixture: ComponentFixture<IssuedBooks>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [IssuedBooks],
    }).compileComponents();

    fixture = TestBed.createComponent(IssuedBooks);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
