import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router';
import { DataService } from '../data.service';

@Component({
  selector: 'app-cart-items',
  templateUrl: './cart-items.component.html',
  styleUrls: ['./cart-items.component.css']
})
export class CartItemsComponent implements OnInit {

  cartItems :any;
  res: any;
  total :number=0;

  constructor(private _activateRoute: ActivatedRoute, private _dataService: DataService) {
    this.cartItems = this._dataService.getData();
    console.log(this.cartItems);
  }

  ngOnInit(): void {
      for(let data of this.cartItems ){
          this.total=this.total+data.price;
      }
  }

}
