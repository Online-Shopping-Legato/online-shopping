import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BehaviorSubject } from 'rxjs';
import { FetchItemsComponent } from '../fetch-items/fetch-items.component';


@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {
  cartDataList:any =[];
  productList= new BehaviorSubject<any>([]);  
    constructor() { }

    addItem(product:any){
      this.cartDataList.push(product);
      this.productList.next(this.cartDataList)
      this.getTotal();
      console.log(this.cartDataList)
    }

    removeAllItem(){
      this.cartDataList =[];
      this.productList.next(this.cartDataList)
    }

    getTotal(){
      let grandTotal =0;
      this.cartDataList.map((a:any)=>{
        grandTotal += a.total;
      })

    }

  ngOnInit(): void {
   
  }

}
