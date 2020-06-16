import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PravljenjeAgenataComponent } from './pravljenje-agenata.component';

describe('PravljenjeAgenataComponent', () => {
  let component: PravljenjeAgenataComponent;
  let fixture: ComponentFixture<PravljenjeAgenataComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PravljenjeAgenataComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PravljenjeAgenataComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
