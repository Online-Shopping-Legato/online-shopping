import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class MesagingServiceService {

  subject = new Subject();
  //product:any=undefined;
  constructor() { }

  sentMsg(product:any){
    console.log(product);
    this.subject.next(product);
  }

  getMsg(){
    this.subject.asObservable();
  }
}
