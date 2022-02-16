import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DataService {
  private data = [{}];

  setData(val: any) {
    this.data = val;
  }

  getData() {
    let temp = this.data;
    return temp;
  }



}
