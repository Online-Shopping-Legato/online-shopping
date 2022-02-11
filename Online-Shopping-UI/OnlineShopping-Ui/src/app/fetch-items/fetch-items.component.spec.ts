import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FetchItemsComponent } from './fetch-items.component';

describe('FetchItemsComponent', () => {
  let component: FetchItemsComponent;
  let fixture: ComponentFixture<FetchItemsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FetchItemsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FetchItemsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
