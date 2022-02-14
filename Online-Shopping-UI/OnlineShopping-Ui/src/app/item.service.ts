import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ItemService {

 
  baseUrl='http://localhost:9898/product-service';

  constructor(private _httpClient:HttpClient) { }

  fetchItems() : Observable<any> {
     let url=`${this.baseUrl}/fetchAll`;
    return this._httpClient.get(url);
  }
}
