import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  baseUrl='http://localhost:9090/product-service';
  customerURL="http://localhost:8989/ca";

  constructor(private _httpClient:HttpClient) { }


  //Fetch Product by id
  fetchEmployeeById(itemId:number) : Observable<any>{
    let url=`${this.baseUrl}/fetchById/${itemId}`;
    return this._httpClient.get(url);
  }

  storeCustomer(customer:any) : Observable<any>{
    console.log('--servicve-'+customer);
    let url=`${this.customerURL}/customer`;
    return this._httpClient.post(url,customer);
  }
}
