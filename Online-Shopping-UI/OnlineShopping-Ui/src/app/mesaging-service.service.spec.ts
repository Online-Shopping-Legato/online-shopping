import { TestBed } from '@angular/core/testing';

import { MesagingServiceService } from './mesaging-service.service';

describe('MesagingServiceService', () => {
  let service: MesagingServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MesagingServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
